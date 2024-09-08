package com.example.demo.Paciente.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private Long telefono;
    private String email;

}