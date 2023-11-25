package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.repository.AlunoRepository;

public class AlunoForm {
    private int numeroCursosConcluidos;
    private boolean isPremium;
    private int moedas;

    // Getters e setters (você pode gerar esses métodos automaticamente na sua IDE)

    public int getNumeroCursosConcluidos() {
        return numeroCursosConcluidos;
    }

    public void setNumeroCursosConcluidos(int numeroCursosConcluidos) {
        this.numeroCursosConcluidos = numeroCursosConcluidos;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public Aluno converter(AlunoRepository alunoRepository) {
        return new Aluno(numeroCursosConcluidos, isPremium, moedas);
    }
}
