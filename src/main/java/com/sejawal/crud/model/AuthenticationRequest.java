package com.sejawal.crud.model;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;

}
