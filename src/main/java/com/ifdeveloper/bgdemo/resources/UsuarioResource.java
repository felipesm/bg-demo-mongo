package com.ifdeveloper.bgdemo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		
		List<Usuario> usuarios = service.listarTodos();
		
		return ResponseEntity.ok().body(usuarios);
	}

}
