package com.example.demo.Paciente.application.services.impl;

import com.example.demo.Paciente.domain.models.entity.Paciente;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.Paciente.map.PacienteMap;
import com.example.demo.Paciente.infrastructure.dto.PacienteDto;
import com.example.demo.Paciente.infrastructure.repository.PacienteRepository;
import com.example.demo.Paciente.application.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacienteServiceImp implements PacienteService {

    private PacienteRepository pacienteRepository;

    @Override
    public PacienteDto crearPaciente(PacienteDto pacienteDto) {
        Paciente paciente = PacienteMap.mapToPaciente(pacienteDto);
        Paciente pacienteGuardado = pacienteRepository.save(paciente);
        return PacienteMap.mapToPacienteDto(pacienteGuardado);
    }

    @Override
    public PacienteDto getPacienteByID(Long IdPaciente) {
        Paciente encontrado = pacienteRepository.findById(IdPaciente).orElseThrow(() -> new ResourceNotFound("Paciente no encontrado"));
        return PacienteMap.mapToPacienteDto(encontrado);
    }

    @Override
    public List<PacienteDto> getAllPacientes() {
        List<Paciente> todosPacientes = pacienteRepository.findAll();
        return todosPacientes.stream().map((paciente_aux) -> PacienteMap.mapToPacienteDto(paciente_aux)).collect(Collectors.toList());
    }

    @Override
    public PacienteDto updatePaciente(PacienteDto pacienteDto, Long idPaciente) {

        Paciente pacienteActualizar = pacienteRepository.findById(idPaciente).orElseThrow(() -> new ResourceNotFound("Usuario no enconrado"));
        pacienteActualizar.setNombre(pacienteDto.getNombre());
        pacienteActualizar.setEmail(pacienteDto.getEmail());
        pacienteActualizar.setApellidos(pacienteDto.getApellidos());
        pacienteActualizar.setEdad(pacienteDto.getEdad());
        pacienteActualizar.setTelefono(pacienteDto.getTelefono());

        Paciente guardado = pacienteRepository.save(pacienteActualizar);//al tener id, lo sobreescribe ya el save
        return PacienteMap.mapToPacienteDto(guardado);
    }

    @Override
    public void deletePaciente(Long idPaciente) {
        //Primero se hace una búsqueda por si resulta que el usuario no existe
        Paciente buscado = pacienteRepository.findById(idPaciente).orElseThrow(() -> new ResourceNotFound("Usuario no encontrado"));
        pacienteRepository.deleteById(idPaciente);
    }
}