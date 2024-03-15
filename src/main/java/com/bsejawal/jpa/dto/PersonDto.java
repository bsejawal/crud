package com.bsejawal.jpa.dto;

import com.bsejawal.jpa.entity.Person;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotEmpty(message = "personId should not be Empty")
    @Pattern(regexp = "^\\d{15}$", message = "personId must be 15 digit")
    String personId;

    @NotEmpty(message = "name should not be Empty")
    String name;

    @Email(message = "Invalid email id")
    String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digit")
    String phone;

    String gender;

    @Past
    @JsonFormat(pattern = "MM/dd/yyyy")
    Date dob;


    public Person mapToPerson(){

        return Person.builder()
                .personId(this.personId)
                .name(this.name)
                .email(this.email)
                .phone(this.phone)
                .gender(this.gender)
                .dob(this.dob)
                .build();
    }
}
