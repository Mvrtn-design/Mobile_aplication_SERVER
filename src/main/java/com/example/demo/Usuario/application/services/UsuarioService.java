package com.example.demo.Usuario.application.services;

import com.example.demo.Usuario.infrastructure.entity.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    UsuarioDto addUsuario(UsuarioDto usuarioDto);

    Optional<UsuarioDto>

    findUsuarioById(Long idUsuario);

    List<UsuarioDto> findAllUsuarios();

    Optional<UsuarioDto> updateUsuario(UsuarioDto dto, Long idUsuario);

    boolean deleteUsuario(Long idUsuario);
}
