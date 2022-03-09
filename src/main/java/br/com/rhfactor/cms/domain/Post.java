package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Post extends SitePage {

    Blog blog;

    Category category;

}
