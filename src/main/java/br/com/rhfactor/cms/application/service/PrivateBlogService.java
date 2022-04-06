package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.PrivateBlogUsecase;
import br.com.rhfactor.cms.application.port.in.PublicBlogUsecase;
import br.com.rhfactor.cms.application.port.in.commands.CreatePostCommand;
import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.application.port.out.CategoryRepository;
import br.com.rhfactor.cms.application.port.out.PostRepository;
import br.com.rhfactor.cms.domain.*;
import br.com.rhfactor.cms.infrastructure.error.exception.NotFoundException;
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

    @Override
    public Optional<Post> getPostById(Long id) {
        Blog blog = getBlogFromSession();
        return postRepository.findPostByBlogAndId(blog, id);
    }

    @Override
    public Post createPost(CreatePostCommand postCommand) {
        Blog blog = getBlogFromSession();

        // TODO: verificar se já existe o source na categoria
        // TODO: Validar se a categoria é existente

        Post post = postCommand.toDomain();
        post.setBlog( blog );

        return postRepository.save( post );
    }

    @Override
    public Post updatePost(Long id, CreatePostCommand command) {

        // TODO: verificar se já existe o source na categoria e o ID não é esse
        // TODO: Validar se a categoria é existente

        Blog blog = getBlogFromSession();

        Post post = postRepository.findPostByBlogAndId(blog, id)
                .orElseThrow(()->new NotFoundException("Post not found"));

        // O que pode ser editado:
        post.setCategory( Category.builder().id( command.getCategory().getId() ).build() );
        post.setContent( command.getContent() );
        post.setDescription( command.getDescription() );
        post.setTitle(command.getTitle() );
        post.setImage( command.getImage() );
        post.setSlug( command.getSlug() );

        return postRepository.save( post );
    }

    @Override
    public List<Category> listAllCategories() {
        Blog blog = getBlogFromSession();
        return this.categoryRepository.listAllCategoriesFromBlog(blog);
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
