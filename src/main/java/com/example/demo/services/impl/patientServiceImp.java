package com.example.demo.services.impl;

import com.example.demo.dto.patientDto;
import com.example.demo.entity.patient;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.map.patientMap;
import com.example.demo.repository.patientRepository;
import com.example.demo.services.patientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class patientServiceImp implements patientService {

    private patientRepository patientRepository;

    @Override
    public patientDto createPerson(patientDto patientDto) {
        patient patient = patientMap.mapToPerson(patientDto);
        patient personaGuardada = patientRepository.save(patient);
        return patientMap.mapToPersonDto(personaGuardada);
    }

    @Override
    public patientDto getPersonaById(Long idPersona){
       patient patient = patientRepository.findById(idPersona).orElseThrow(()->new ResourceNotFound("No se ha encontrado a la persona con el ID: "+ idPersona));
        return patientMap.mapToPersonDto(patient);
    }

    @Override
    public List<patientDto> getAllPersonas() {
        List<patient> todasLasPersonas = patientRepository.findAll();
        return todasLasPersonas.stream().map((patient) -> patientMap.mapToPersonDto(patient)).collect(Collectors.toList());
    }

    @Override
    public patientDto updatePerson(patientDto patientDto, Long idPersona) {
        patient aEditar = patientRepository.findById(idPersona).orElseThrow(()->new ResourceNotFound("no encontrado"));
        aEditar.setAge(patientDto.getAge());
        aEditar.setClave(patientDto.getClave());
        aEditar.setEmail(patientDto.getEmail());
        aEditar.setNombreUsuario(patientDto.getNombreUsuario());

        patient patient = patientRepository.save(aEditar);//al tener id, lo sobreescribe ya el save
        return patientMap.mapToPersonDto(patient);
    }

    @Override
    public void deletePerson(Long idPersona) {
        patient aBorrar = patientRepository.findById(idPersona).orElseThrow(()->new ResourceNotFound("Elemento a borrar no encontrado"));
        patientRepository.deleteById(idPersona);
    }
}