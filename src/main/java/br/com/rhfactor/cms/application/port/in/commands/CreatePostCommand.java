package br.com.rhfactor.cms.application.port.in.commands;

import br.com.rhfactor.cms.domain.Category;
import br.com.rhfactor.cms.domain.Post;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CreatePostCommand {

    @NotNull
    IdNameCommand category;

    @NotNull
    String title;

    @NotNull
    String slug;

    @NotNull
    String description;

    @NotNull
    String content;

    @NotNull
    String image;


    public Post toDomain() {
        return Post.builder()
                .category( Category.builder().id( category.getId() ).build() )
                .image( image )
                .title( title )
                .slug( slug )
                .description( description )
                .content( content )
                .build();
    }
}
