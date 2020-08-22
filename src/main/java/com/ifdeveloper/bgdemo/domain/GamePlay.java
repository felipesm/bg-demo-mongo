package com.ifdeveloper.bgdemo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private List<Usuario> vencedor;
	
	private List<Usuario> jogadores;
	
	private Usuario criador;
	
	public GamePlay() {
	}

	public GamePlay(String id, Date date, String titulo, List<Usuario> vencedor,
			List<Usuario> jogadores, Usuario criador) {
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

	public List<Usuario> getVencedor() {
		return vencedor;
	}

	public void setVencedor(List<Usuario> vencedor) {
		this.vencedor = vencedor;
	}

	public List<Usuario> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Usuario> jogadores) {
		this.jogadores = jogadores;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
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