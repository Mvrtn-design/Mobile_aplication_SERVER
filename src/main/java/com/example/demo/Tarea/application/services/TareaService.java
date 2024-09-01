package com.example.demo.Tarea.application.services;

import com.example.demo.Tarea.domain.models.InformacionAdicional;
import com.example.demo.Tarea.domain.models.Tarea;
import com.example.demo.Tarea.domain.ports.in.CRUDTareaUseCase;
import com.example.demo.Tarea.domain.ports.in.GetInformacionAdicionalUseCase;

import java.util.List;
import java.util.Optional;

public class TareaServices implements CRUDTareaUseCase, GetInformacionAdicionalUseCase {

    private final CRUDTareaUseCase crudTareaUseCase;
    private final GetInformacionAdicionalUseCase getInformacionAdicionalUseCase;

    public TareaServices(CRUDTareaUseCase crudTareaUseCase, GetInformacionAdicionalUseCase getInformacionAdicionalUseCase) {
        this.crudTareaUseCase = crudTareaUseCase;
        this.getInformacionAdicionalUseCase = getInformacionAdicionalUseCase;
    }


    @Override
    public Tarea crearTarea(Tarea tarea) {
        return crudTareaUseCase.crearTarea(tarea);
    }

    @Override
    public Optional<Tarea> getTareaById(Long idTarea) {
        return crudTareaUseCase.getTareaById(idTarea);
    }

    @Override
    public List<Tarea> getAllTarea() {
        return crudTareaUseCase.getAllTarea();
    }

    @Override
    public Optional<Tarea> actualizarTarea(Tarea tarea, Long idTarea) {
        return crudTareaUseCase.actualizarTarea(tarea, idTarea);
    }

    @Override
    public boolean eliminarTarea(Long idTarea) {
        return crudTareaUseCase.eliminarTarea(idTarea);
    }

    @Override
    public InformacionAdicional getInformacionAdicional(Long IdAdicional) {
        return getInformacionAdicionalUseCase.getInformacionAdicional(IdAdicional);
    }
}
