package com.example.demo.Paciente.infrastructure.repository;

import com.example.demo.Paciente.domain.models.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PacienteRepository extends JpaRepository<Paciente, Long> {
}