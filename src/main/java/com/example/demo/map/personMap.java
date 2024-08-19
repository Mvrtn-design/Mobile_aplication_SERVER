package com.example.demo.map;

import com.example.demo.dto.personDto;
import com.example.demo.entity.person;

public class personMap {
    public static personDto mapToPersonDto(person person) {
        return new personDto(
                person.getId(),
                person.getNombreUsuario(),
                person.getEmail(),
                person.getClave(),
                person.getAge()
        );
    }
    public static person mapToPerson(personDto personDto) {
        return new person(
                personDto.getId(),
                personDto.getNombreUsuario(),
                personDto.getAge(),
                personDto.getClave(),
                personDto.getEmail()

        );
    }
}