package br.com.rhfactor.cms.application.port.in;

import br.com.rhfactor.cms.domain.Page;
import br.com.rhfactor.cms.domain.PageableRequest;
import br.com.rhfactor.cms.domain.Post;

public interface PrivateBlogUsecase {



    /**
     * Listar todos os posts
     *
     * @param pageableRequest
     * @return
     */
    Page<Post> listPosts(PageableRequest pageableRequest);



}