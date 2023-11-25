package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Aluno;

public class AlunoDto {
	private Long id;
	private int numeroCursosConcluidos;
    private boolean isPremium;
    private int moedas;

    public AlunoDto(Aluno aluno) {
    	this.id = aluno.getId();
        this.numeroCursosConcluidos = aluno.getNumeroCursosConcluidos();
        this.isPremium = aluno.isPremium();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public static List <AlunoDto> converter (List<Aluno> alunos){
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

}
