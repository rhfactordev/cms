package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.application.port.in.PrivateBlogUsecase;
import br.com.rhfactor.cms.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters.toPage;
import static br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters.toPeageableRequest;

@Slf4j
@RestController
@RequestMapping("/cms/private/blog")
@RequiredArgsConstructor
public class PrivateBlogController {

    private final PrivateBlogUsecase blogUsecase;

    @GetMapping
    public org.springframework.data.domain.Page<Post> listAllCategories(
            @PageableDefault(page = 0, size = 10) Pageable pageable
    ){
        // TODO: mudar o retorno para
        return toPage( blogUsecase.listPosts( toPeageableRequest( pageable ) ) );
    };

//    pagePosts();

//    createPost();

//    updatePost();


}
