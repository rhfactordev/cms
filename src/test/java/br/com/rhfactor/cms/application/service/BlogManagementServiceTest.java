package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.commands.CreateBlogCommand;
import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Site;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @see BlogManagementService
 */
@ExtendWith(MockitoExtension.class)
class BlogManagementServiceTest {

    @Mock private SiteRepository siteRepository;
    @Mock private BlogRepository blogRepository;

    @InjectMocks
    private BlogManagementService service;

    @Test
    void createSiteBlog() {

        when( siteRepository.findById( any(Long.class) )).thenReturn(
            Optional.of( Site.builder().id(1L).build() )
        );

        when( blogRepository.existsBySite( any(Site.class) )).thenReturn(false);

        when( blogRepository.save( any(Blog.class) )).thenAnswer(args ->{
            Blog blog = (Blog) args.getArguments()[0];
            blog.setId( 1L );
            return blog;
        });

        CreateBlogCommand command = CreateBlogCommand.builder()
                .siteId(1L)
                .build();

        Blog blog = service.createBlog( command );

        assertThat(blog, allOf(
                hasProperty("id" , equalTo( 1L ) ),
                hasProperty("prefix" , equalTo( "blog" ) ),
                hasProperty("active" , equalTo( true ) ),
                hasProperty("allowComment" , equalTo( false ) ),
                hasProperty("site" , hasProperty("id", equalTo(1L)) )
        ));

        verify(siteRepository, times(1)).findById(any(Long.class));
        verify(blogRepository, times(1)).existsBySite(any(Site.class));
        verify(blogRepository, times(1)).save(any(Blog.class));

    }
}
