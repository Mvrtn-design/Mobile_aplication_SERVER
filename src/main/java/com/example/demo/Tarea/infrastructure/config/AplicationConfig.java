package com.example.demo.Tarea.infrastructure.config;

import com.example.demo.Tarea.application.services.TareaService;
import com.example.demo.Tarea.application.usercases.CRUDTareaUseCaseImpl;
import com.example.demo.Tarea.application.usercases.GetInformacionAdicionalUseCaseImpl;
import com.example.demo.Tarea.domain.ports.in.GetInformacionAdicionalUseCase;
import com.example.demo.Tarea.domain.ports.out.ExternalServicePort;
import com.example.demo.Tarea.domain.ports.out.TareaRepositoryPort;
import com.example.demo.Tarea.infrastructure.adapters.ExternalServiceAdapter;
import com.example.demo.Tarea.infrastructure.repositories.JpaTareaAdaptadorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfig {
    @Bean
    public TareaService miTareaService(@Qualifier("jpaTareaAdaptadorRepository") TareaRepositoryPort mitareaRepositoryPort, GetInformacionAdicionalUseCase getInformacionAdicionalUseCase) {
        return new TareaService(new CRUDTareaUseCaseImpl(mitareaRepositoryPort), getInformacionAdicionalUseCase);
    }

    @Bean
    public TareaRepositoryPort miTtareaRepositoryPort(JpaTareaAdaptadorRepository jpaTareaAdaptadorRepository) {
        return jpaTareaAdaptadorRepository;
    }

    @Bean
    public GetInformacionAdicionalUseCase getGetInformacionAdicionalUseCase(@Qualifier("externalRepositoryPort") ExternalServicePort externalServicePort) {
        return new GetInformacionAdicionalUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalRepositoryPort() {
        return new ExternalServiceAdapter();
    }

}
