package com.sejawal.crud.dto;
import lombok.Data;

@Data
public class PersonDto {
    private Long id;

    private String name;
    private String address;
    private String email;
}
