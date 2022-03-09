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

    List<T> content;

    public long getTotalElements() {
        return this.content == null ? 0 : this.content.toArray().length;
    }
}
