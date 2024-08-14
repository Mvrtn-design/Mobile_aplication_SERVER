package com.example.demo.map;

import com.example.demo.dto.personaDto;
import com.example.demo.entity.person;

public class personMap {
    public static personaDto mapToPersonDto(person Person){
        return new personaDto(
                person.getId(),
                person.getNombreUsuario(),
                person.getTelefono(),
                person.getEmail()
        );
    }

    public static person mapToPerson(person person){
        return new person(
                person.getId(),
                person.getNombreUsuario(),
                person.getTelefono(),
                person.getEmail()
        );
    }
}
