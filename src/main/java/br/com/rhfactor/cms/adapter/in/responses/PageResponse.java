package br.com.rhfactor.cms.adapter.in.responses;

import br.com.rhfactor.cms.domain.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.*;

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

    LinkResponse image;

    LinkResponse target;

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
                .content( post.getDescription() )
                .image( LinkResponse.builder()
                        .alt( post.getTitle() )
                        .target( post.getImage() )
                        .build() )
                .target(
                        LinkResponse.builder()
                                .target( post.getCategory().getSlug().concat("/").concat(post.getSlug()) )
                                .build()
                )
                .build();
    }

    public static PageResponse toDetailPage(Post post) {
        return PageResponse.builder()
                .title( post.getTitle() )
                .content( post.getContent() )
                .image( LinkResponse.builder()
                        .alt( post.getTitle() )
                        .target( post.getImage() )
                        .build() )
                .build();
    }
}
