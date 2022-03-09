package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Category extends MetaAttributes {

    Long id;

    Blog blog;

    String name;

    String slug;

    /**
     * Aqui tem que montar a URL completa da aplicação utilizando o Prefixo do blog
     * @return
     */
    public String getTarget(){
        return blog.getPrefix().concat("/").concat( slug );
    }

}
