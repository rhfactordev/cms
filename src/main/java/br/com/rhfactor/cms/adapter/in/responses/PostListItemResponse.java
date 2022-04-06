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
public class PostListItemResponse {

    Long id;
    String categoryName;
    Long categoryId;
    String title;

    public static <R> PostListItemResponse create(Post post) {
        return PostListItemResponse.builder()
                .id(post.getId())
                .categoryId( post.getCategory().getId() )
                .categoryName( post.getCategory().getName() )
                .title( post.getTitle() )
                .build();
    }
}
