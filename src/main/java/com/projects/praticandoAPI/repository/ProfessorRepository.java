package com.projects.praticandoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projects.praticandoAPI.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

