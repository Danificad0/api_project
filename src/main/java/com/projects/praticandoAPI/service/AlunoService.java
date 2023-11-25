package com.projects.praticandoAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.praticandoAPI.controller.form.AlunoForm;
import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
    private AlunoRepository alunoRepository;
	
	public Aluno cadastrar(AlunoForm alunoForm) {
	    Aluno aluno = alunoForm.converter(alunoRepository);
	    return alunoRepository.save(aluno);
	}

	public void concluirCursoComMediaSuperiorASete(Aluno aluno) {
	        aluno.setNumeroCursosConcluidos(aluno.getNumeroCursosConcluidos() + 1);

	        if (!aluno.isPremium() && aluno.getNumeroCursosConcluidos() >= 12) {
	            aluno.setPremium(true);
	        }
	        if (aluno.isPremium()) {
	            aluno.setMoedas(aluno.getMoedas() + 3);
	        }
	        alunoRepository.save(aluno);
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
