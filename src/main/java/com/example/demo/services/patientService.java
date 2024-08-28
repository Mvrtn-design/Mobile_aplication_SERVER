package com.example.demo.services;

import com.example.demo.dto.patientDto;

import java.util.List;

public interface patientService {
    patientDto createPerson(patientDto patientDto);

    patientDto getPersonaById(Long idPersona);

    List<patientDto> getAllPersonas();

    patientDto updatePerson(patientDto patientDto, Long idPersona);
    void deletePerson(Long idPersona);

}