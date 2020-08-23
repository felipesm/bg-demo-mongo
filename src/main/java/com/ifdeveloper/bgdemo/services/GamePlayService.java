package com.ifdeveloper.bgdemo.services;

import java.util.Calendar;
import java.util.Date;
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
	
	public List<GamePlay> pesquisarPorTituloEData(String texto, Date dataInicial, Date dataFinal) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataFinal);
		calendar.add(Calendar.HOUR, 23);
		calendar.add(Calendar.MINUTE, 59);
		calendar.add(Calendar.SECOND, 59);
		
		dataFinal = calendar.getTime();
		
		return repositorio.pesquisarPorTituloEData(texto, dataInicial, dataFinal);
	}
}
