package com.example.demo.map;

import com.example.demo.dto.patientDto;
import com.example.demo.entity.patient;

public class patientMap {
    public static patientDto mapToPersonDto(patient patient) {
        return new patientDto(
                patient.getId(),
                patient.getNombreUsuario(),
                patient.getEmail(),
                patient.getClave(),
                patient.getAge()
        );
    }
    public static patient mapToPerson(patientDto patientDto) {
        return new patient(
                patientDto.getId(),
                patientDto.getNombreUsuario(),
                patientDto.getAge(),
                patientDto.getClave(),
                patientDto.getEmail()

        );
    }
}