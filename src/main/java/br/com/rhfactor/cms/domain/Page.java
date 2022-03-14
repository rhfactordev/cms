package br.com.rhfactor.cms.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Esse cara será o nosso pageRequest interno
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Page<T> {

    public Page(List<T> content, PageableRequest pageRequest, long totalElements) {
        this.content = content;
        this.pageRequest = pageRequest;
        this.totalElements = totalElements;
    }

    PageableRequest pageRequest;
    long totalElements;
    List<T> content;

}
