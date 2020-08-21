package com.ifdeveloper.bgdemo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.dto.UsuarioDTO;
import com.ifdeveloper.bgdemo.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
		
		List<Usuario> usuarios = service.listarTodos();
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usuariosDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id) {
		Usuario usuario = service.buscarPorId(id);
		
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuarioDTO) {
		UsuarioDTO userDTO = new UsuarioDTO();
		
		Usuario usuario = userDTO.getUsuario(usuarioDTO);
		usuario = service.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
