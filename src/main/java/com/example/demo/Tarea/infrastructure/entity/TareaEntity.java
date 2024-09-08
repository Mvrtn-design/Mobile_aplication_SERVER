package com.example.demo.Tarea.infrastructure.entity;

import com.example.demo.Tarea.domain.models.Tarea;
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

    public TareaEntity(String titulo, String descripcion, LocalDateTime fecha, boolean terminado) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.terminado = terminado;
    }

    public TareaEntity() {
    }

    public static TareaEntity fromModel(Tarea tarea) {
        return new TareaEntity( tarea.getTitulo(), tarea.getDescripcion(), tarea.getFechaCreacion(), tarea.isCompletada());
    }

    public  Tarea toModel(){
        return new Tarea(titulo,descripcion,fecha,terminado);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
}
