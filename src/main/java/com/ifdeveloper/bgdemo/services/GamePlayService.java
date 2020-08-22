package com.ifdeveloper.bgdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifdeveloper.bgdemo.domain.GamePlay;
import com.ifdeveloper.bgdemo.repositories.GamePlayRepositorio;
import com.ifdeveloper.bgdemo.services.exception.ObjectNotFoundException;

@Service
public class GamePlayService {

	@Autowired
	private GamePlayRepositorio repositorio;
	
	public GamePlay buscarPorId(String id) {
		Optional<GamePlay> game = repositorio.findById(id);
		return game.orElseThrow(() -> new ObjectNotFoundException("GamePlay não encontrado através do Id: " + id));
	}
	
	public List<GamePlay> buscarPorTitulo(String texto) {
		return repositorio.pesquisarPorTitulo(texto);
	}
}
