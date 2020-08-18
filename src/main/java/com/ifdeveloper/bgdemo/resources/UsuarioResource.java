package com.ifdeveloper.bgdemo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifdeveloper.bgdemo.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		Usuario usuarioA = new Usuario(1, "Joao Spring", "joao@gmail.com");
		Usuario usuarioB = new Usuario(2, "Mari Boot", "maria@gmail.com");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.addAll(Arrays.asList(usuarioA, usuarioB));
		
		return ResponseEntity.ok().body(usuarios);
	}

}
