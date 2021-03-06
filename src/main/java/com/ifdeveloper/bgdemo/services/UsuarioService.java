package com.ifdeveloper.bgdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.repositories.UsuarioRepositorio;
import com.ifdeveloper.bgdemo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> listarTodos() {
		return repositorio.findAll();
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado através do Id: " + id));
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorio.insert(usuario);
	}
	
	public Usuario atualizar(Usuario obj) {
		Usuario usuario = buscarPorId(obj.getId());
		atualizarDados(obj, usuario);
		return repositorio.save(usuario);
	}
	
	private void atualizarDados(Usuario novoUsuario, Usuario atualUsuario) {
		atualUsuario.setNome(novoUsuario.getNome());
		atualUsuario.setEmail(novoUsuario.getEmail());
	}
	
	public void deletar(String id) {
		buscarPorId(id);
		repositorio.deleteById(id);
	}
	
}
