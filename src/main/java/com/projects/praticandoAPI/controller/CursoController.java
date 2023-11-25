package com.projects.praticandoAPI.controller;

import com.projects.praticandoAPI.controller.dto.CursoDto;
import com.projects.praticandoAPI.controller.form.CursoForm;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto> listarCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converter(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> detalharCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso != null) {
            return ResponseEntity.ok(new CursoDto(curso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CursoDto> criarCurso(@RequestBody @Valid CursoForm cursoForm) {
        Curso curso = cursoForm.converter();
        cursoRepository.save(curso);

        URI uri = URI.create("/cursos/" + curso.getId());
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }
}
