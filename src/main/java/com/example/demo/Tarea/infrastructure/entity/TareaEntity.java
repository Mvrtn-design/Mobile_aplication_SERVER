package com.example.demo.Tarea.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fecha;
    private boolean terminado;

    public TareaEntity(long id, String titulo, String descripcion, LocalDateTime fecha, boolean terminado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.terminado = terminado;
    }
    public TareaEntity(){}
}
