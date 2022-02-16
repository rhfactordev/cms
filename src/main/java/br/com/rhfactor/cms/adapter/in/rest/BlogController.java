package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.BlogResponse;
import br.com.rhfactor.cms.adapter.in.responses.CategoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/cms/management/blog")
@RequiredArgsConstructor
public class BlogController {

    /**
     * - Obter informações sobre o blog
     * - Obter as categorias do blog
     * - Obter os posts do blog
     * - Detalhar um post do blog
     */

    @GetMapping
    public BlogResponse getBlogInfo(){

        /*
        BlogResponse blogResponse = new BlogResponse();
        blogResponse.setTitle( "Blog Sara Koimbra" );
        blogResponse.setCategories( new ArrayList<>() );

        CategoryResponse category1 = new CategoryResponse();
        category1.setName( "Astrologia" );
        category1.setLink( "/blog/astrologia" );
        blogResponse.getCategories().add( category1 );

        CategoryResponse category2 = new CategoryResponse();
        category2.setName( "Tarot" );
        category2.setLink( "/blog/tarot" );
        blogResponse.getCategories().add( category2 );
        */

        return BlogResponse.builder()
                .title("Blog Sara Koimbra")
                .categories( new ArrayList<>() {{

                    add( CategoryResponse.builder()
                            .name("Astrologia")
                            .link("astroliga")
                            .build() );

                    add( CategoryResponse.builder()
                            .name("Tarot")
                            .link("tatot")
                            .build() );

                    add( CategoryResponse.builder()
                            .name("Ervas")
                            .link("ervas")
                            .build() );

                }} )
                .build();
    }


}
