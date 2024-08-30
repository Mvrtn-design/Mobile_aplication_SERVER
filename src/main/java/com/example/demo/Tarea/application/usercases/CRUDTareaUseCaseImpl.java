package com.example.demo.Tarea.application.usercases;

import com.example.demo.Tarea.domain.models.Tarea;
import com.example.demo.Tarea.domain.ports.in.CRUDTareaUseCase;
import com.example.demo.Tarea.domain.ports.out.TareaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class CRUDTareaUseCaseImpl implements CRUDTareaUseCase {

    private final TareaRepositoryPort tareaRepositoryPort;

    public CRUDTareaUseCaseImpl(TareaRepositoryPort tareaRepositoryPort) {
        this.tareaRepositoryPort = tareaRepositoryPort;
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepositoryPort.save(tarea);
    }

    @Override
    public Optional<Tarea> getTareaById(Long idTarea) {
        return tareaRepositoryPort.findById(idTarea);
    }

    @Override
    public List<Tarea> getAllTarea() {
        return tareaRepositoryPort.findAll();
    }

    @Override
    public Optional<Tarea> actualizarTarea(Tarea tarea, Long idTarea) {

        return tareaRepositoryPort.updateTarea(tarea, idTarea);

    }

    @Override
    public boolean eliminarTarea(Long idTarea) {
        return tareaRepositoryPort.deleteTarea(idTarea);
    }
}
