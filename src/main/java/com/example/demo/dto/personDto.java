package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class personDto {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String clave;
    private int age;
}