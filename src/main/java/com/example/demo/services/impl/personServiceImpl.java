package com.example.demo.services.impl;

import com.example.demo.dto.personaDto;
import com.example.demo.repository.personRepository;
import com.example.demo.services.personServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class personServiceImpl implements personServices {

    private personRepository personRepository;

    @Override
    public personaDto createPersona(personaDto persona) {
        return null;
    }
}
