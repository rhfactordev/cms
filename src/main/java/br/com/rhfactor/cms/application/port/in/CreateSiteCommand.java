package br.com.rhfactor.cms.application.port.in;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CreateSiteCommand {

    String name;

}
