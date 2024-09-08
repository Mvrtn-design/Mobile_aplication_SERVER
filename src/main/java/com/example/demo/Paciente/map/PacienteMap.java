package com.example.demo.Paciente.map;

import com.example.demo.Paciente.infrastructure.dto.PacienteDto;
import com.example.demo.Paciente.domain.models.entity.Paciente;

public class PacienteMap {
    public static PacienteDto mapToPacienteDto(Paciente paciente) {
        return new PacienteDto(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellidos(),
                paciente.getEdad(),
                paciente.getTelefono(),
                paciente.getEmail()
        );
    }

    public static Paciente mapToPaciente(PacienteDto pacienteDto) {
        return new Paciente(
                pacienteDto.getId(),
                pacienteDto.getNombre(),
                pacienteDto.getApellidos(),
                pacienteDto.getEdad(),
                pacienteDto.getTelefono(),
                pacienteDto.getEmail()
        );
    }
}