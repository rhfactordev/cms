package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Menu {

    public enum MenuType{
        PAGE, POST, STRING;
    }

    Long id;

    Site site;

    String name;

    MenuType menuType;

    String target;

    /**
     * Link para páginas internas
     */
    Page page;


}
