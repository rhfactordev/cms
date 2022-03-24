package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.PostListItemResponse;
import br.com.rhfactor.cms.application.port.in.PrivateBlogUsecase;
import br.com.rhfactor.cms.application.port.in.commands.CreatePostCommand;
import br.com.rhfactor.cms.domain.Page;
import br.com.rhfactor.cms.domain.Post;
import br.com.rhfactor.cms.infrastructure.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters.toPage;
import static br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters.toPeageableRequest;

@Slf4j
@RestController
@RequestMapping("/cms/private/blog")
@RequiredArgsConstructor
public class PrivateBlogController {

    private final PrivateBlogUsecase blogUsecase;

    @GetMapping("posts")
    public org.springframework.data.domain.Page<PostListItemResponse> listAllCategories(
            @PageableDefault(page = 0, size = 10) Pageable pageable
    ){
        Page<Post> found = blogUsecase.listPosts(toPeageableRequest(pageable));
        List<PostListItemResponse> list = found.getContent().stream()
                .map(PostListItemResponse::create)
                .collect(Collectors.toList());

        return new PageImpl<>( list , pageable , found.getTotalElements() );
    };

    @GetMapping("post/{id}")
    public Post getPost( @PathVariable("id") Long id ){
        return blogUsecase.getPostById( id )
                .orElseThrow(()-> new NotFoundException("Post not found"));

    }

    @PostMapping("post")
    public PostListItemResponse createPost(@RequestBody @Valid CreatePostCommand command){

        Post post = blogUsecase.createPost( command );

        return PostListItemResponse.builder()
                .id(post.getId())
                .categoryId( post.getCategory().getId() )
                .categoryName( post.getCategory().getName() )
                .title( post.getTitle() )
                .build();
    }

    @PutMapping("post/{id}")
    public PostListItemResponse update(@PathVariable("id") Long id, @RequestBody @Valid CreatePostCommand command){

        Post post = blogUsecase.updatePost( id, command );

        return PostListItemResponse.builder()
                .id(post.getId())
                .categoryId( post.getCategory().getId() )
                .categoryName( post.getCategory().getName() )
                .title( post.getTitle() )
                .build();
    }




}
