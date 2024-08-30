package com.example.demo.Tarea.application.usercases;

import com.example.demo.Tarea.domain.models.InformacionAdicional;
import com.example.demo.Tarea.domain.ports.in.GetInformacionAdicionalUseCase;
import com.example.demo.Tarea.domain.ports.out.ExternalRepositoryPort;

public class GetInformacionAdicionalUseCaseImpl implements GetInformacionAdicionalUseCase {

    private final ExternalRepositoryPort externalRepositoryPort;

    public GetInformacionAdicionalUseCaseImpl(ExternalRepositoryPort externalRepositoryPort) {
        this.externalRepositoryPort = externalRepositoryPort;
    }

    @Override
    public InformacionAdicional getInformacionAdicional(Long Id) {
        return externalRepositoryPort.getInformacionAdicional(Id);
    }
}
