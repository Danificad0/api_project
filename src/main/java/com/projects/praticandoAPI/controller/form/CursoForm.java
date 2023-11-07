package com.projects.praticandoAPI.controller.form;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.repository.CursoRepository;

public class CursoForm {
	private Long id;
	private String nome;
	private String categoria;
	
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Curso converter(CursoRepository cursoRepository) {
		return new Curso(id, nome, categoria);
	}
}
	
	
