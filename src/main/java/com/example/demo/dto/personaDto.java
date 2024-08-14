package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class personaDto {
    private Long id;
    private String nombreUsuario;
    private String email;
    private Long telefono;
    private String clave;

    public personaDto(Long id, String nombreUsuario, Long telefono, String email) {
    }
}