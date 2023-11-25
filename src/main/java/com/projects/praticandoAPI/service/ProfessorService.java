package com.projects.praticandoAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.praticandoAPI.controller.dto.ProfessorDto;
import com.projects.praticandoAPI.modelo.Professor;
import com.projects.praticandoAPI.repository.ProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

 @Autowired
 private ProfessorRepository professorRepository;

 public List<Professor> listarProfessores() {
     return professorRepository.findAll();
 }

 public Professor adicionarProfessor(ProfessorDto professorDto) {
     Professor professor = new Professor();
     professor.setNome(professorDto.getNome());
     professor.setCurso(professorDto.getCurso());

     return professorRepository.save(professor);
 }
}
