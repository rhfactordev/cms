package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Blog extends MetaAttributes {

    Long id;

    Site site;

    String title;

    /**
     * prefixo da raiz do blog
     *
     */
    @Builder.Default
    String prefix = "blog";

    @Builder.Default
    Boolean active = true;

    @Builder.Default
    Boolean allowComment = false;

    @Builder.Default
    LocalDateTime creationDate = LocalDateTime.now();

}
