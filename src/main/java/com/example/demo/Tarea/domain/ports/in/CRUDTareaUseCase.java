package com.example.demo.Tarea.domain.ports.in;

import com.example.demo.Tarea.domain.models.Tarea;

import java.util.List;
import java.util.Optional;

public interface CRUDTareaUseCase {
    Tarea crearTarea(Tarea tarea);

    Optional<Tarea> getTareaById(Long idTarea);
    List<Tarea> getAllTarea();

    Optional<Tarea> actualizarTarea(Tarea tarea, Long idTarea);

    boolean eliminarTarea(Long idTarea);
}
