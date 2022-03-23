package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.PrivateBlogUsecase;
import br.com.rhfactor.cms.application.port.in.PublicBlogUsecase;
import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.application.port.out.CategoryRepository;
import br.com.rhfactor.cms.application.port.out.PostRepository;
import br.com.rhfactor.cms.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrivateBlogService implements PrivateBlogUsecase {

    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;


    @Override
    public Page<Post> listPosts(PageableRequest pageableRequest) {
        Blog blog = getBlogFromSession();
        return postRepository.findPosts(blog, pageableRequest);
    }

    private Blog getBlogFromSession() {

        // TODO: Buscar site na sessão
        Site site = Site.builder().id( 1L ).build();

        return Blog.builder()
                .id(1L)
                .site( site )
                .build();
    }
}
