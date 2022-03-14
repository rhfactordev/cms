package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.application.port.out.CategoryRepository;
import br.com.rhfactor.cms.application.port.out.PostRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PublicBlogServiceTest {

    @Mock private BlogRepository blogRepository;
    @Mock private PostRepository postRepository;
    @Mock private CategoryRepository categoryRepository;

    @InjectMocks
    private PublicBlogService service;

    @Test
    void getBlogInformation() {



    }

    @Test
    void getCategoriesFromBlog() {
    }

    @Test
    void listPosts() {
    }

    @Test
    void getPost() {
    }
}
