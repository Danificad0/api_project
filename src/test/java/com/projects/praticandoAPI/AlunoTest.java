package com.projects.praticandoAPI;

import org.junit.Test;

import com.projects.praticandoAPI.modelo.Aluno;

import static org.junit.Assert.*;

public class AlunoTest {
	
	 @Test
	    public void testConquistarStatusPremium() {
	        Aluno aluno = new Aluno();
	        for (int i = 0; i < 12; i++) {
	            aluno.concluirCursoComMediaSuperiorASete();
	        }
	        assertTrue(aluno.isPremium());
	    }

	    @Test
	    public void testBeneficiosStatusPremium() {
	        Aluno aluno = new Aluno();
	        for (int i = 0; i < 13; i++) {
	            aluno.concluirCursoComMediaSuperiorASete();
	        }

	        int moedas = aluno.getMoedas();
	        assertEquals(3, moedas);
	    }

	    @Test
	    public void testUsoDasMoedas() {
	        Aluno aluno = new Aluno();
	        for (int i = 0; i < 13; i++) {
	            aluno.concluirCursoComMediaSuperiorASete();
	        }

	        aluno.usarMoedas(2);
	        assertEquals(1, aluno.getMoedas());
	        assertTrue(aluno.podeTrocarPorCriptomoeda());
	    }

}
