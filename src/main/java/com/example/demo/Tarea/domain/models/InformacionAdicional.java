package com.example.demo.Tarea.domain.models;

public class InformacionAdicional {
    private final Long userId;
    private final String nombreUsuario;
    private final String mail;

    public InformacionAdicional(Long userId, String nombreUsuario, String mail) {
        this.userId = userId;
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Long getUserId() {
        return userId;
    }
}
