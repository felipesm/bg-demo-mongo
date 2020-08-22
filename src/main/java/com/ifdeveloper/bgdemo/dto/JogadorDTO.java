package com.ifdeveloper.bgdemo.dto;

import java.io.Serializable;

import com.ifdeveloper.bgdemo.domain.Usuario;

public class JogadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String nome;
	
	public JogadorDTO() {
	}
	
	public JogadorDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
