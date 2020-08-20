package com.ifdeveloper.bgdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> listarTodos() {
		return repositorio.findAll();
	}

}
