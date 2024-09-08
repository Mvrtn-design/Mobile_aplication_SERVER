package com.example.demo.Usuario.application.services;

import com.example.demo.Usuario.domain.model.Usuario;
import com.example.demo.Usuario.domain.model.map.UsuarioMap;
import com.example.demo.Usuario.infrastructure.entity.UsuarioDto;
import com.example.demo.Usuario.infrastructure.repository.JpaUsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioServiceImpl implements UsuarioService{

    private JpaUsuarioRepository repositorioUsuario;

    @Override
    public UsuarioDto addUsuario(UsuarioDto usuarioDto) {
        Usuario uu = UsuarioMap.mapToUsuario(usuarioDto);
        repositorioUsuario.save(uu);
        return UsuarioMap.maptoUsuarioDto(uu);
    }

    @Override
    public Optional <UsuarioDto> findUsuarioById(Long idUsuario) {
       return repositorioUsuario.findById(idUsuario).map((usuario)-> UsuarioMap.maptoUsuarioDto(usuario));
    }

    @Override
    public List<UsuarioDto> findAllUsuarios() {
        return repositorioUsuario.findAll().stream().map((usuario)-> UsuarioMap.maptoUsuarioDto(usuario)).collect(Collectors.toList());
    }

    @Override
    public Optional <UsuarioDto> updateUsuario(UsuarioDto dto, Long idUsuario) {
        if (repositorioUsuario.existsById(idUsuario)){
            Usuario actualizado = repositorioUsuario.save(UsuarioMap.mapToUsuario(dto));
            return Optional.of(UsuarioMap.maptoUsuarioDto(actualizado));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteUsuario(Long idUsuario) {
        if (repositorioUsuario.existsById(idUsuario)){
            repositorioUsuario.deleteById(idUsuario);
            return true;
        }
        return false;
    }
}
