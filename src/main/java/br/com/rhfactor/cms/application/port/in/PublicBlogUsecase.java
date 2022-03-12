package br.com.rhfactor.cms.application.port.in;

import br.com.rhfactor.cms.domain.*;

import java.util.List;
import java.util.Optional;

public interface PublicBlogUsecase {

    /**
     * Aqui, é publico, então devemos receber qual é o site que a pessoa quer
     * Vamos receber o id do site ou o domínio?
     *
     * @return
     */
    Optional<Blog> getBlogInformation(String domain);

    /**
     * Listar todas as categorias que são deste blog
     *
     * @param blog
     * @return
     */
    List<Category> getCategoriesFromBlog(Blog blog);


    /**
     * Se passar categoria tem que trazer da categoria
     * Se passar tag tem que trazer da TagX
     *
     * @param blog
     * @param category
     * @param tag
     * @return
     */
    Page<Post> listPosts(Blog blog, Optional<String> category, Optional<String> tag, PageableRequest pageableRequest);

    /**
     * Obter uma
     *
     * @param blog
     * @param source
     * @return
     */
    Optional<Post> getPost(Blog blog, String source);

}
