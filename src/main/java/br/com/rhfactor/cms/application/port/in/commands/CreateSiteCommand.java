package br.com.rhfactor.cms.application.port.in.commands;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CreateSiteCommand {

    String name;


}
