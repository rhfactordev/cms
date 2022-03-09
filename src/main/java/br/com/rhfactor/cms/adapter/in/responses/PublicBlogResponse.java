package br.com.rhfactor.cms.adapter.in.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Essa resposta traz as informações gerais do blog
 * - informações do blog
 * - subcategorias
 * - TODO: tags utilizadas
 * - Quantodades
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PublicBlogResponse {

    String title;
    String description;
    List<LinkResponse> categories;

}
