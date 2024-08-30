package com.example.demo.Paciente.map;

import com.example.demo.Paciente.dto.PacienteDto;
import com.example.demo.Paciente.entity.Paciente;

public class PacienteMap {
    public static PacienteDto mapToPacienteDto(Paciente paciente) {
        return new PacienteDto(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getApellidos(),
                paciente.getTelefono(),
                paciente.getEdad()
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