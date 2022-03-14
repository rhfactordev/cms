package br.com.rhfactor.cms.adapter.in.responses;

import br.com.rhfactor.cms.domain.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class LinkResponse {

    String title;
    String target;
    String alt;
    String rel;

    public static <R> LinkResponse fromCategory(Category category) {
        return LinkResponse.builder()
                .title( category.getName() )
                .target( category.getTarget() )
                .build();
    }
}
