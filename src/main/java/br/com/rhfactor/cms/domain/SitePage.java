package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@FieldDefaults(level= AccessLevel.PROTECTED)
public class SitePage extends MetaAttributes {

    Site site;

    Long id;

    String title;

    String source;

    String slug;

    String content;

}
