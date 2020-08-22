package com.ifdeveloper.bgdemo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifdeveloper.bgdemo.domain.GamePlay;
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

}
