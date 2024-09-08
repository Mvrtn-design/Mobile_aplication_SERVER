package com.example.demo.Usuario.domain.model.map;

import com.example.demo.Usuario.domain.model.Usuario;
import com.example.demo.Usuario.infrastructure.entity.UsuarioDto;

public class UsuarioMap {
    public static UsuarioDto maptoUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(), usuario.getNombre(), usuario.getApellidos(), usuario.getNombre_usuario(), usuario.getOcupacion(), usuario.getEmail(), usuario.getTelefono()
        );
    }

    public static Usuario mapToUsuario(UsuarioDto dto) {
        return new Usuario(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getNombre_usuario(), dto.getOcupacion(), dto.getEmail(), dto.getTelefono()
        );
    }
}
