package com.projects.praticandoAPI;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.service.AlunoService;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunoTest {

    @Autowired
    private AlunoService alunoService;

    @Test
    public void testConquistarStatusPremium() {
        Aluno aluno = new Aluno();
        for (int i = 0; i < 12; i++) {
            alunoService.concluirCursoComMediaSuperiorASete(aluno);
        }
        assertTrue(aluno.isPremium());
    }

    @Test
    public void testBeneficiosStatusPremium() {
        Aluno aluno = new Aluno();
        for (int i = 0; i < 13; i++) {
            alunoService.concluirCursoComMediaSuperiorASete(aluno);
        }

        int moedas = aluno.getMoedas();
        assertEquals(6, moedas);
    }

    @Test
    public void testUsoDasMoedas() {
        Aluno aluno = new Aluno();
        for (int i = 0; i < 13; i++) {
            alunoService.concluirCursoComMediaSuperiorASete(aluno);
        }

        alunoService.usarMoedas(aluno, 2);
        assertEquals(4, aluno.getMoedas());
        assertTrue(aluno.podeTrocarPorCriptomoeda());
    }
}

