package br.com.rhfactor.cms.adapter.in.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ChartAspects {

    String planet;
    String sign;
    String house;
    String degree;
    String title;
    String text;
}
