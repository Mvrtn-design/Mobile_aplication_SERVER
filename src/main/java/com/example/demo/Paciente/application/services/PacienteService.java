package com.example.demo.Paciente.application.services;

import com.example.demo.Paciente.infrastructure.dto.PacienteDto;

import java.util.List;

public interface PacienteService {
    PacienteDto crearPaciente(PacienteDto pacienteDto);

    PacienteDto getPacienteByID(Long IdPaciente);

    List<PacienteDto> getAllPacientes();

    PacienteDto updatePaciente(PacienteDto pacienteDto, Long idPaciente);
    void deletePaciente(Long idPaciente);

}