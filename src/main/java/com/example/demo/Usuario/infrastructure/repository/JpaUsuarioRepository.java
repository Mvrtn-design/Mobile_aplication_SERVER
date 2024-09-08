package com.example.demo.Usuario.infrastructure.repository;

import com.example.demo.Usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuarioRepository extends JpaRepository<Usuario, Long> {
}
