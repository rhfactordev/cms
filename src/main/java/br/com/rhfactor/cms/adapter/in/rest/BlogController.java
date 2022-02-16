package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.BlogResponse;
import br.com.rhfactor.cms.adapter.in.responses.CategoryResponse;
import br.com.rhfactor.cms.adapter.in.responses.PostResponse;
import br.com.rhfactor.cms.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cms/management/blog")
@RequiredArgsConstructor
public class BlogController {

    /**
     * - Obter os posts do blog
     * - Detalhar um post do blog
     */

    /**
     * Requisição para obter as informações necessárias para a página inicial do blog
     *
     * @return
     */
    @GetMapping
    public BlogResponse getBlogInfo() {


        return BlogResponse.builder()
                .title("Blog Sara Koimbra")
                .categories(new ArrayList<>() {{

                    add(CategoryResponse.builder()
                            .name("Astrologia")
                            .link("astroliga")
                            .build());

                    add(CategoryResponse.builder()
                            .name("Tarot")
                            .link("tatot")
                            .build());

                    add(CategoryResponse.builder()
                            .name("Ervas")
                            .link("ervas")
                            .build());

                }})
                .build();
    }
    @GetMapping("post")

    public List<PostResponse> getPostInfo(){

        List<PostResponse> postResponses = new ArrayList<>() {{
                add(PostResponse.builder()
                        .title("Gemeos")
                        .content("O melhor signo do mundo")
                        .link("/gemeos")
                        .date(LocalDate.now())
                        .image("url da imagem")
                        .build());

                add(PostResponse.builder()
                        .title("Cancer")
                        .content("Não vale a pena")
                        .link("/cancer")
                        .date(LocalDate.now())
                        .image("url da imagem")
                        .build());
                


        }};



        return postResponses;



    }
}

