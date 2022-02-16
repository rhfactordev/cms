package br.com.rhfactor.cms.adapter.in.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)


public class LoginRequest {
    String user;
    String password;
}
