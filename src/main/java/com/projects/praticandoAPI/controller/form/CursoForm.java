package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Curso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursoForm {
    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private double custo;

    public CursoForm() {
        // Construtor padrão
    }

    public CursoForm(String nome, double custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public Curso converter() {
        return new Curso(nome, custo);
    }
}
