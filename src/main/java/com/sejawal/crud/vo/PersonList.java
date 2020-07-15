package com.sejawal.crud.vo;

import com.sejawal.crud.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "{" +
                "personList=" + personList +
                '}';
    }
}
