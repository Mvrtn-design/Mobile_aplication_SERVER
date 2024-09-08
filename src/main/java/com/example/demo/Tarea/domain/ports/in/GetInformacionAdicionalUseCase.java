package com.example.demo.Tarea.domain.ports.in;

import com.example.demo.Tarea.domain.models.InformacionAdicional;

public interface GetInformacionAdicionalUseCase {
    InformacionAdicional getInformacionAdicional(Long IdTarea);
}
