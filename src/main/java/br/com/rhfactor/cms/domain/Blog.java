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

    String slug;

    LocalDateTime creationDate;

}
