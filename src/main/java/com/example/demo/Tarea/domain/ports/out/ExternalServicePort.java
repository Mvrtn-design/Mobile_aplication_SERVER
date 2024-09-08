package com.example.demo.Tarea.domain.ports.out;

import com.example.demo.Tarea.domain.models.InformacionAdicional;

public interface ExternalServicePort {
    InformacionAdicional getInformacionAdicional(Long idTarea);
}
