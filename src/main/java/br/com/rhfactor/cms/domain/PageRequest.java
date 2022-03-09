package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;

/**
 * Esse cara será o nosso pageRequest interno
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PageRequest {

    Integer pageSize;
    Integer pageNumber;

    // TODO: Implementar as ordenações
    public static PageRequest from(Pageable pageable) {
        return PageRequest.builder()
                .pageSize( pageable.getPageSize() )
                .pageNumber( pageable.getPageNumber() )
                .build();
    }
}
