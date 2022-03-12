package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Post extends MetaAttributes {

    Long id;

    Blog blog;

    Category category;

    String title;

    String slug;

    String description;

    String content;

}
