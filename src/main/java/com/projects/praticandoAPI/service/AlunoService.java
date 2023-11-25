package com.projects.praticandoAPI.service;

import org.springframework.stereotype.Service;

import com.projects.praticandoAPI.modelo.Aluno;

@Service
public class AlunoService {

	 public void concluirCursoComMediaSuperiorASete(Aluno aluno) {
	        aluno.setNumeroCursosConcluidos(aluno.getNumeroCursosConcluidos() + 1);

	        if (!aluno.isPremium() && aluno.getNumeroCursosConcluidos() >= 12) {
	            aluno.setPremium(true);
	        }
	        if (aluno.isPremium()) {
	            aluno.setMoedas(aluno.getMoedas() + 3);
	        }
	    }

    public void usarMoedas(Aluno aluno, int quantidade) {
        if (aluno.getMoedas() >= quantidade) {
            aluno.setMoedas(aluno.getMoedas() - quantidade);
        } else {
            System.out.println("Moedas insuficientes.");
        }
    }

    public boolean podeTrocarPorCriptomoeda(Aluno aluno) {
        return aluno.getMoedas() >= 1;
    }
}
