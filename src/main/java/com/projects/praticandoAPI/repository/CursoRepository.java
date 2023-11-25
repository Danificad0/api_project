package com.projects.praticandoAPI.repository;

import com.projects.praticandoAPI.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
