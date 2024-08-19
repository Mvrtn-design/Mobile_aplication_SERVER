package com.example.demo.services;

import com.example.demo.dto.personDto;

import java.util.List;

public interface personServices {
    personDto createPerson(personDto personDto);

    personDto getPersonaById(Long idPersona);

    List<personDto> getAllPersonas();

    personDto updatePerson(personDto personDto, Long idPersona);
    void deletePerson(Long idPersona);

}