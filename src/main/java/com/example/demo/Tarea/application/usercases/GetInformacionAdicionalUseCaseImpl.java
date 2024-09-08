package com.example.demo.Tarea.application.usercases;

import com.example.demo.Tarea.domain.models.InformacionAdicional;
import com.example.demo.Tarea.domain.ports.in.GetInformacionAdicionalUseCase;
import com.example.demo.Tarea.domain.ports.out.ExternalServicePort;

public class GetInformacionAdicionalUseCaseImpl implements GetInformacionAdicionalUseCase {

    private final ExternalServicePort externalServicePort;

    public GetInformacionAdicionalUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public InformacionAdicional getInformacionAdicional(Long IdTarea) {
        return externalServicePort.getInformacionAdicional(IdTarea);
    }
}
