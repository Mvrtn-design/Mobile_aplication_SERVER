package com.example.demo.Paciente.repository;

import com.example.demo.Paciente.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PacienteRepository extends JpaRepository<Paciente, Long> {
}