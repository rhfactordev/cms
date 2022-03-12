package br.com.rhfactor.cms.application.service;

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
public class PublicBlogService implements PublicBlogUsecase {

    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    @Override
    public Optional<Blog> getBlogInformation(String domain) {
        return blogRepository.findByDomain( domain );
    }

    @Override
    public List<Category> getCategoriesFromBlog(Blog blog) {
        return categoryRepository.listAllCategoriesFromBlog(blog);
    }

    @Override
    public Page<Post> listPosts(Blog blog, Optional<String> category, Optional<String> tag, PageableRequest pageableRequest) {
        return postRepository.findPosts(blog, category, tag, pageableRequest);
    }

    @Override
    public Optional<Post> getPost(Blog blog, String source) {
        return postRepository.findByBlogAndSource(blog, source);
    }
}
