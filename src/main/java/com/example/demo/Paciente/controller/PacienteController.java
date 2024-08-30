package com.example.demo.Paciente.controller;

import com.example.demo.Paciente.dto.PacienteDto;
import com.example.demo.Paciente.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    //AÑADIR UN PACIENTE
    @PostMapping
    public ResponseEntity<PacienteDto> crearPaciente(@RequestBody PacienteDto pacienteDto) {
        System.out.println("El paciente es: " + pacienteDto.toString());
        PacienteDto pacienteGuardado = pacienteService.crearPaciente(pacienteDto);
        return new ResponseEntity<>(pacienteGuardado, HttpStatus.CREATED);
    }

    //OBTENER UN PACIENTE
    @GetMapping("{id}")
    public ResponseEntity<PacienteDto> getPacienteById(@PathVariable("id") Long idPaciente) {
        PacienteDto pacienteDto = pacienteService.getPacienteByID(idPaciente);
        return ResponseEntity.ok(pacienteDto);
    }

    //OBTENER TODOS LOS PACIENTES
    @GetMapping
    public ResponseEntity<List<PacienteDto>> getPacientes() {
        List<PacienteDto> pacientes = pacienteService.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    //ACTUALIZAR PACIENTE
    @PutMapping("{id}")
    public ResponseEntity<PacienteDto> actualizarPaciente(@PathVariable("id") Long idPaciente, @RequestBody PacienteDto pacienteDto) {
        PacienteDto pacienteActualizado = pacienteService.updatePaciente(pacienteDto, idPaciente);
        return ResponseEntity.ok(pacienteActualizado);
    }

    //ELIMINAR PACIENTE
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPacienteById(@PathVariable("id") Long idPaciente) {
        pacienteService.deletePaciente(idPaciente);
        return ResponseEntity.ok("Paciente eliminado satisfactoriamente");
    }
}
