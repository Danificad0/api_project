// ProfessorForm.java
package com.projects.praticandoAPI.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProfessorForm {

    @NotEmpty
    public String nome;

    @NotNull
    public Long cursoId;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

    // setters
    
}
