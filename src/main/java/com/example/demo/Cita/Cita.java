package com.example.demo.Cita;

import com.example.demo.Paciente.domain.models.entity.Paciente;
import com.example.demo.Usuario.domain.model.Usuario;

import java.time.LocalDateTime;

public class Cita {
    private Long id;
    private Paciente paciente;
    private Usuario usuario;
    private LocalDateTime fechaHora;
    private String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
