package com.example.demo.Tarea.domain.ports.out;

import com.example.demo.Tarea.domain.models.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaRepositoryPort {
    Tarea save(Tarea tarea);

    Optional<Tarea> findById(Long idTarea);

    List<Tarea> findAll();

    Optional<Tarea> updateTarea(Tarea tarea, Long idTarea);

    boolean deleteTarea(Long idTarea);
}
