package com.example.demo.services.impl;

import com.example.demo.dto.personDto;
import com.example.demo.entity.person;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.map.personMap;
import com.example.demo.repository.personRepository;
import com.example.demo.services.personServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class personServiceImpl implements personServices {

    private personRepository personRepository;

    @Override
    public personDto createPerson(personDto personDto) {
        person person = personMap.mapToPerson(personDto);
        person personaGuardada = personRepository.save(person);
        return personMap.mapToPersonDto(personaGuardada);
    }

    @Override
    public personDto getPersonaById(Long idPersona){
       person person = personRepository.findById(idPersona).orElseThrow(()->new ResourceNotFound("No se ha encontrado a la persona con el ID: "+ idPersona));
        return personMap.mapToPersonDto(person);
    }

    @Override
    public List<personDto> getAllPersonas() {
        List<person> todasLasPersonas = personRepository.findAll();
        return todasLasPersonas.stream().map((person) -> personMap.mapToPersonDto(person)).collect(Collectors.toList());
    }

    @Override
    public personDto updatePerson(personDto personDto, Long idPersona) {
        person aEditar = personRepository.findById(idPersona).orElseThrow(()->new ResourceNotFound("no encontrado"));
        aEditar.setAge(personDto.getAge());
        aEditar.setClave(personDto.getClave());
        aEditar.setEmail(personDto.getEmail());
        aEditar.setNombreUsuario(personDto.getNombreUsuario());

        person person = personRepository.save(aEditar);//al tener id, lo sobreescribe ya el save
        return personMap.mapToPersonDto(person);
    }

    @Override
    public void deletePerson(Long idPersona) {
        person aBorrar = personRepository.findById(idPersona).orElseThrow(()->new ResourceNotFound("Elemento a borrar no encontrado"));
        personRepository.deleteById(idPersona);
    }
}