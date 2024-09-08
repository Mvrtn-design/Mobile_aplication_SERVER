package com.example.demo.Tarea.infrastructure.repositories;

import com.example.demo.Tarea.infrastructure.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTareaRepository extends JpaRepository<TareaEntity, Long> {
}
