package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@FieldDefaults(level= AccessLevel.PROTECTED)
public class MetaAttributes {

    String metaDescription;

    String metaKeyword;

    String ogTitle;

    String ogDescription;

}
