package com.ifdeveloper.bgdemo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ifdeveloper.bgdemo.dto.ComentarioDTO;
import com.ifdeveloper.bgdemo.dto.JogadorDTO;

@Document
public class GamePlay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private Date date;
	
	private String titulo;
	
	/**
	 * Atributo do tipo lista pois pode existir mais de um vencedor (empate).
	 */
	private List<JogadorDTO> vencedor;
	
	private List<JogadorDTO> jogadores;
	
	private JogadorDTO criador;
	
	private List<ComentarioDTO> comentarios = new ArrayList<>();
	
	public GamePlay() {
	}

	public GamePlay(String id, Date date, String titulo, List<JogadorDTO> vencedor,
			List<JogadorDTO> jogadores, JogadorDTO criador) {
		super();
		this.id = id;
		this.date = date;
		this.titulo = titulo;
		this.vencedor = vencedor;
		this.jogadores = jogadores;
		this.criador = criador;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<JogadorDTO> getVencedor() {
		return vencedor;
	}

	public void setVencedor(List<JogadorDTO> vencedor) {
		this.vencedor = vencedor;
	}

	public List<JogadorDTO> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<JogadorDTO> jogadores) {
		this.jogadores = jogadores;
	}

	public JogadorDTO getCriador() {
		return criador;
	}

	public void setCriador(JogadorDTO criador) {
		this.criador = criador;
	}
	
	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamePlay other = (GamePlay) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
