package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PROTECTED)
public class Page extends MetaAttributes {

    Long id;

    String title;

    String source;

    String slug;

    String content;

}
