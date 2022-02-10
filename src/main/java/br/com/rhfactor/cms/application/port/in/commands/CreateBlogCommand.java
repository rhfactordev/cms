package br.com.rhfactor.cms.application.port.in.commands;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CreateBlogCommand {

    @NotNull
    Long siteId;

    @NotNull
    String title;

    String metaDescription;

    String metaKeyword;

    String ogTitle;

    String ogDescription;

}
