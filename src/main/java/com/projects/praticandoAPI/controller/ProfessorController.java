package com.projects.praticandoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projects.praticandoAPI.controller.dto.ProfessorDto;
import com.projects.praticandoAPI.modelo.Professor;
import com.projects.praticandoAPI.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

 @Autowired
 private ProfessorService professorService;

 @GetMapping
 public ResponseEntity<List<Professor>> listarProfessores() {
     List<Professor> professores = professorService.listarProfessores();
     return ResponseEntity.ok(professores);
 }

 @PostMapping
 public ResponseEntity<Professor> adicionarProfessor(@RequestBody ProfessorDto professorDto) {
     Professor professorCriado = professorService.adicionarProfessor(professorDto);
     return ResponseEntity.status(HttpStatus.CREATED).body(professorCriado);
 }
}
