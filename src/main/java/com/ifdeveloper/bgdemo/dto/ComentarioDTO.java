package com.ifdeveloper.bgdemo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String texto;
	
	private Date data;
	
	private JogadorDTO autor;
	
	public ComentarioDTO() {

	}

	public ComentarioDTO(String texto, Date data, JogadorDTO autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public JogadorDTO getAutor() {
		return autor;
	}

	public void setAutor(JogadorDTO autor) {
		this.autor = autor;
	}
	
}
