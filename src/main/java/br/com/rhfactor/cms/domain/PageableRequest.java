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
public class PageableRequest {

    Integer pageSize;
    Integer pageNumber;

    // TODO: Implementar as ordenações
    public static PageableRequest from(Pageable pageable) {
        return PageableRequest.builder()
                .pageSize( pageable.getPageSize() )
                .pageNumber( pageable.getPageNumber() )
                .build();
    }

    public static PageableRequest of(int pageNumber, int pageSize) {
        return PageableRequest.builder()
                .pageSize( pageSize )
                .pageNumber( pageNumber )
                .build();
    }
}
