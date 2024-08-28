package com.example.demo.controller;

import com.example.demo.dto.patientDto;
import com.example.demo.services.patientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/person")
public class patientController {
    private patientService patientService;

    //AÑADIR UNA PERSONA
    @PostMapping
    public ResponseEntity<patientDto> crearPersona(@RequestBody patientDto patientDto) {
        System.out.println(patientDto.toString());
        patientDto personaGuardada = patientService.createPerson(patientDto);
        return new ResponseEntity<>(personaGuardada, HttpStatus.CREATED);
    }

    //OBTENER UNA PERSONA
    @GetMapping("{id}")
    public ResponseEntity<patientDto> getPersonaById(@PathVariable("id") Long idPersona) {
        patientDto patientDto = patientService.getPersonaById(idPersona);
        return ResponseEntity.ok(patientDto);
    }

    //OBTENER TODAS LAS PERSONAS
    @GetMapping
    public ResponseEntity<List<patientDto>> getPersonas() {
        List<patientDto> personas = patientService.getAllPersonas();
        return ResponseEntity.ok(personas);
    }

    //ACTUALIZAR PERSONA
    @PutMapping("{id}")
    public ResponseEntity<patientDto> actualizarPersona(@PathVariable("id")Long idPerson, @RequestBody patientDto patientDto) {
        patientDto actualizado = patientService.updatePerson(patientDto,idPerson);
        return ResponseEntity.ok(actualizado);
    }

    //ELIMINAR PERSONA
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable("id") Long idPersona) {
        patientService.deletePerson(idPersona);
        return  ResponseEntity.ok("Person deleted successfully");
    }
}
