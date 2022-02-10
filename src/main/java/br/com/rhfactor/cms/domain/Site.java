package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Site extends MetaAttributes {

    Long id;

    String name;

    @Builder.Default
    List<Page> pages = new ArrayList<>();

    @Builder.Default
    List<Menu> menus = new ArrayList<>();

    @Builder.Default
    List<Domain> domains = new ArrayList<>();

    @Builder.Default
    Boolean active = true;

    @Builder.Default
    LocalDateTime creationDate = LocalDateTime.now();

    LocalDateTime lastUpdateDate;

}
