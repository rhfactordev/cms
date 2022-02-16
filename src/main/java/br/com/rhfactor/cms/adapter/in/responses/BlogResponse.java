package br.com.rhfactor.cms.adapter.in.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BlogResponse {

    String title;

    List<CategoryResponse> categories;

}
