package com.example.demo.repository;

import com.example.demo.entity.person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepository extends JpaRepository<person, Long> {
}
