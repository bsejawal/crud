package com.sejawal.crud.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sejawal.crud.dto.PersonDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonDtoList {

    @JsonProperty("personList")
    private List<PersonDto> personList = new ArrayList<>();
}
