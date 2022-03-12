package br.com.rhfactor.cms.adapter.in.responses;

import br.com.rhfactor.cms.domain.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_EMPTY)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PageResponse {

    String parent;

    String source;

    String title;

    String subtitle;

    String content;

    String date;
    /**
     * Aqui tem que vir fortemente a copy da página
     * 150-160 caracteres
     */
    String metaDescription;

    String metaKeywords;

    String metaRobots;

    String canonical;

    String ogTitle;

    String ogType;

    String ogDescription;

    String ogImage;


    public static <R> PageResponse toListPostPage(Post post) {
        return PageResponse.builder()
                .title( post.getTitle() )
                .content( post.getContent() )
                .build();
    }
}
