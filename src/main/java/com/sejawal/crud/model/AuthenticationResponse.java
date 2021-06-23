package com.sejawal.crud.model;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String jwt;

}
