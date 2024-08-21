package com.example.demo.controller;

import com.example.demo.dto.personDto;
import com.example.demo.services.personServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/person")
public class personController {
    private personServices personServices;

    //AÑADIR UNA PERSONA
    @PostMapping
    public ResponseEntity<personDto> crearPersona(@RequestBody personDto personDto) {
        System.out.println(personDto.toString());
        personDto personaGuardada = personServices.createPerson(personDto);
        return new ResponseEntity<>(personaGuardada, HttpStatus.CREATED);
    }

    //OBTENER UNA PERSONA
    @GetMapping("{id}")
    public ResponseEntity<personDto> getPersonaById(@PathVariable("id") Long idPersona) {
        personDto personDto = personServices.getPersonaById(idPersona);
        return ResponseEntity.ok(personDto);
    }

    //OBTENER TODAS LAS PERSONAS
    @GetMapping
    public ResponseEntity<List<personDto>> getPersonas() {
        List<personDto> personas = personServices.getAllPersonas();
        return ResponseEntity.ok(personas);
    }

    //ACTUALIZAR PERSONA
    @PutMapping("{id}")
    public ResponseEntity<personDto> actualizarPersona(@PathVariable("id")Long idPerson, @RequestBody personDto personDto) {
        personDto actualizado = personServices.updatePerson(personDto,idPerson);
        return ResponseEntity.ok(actualizado);
    }

    //ELIMINAR PERSONA
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePersonaById(@PathVariable("id") Long idPersona) {
        personServices.deletePerson(idPersona);
        return  ResponseEntity.ok("Person deleted successfully");
    }
}
