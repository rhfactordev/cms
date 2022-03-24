package br.com.rhfactor.cms.application.port.in.commands;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class IdNameCommand {

    Long id;

    String name;

}
