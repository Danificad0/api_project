package com.projects.praticandoAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.praticandoAPI.controller.dto.AlunoDto;
import com.projects.praticandoAPI.controller.form.AlunoForm;
import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.repository.AlunoRepository;
import com.projects.praticandoAPI.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService; // Injetando o AlunoService

    @GetMapping
    public List<AlunoDto> lista() {
        List<Aluno> alunos = alunoRepository.findAll();
        return AlunoDto.converter(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> cadastrar(@RequestBody AlunoForm alunoForm, UriComponentsBuilder uriBuilder) {
        Aluno aluno = alunoForm.converter(alunoRepository);
        alunoRepository.save(aluno);

        // Utilizando o AlunoService para manipular a lógica de negócios
        alunoService.concluirCursoComMediaSuperiorASete(aluno);

        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }
}
