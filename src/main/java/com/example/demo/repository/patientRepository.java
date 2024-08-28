package com.example.demo.repository;

import com.example.demo.entity.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface patientRepository extends JpaRepository<patient, Long> {
}