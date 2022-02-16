package br.com.rhfactor.cms.adapter.in.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PostResponse {

    String title;

    String content;

    String link;

    LocalDate date;

    String image;

}
