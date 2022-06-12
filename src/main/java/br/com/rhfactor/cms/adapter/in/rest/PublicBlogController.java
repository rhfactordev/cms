package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.LinkResponse;
import br.com.rhfactor.cms.adapter.in.responses.PageResponse;
import br.com.rhfactor.cms.adapter.in.responses.PublicBlogResponse;
import br.com.rhfactor.cms.application.port.in.PublicBlogUsecase;
import br.com.rhfactor.cms.domain.*;
import br.com.rhfactor.cms.infrastructure.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j

@RestController
@RequiredArgsConstructor
@RequestMapping("/cms/public/blog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PublicBlogController {

    private final PublicBlogUsecase blogUsecase;

    // Obter as informações do blog

    @GetMapping
    public PublicBlogResponse get(){

        // TODO: Receber o domínio na requisição
        Blog blog = getBlog( "sarakoimbra.com.br" );

        List<Category> categoryList = blogUsecase.getCategoriesFromBlog( blog );

        return PublicBlogResponse.builder()
                .title( blog.getTitle() )
                .categories(
                        categoryList.stream()
                                .map( LinkResponse::fromCategory )
                                .collect(Collectors.toList())
                )
                .build();

    }

    @GetMapping("posts")
    public org.springframework.data.domain.Page<PageResponse> listPages(
            @RequestParam("category") Optional<String> category
            , @RequestParam("tag") Optional<String> tag
            , @SortDefault.SortDefaults({
                @SortDefault(sort = "creationDate", direction = Sort.Direction.ASC),
            }) Pageable pageable
    ){
        Page<Post> posts = blogUsecase.listPosts( getBlog( "sarakoimbra.com.br" )
                , category
                , tag
                , PageableRequest.from(pageable) );

        return new PageImpl<>(posts.getContent()
                .stream()
                .map(PageResponse::toListPostPage)
                .collect(Collectors.toList())
                , pageable
                , posts.getTotalElements());

    }

    @GetMapping("post")
    public PageResponse detail(
            @RequestParam(value = "source", required = true) @NotEmpty @NotNull String source
    ){

        Post post = blogUsecase.getPost( getBlog( "sarakoimbra.com.br" ) , source )
                .orElseThrow( () -> new NotFoundException("Post not found") );
        return PageResponse.toDetailPage( post );
    }

    private Blog getBlog( String domain ){
        return blogUsecase.getBlogInformation(domain)
                .orElseThrow( () -> new NotFoundException("Blog not found") );
    }

}
