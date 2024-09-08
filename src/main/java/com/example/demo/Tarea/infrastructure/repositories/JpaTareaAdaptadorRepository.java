package com.example.demo.Tarea.infrastructure.repositories;

import com.example.demo.Tarea.domain.models.Tarea;
import com.example.demo.Tarea.domain.ports.out.TareaRepositoryPort;
import com.example.demo.Tarea.infrastructure.entity.TareaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTareaAdaptadorRepository implements TareaRepositoryPort {
    private final JpaTareaRepository jpaTareaRepository;

    public JpaTareaAdaptadorRepository(JpaTareaRepository jpaTareaRepository) {
        this.jpaTareaRepository = jpaTareaRepository;
    }

    @Override
    public Tarea save(Tarea tarea) {
        TareaEntity tareaEntity = TareaEntity.fromModel(tarea);
        jpaTareaRepository.save(tareaEntity);
        return tareaEntity.toModel();
    }

    @Override
    public Optional<Tarea> findById(Long idTarea) {
        return jpaTareaRepository.findById(idTarea).map(TareaEntity::toModel);
    }

    @Override
    public List<Tarea> findAll() {
        return jpaTareaRepository.findAll().stream().map(TareaEntity::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Tarea> updateTarea(Tarea tarea, Long idTarea) {
        if (jpaTareaRepository.existsById(idTarea)) {
            TareaEntity actualizada = jpaTareaRepository.save(TareaEntity.fromModel(tarea));
            return Optional.of(actualizada.toModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteTarea(Long idTarea) {
        if (jpaTareaRepository.existsById(idTarea)) {
            jpaTareaRepository.deleteById(idTarea);
            return true;
        }
        return false;
    }
}
