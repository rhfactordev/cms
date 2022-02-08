package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Site extends MetaAttributes {

    Long id;

    String name;

    List<Page> pages;

    List<Menu> menus;

}
