package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static Long id;

    @Column(name ="nombreUsuario", nullable = false)
    private static String nombreUsuario;

    @Column(name = "email")
    private static String email;

    @Column(name = "telefono")
    private static Long telefono;

    @Column(name = "clave")
    private static String clave;

    public person(Long id, String nombreUsuario, Long telefono, String email) {
    }

    public static Long getId() {
        return id;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String name) {
        this.nombreUsuario = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public static String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
