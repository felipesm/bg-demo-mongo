package com.ifdeveloper.bgdemo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifdeveloper.bgdemo.domain.GamePlay;
import com.ifdeveloper.bgdemo.resources.util.URL;
import com.ifdeveloper.bgdemo.services.GamePlayService;

@RestController
@RequestMapping(value = "/gameplay")
public class GamePlayResource {
	
	@Autowired
	private GamePlayService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<GamePlay> buscarPorId(@PathVariable String id) {
		GamePlay game = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(game);
	}
	
	@RequestMapping(value = "/titulo", method = RequestMethod.GET)
	public ResponseEntity<List<GamePlay>> buscarPorTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.decodeParam(texto);
		List<GamePlay> games = service.buscarPorTitulo(texto);
		
		return ResponseEntity.ok().body(games);
	}
	
	@RequestMapping(value = "/titulopordata", method = RequestMethod.GET)
	public ResponseEntity<List<GamePlay>> buscarPorTituloEData(
			@RequestParam(value = "texto", defaultValue = "") String texto, 
			@RequestParam(value = "dataInicial", defaultValue = "") String dataInicial,
			@RequestParam(value = "dataFinal", defaultValue = "") String dataFinal) {
		
		texto = URL.decodeParam(texto);
		Date dataIni = URL.converterData(dataInicial, new Date(0L));
		Date dataFim = URL.converterData(dataFinal, new Date());
		
		List<GamePlay> games = service.pesquisarPorTituloEData(texto, dataIni, dataFim);
		return ResponseEntity.ok().body(games);
	}

}
