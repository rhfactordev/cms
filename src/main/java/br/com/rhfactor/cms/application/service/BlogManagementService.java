package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.BlogManagementUsercase;
import br.com.rhfactor.cms.application.port.in.commands.CreateBlogCommand;
import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Site;
import br.com.rhfactor.cms.infrastructure.error.exception.InvalidArgumentException;
import br.com.rhfactor.cms.infrastructure.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class BlogManagementService implements BlogManagementUsercase {

    private final SiteRepository siteRepository;
    private final BlogRepository blogRepository;

    @Override
    public Blog createBlog(CreateBlogCommand createBlogCommand) {

        // TODO: Verificar se a pessoa pode acessar esse site.

        Site site = siteRepository.findById( createBlogCommand.getSiteId() )
                .orElseThrow( () -> new NotFoundException( String.format( "site not found with id %s", createBlogCommand.getSiteId() ) ));


        // Quantos blogs eu posso ter em um site? Apenas 1 portanto se já exitir um blog deve emitir erro
        if( blogRepository.existsBySite( site ) ){
            throw new InvalidArgumentException( String.format( "site with id %s already has a blog", createBlogCommand.getSiteId() ) );
        }

        Blog blog = Blog.builder()
                .site( site )
                .title( createBlogCommand.getTitle() )
                .build();

        return blogRepository.save(blog);
    }

}
