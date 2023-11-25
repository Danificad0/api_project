package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int numeroCursosConcluidos;
	private boolean isPremium;
    private int moedas;

    public Aluno() {
 
    }
    
    public Aluno(int numeroCursosConcluidos, boolean isPremium, int moedas) {
        this.numeroCursosConcluidos = numeroCursosConcluidos;
        this.isPremium = isPremium;
        this.moedas = moedas;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPremium() {
	    return isPremium;
	}

    public int getMoedas() {
        return moedas;
    }

    public boolean podeTrocarPorCriptomoeda() {
        return moedas >= 1;
    }
    public int getNumeroCursosConcluidos() {
		return numeroCursosConcluidos;
	}

	public void setNumeroCursosConcluidos(int numeroCursosConcluidos) {
		this.numeroCursosConcluidos = numeroCursosConcluidos;
	}

	public void setPremium(boolean isPremium) {
	    this.isPremium = isPremium;
	}

	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}


}