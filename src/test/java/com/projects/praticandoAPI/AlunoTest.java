package com.projects.praticandoAPI;

import org.junit.Test;

import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.service.AlunoService;

import static org.junit.Assert.*;

public class AlunoTest {
    
    @Test
    public void testConquistarStatusPremium() {
        AlunoService alunoService = new AlunoService(); // Instanciando AlunoService
        Aluno aluno = new Aluno();
        for (int i = 0; i < 12; i++) {
            alunoService.concluirCursoComMediaSuperiorASete(aluno); // Usando AlunoService
        }
        assertTrue(aluno.isPremium());
    }

    @Test
    public void testBeneficiosStatusPremium() {
        AlunoService alunoService = new AlunoService(); // Instanciando AlunoService
        Aluno aluno = new Aluno();
        for (int i = 0; i < 13; i++) {
            alunoService.concluirCursoComMediaSuperiorASete(aluno); // Usando AlunoService
        }

        int moedas = aluno.getMoedas();
        assertEquals(6, moedas);
    }

    @Test
    public void testUsoDasMoedas() {
        AlunoService alunoService = new AlunoService(); // Instanciando AlunoService
        Aluno aluno = new Aluno();
        for (int i = 0; i < 13; i++) {
            alunoService.concluirCursoComMediaSuperiorASete(aluno); // Usando AlunoService
        }

        alunoService.usarMoedas(aluno, 2); // Usando AlunoService
        assertEquals(4, aluno.getMoedas());
        assertTrue(aluno.podeTrocarPorCriptomoeda());
    }
}
