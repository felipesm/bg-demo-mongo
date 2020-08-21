package com.ifdeveloper.bgdemo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.repositories.UsuarioRepositorio;

@Configuration
public class InicializacaoDados implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		repositorio.deleteAll();
		
		Usuario maia = new Usuario(null, "Felipe Maia", "maia@gmail.com");
		Usuario patty = new Usuario(null, "Amanda Patty", "patty@gmail.com");
		Usuario bia = new Usuario(null, "Bia Bisabel", "biabisabel@gmail.com");
		Usuario mule = new Usuario(null, "Gabi Mule", "gabimule@gmail.com");
		Usuario caio = new Usuario(null, "Caio Bode", "caiobode@yahoo.com");
		
		repositorio.saveAll(Arrays.asList(maia, mule, bia, caio, patty));
	}

}
