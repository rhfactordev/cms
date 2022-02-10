package br.com.rhfactor.cms.application.port.in.commands;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CreateSiteCommand {

    @NotNull
    @NotEmpty
    String name;

    @NotNull
    @NotEmpty
    String domain;


}
