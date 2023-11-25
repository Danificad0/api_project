package com.projects.praticandoAPI.controller.dto;

import com.projects.praticandoAPI.modelo.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoDto {
    private Long id;
    private String nome;
    private double custo;

    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.custo = curso.getCusto();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public static List<CursoDto> converter(List<Curso> cursos) {
        return cursos.stream().map(CursoDto::new).collect(Collectors.toList());
    }
}
