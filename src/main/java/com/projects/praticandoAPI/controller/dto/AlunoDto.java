package com.projects.praticandoAPI.controller.dto;

import com.projects.praticandoAPI.modelo.Aluno;

public class AlunoDto {
	private int numeroCursosConcluidos;
    private boolean isPremium;
    private int moedas;

    public AlunoDto(Aluno aluno) {
        this.numeroCursosConcluidos = aluno.getNumeroCursosConcluidos();
        this.isPremium = aluno.getPremium(isPremium);
        this.moedas = aluno.getMoedas();
        
    }
    
    public int getNumeroCursosConcluidos() {
		return numeroCursosConcluidos;
    	
    }
    
    public boolean getPremium() {
    	return isPremium;
    }
    
    public int getMoedas() {
    	return moedas;
    }

}
