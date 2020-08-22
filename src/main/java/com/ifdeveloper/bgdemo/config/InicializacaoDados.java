package com.ifdeveloper.bgdemo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ifdeveloper.bgdemo.domain.GamePlay;
import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.repositories.GamePlayRepositorio;
import com.ifdeveloper.bgdemo.repositories.UsuarioRepositorio;

@Configuration
public class InicializacaoDados implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private GamePlayRepositorio gameRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repositorio.deleteAll();
		gameRepositorio.deleteAll();
		
		Usuario maia = new Usuario(null, "Felipe Maia", "maia@gmail.com");
		Usuario patty = new Usuario(null, "Amanda Patty", "patty@gmail.com");
		Usuario bia = new Usuario(null, "Bia Bisabel", "biabisabel@gmail.com");
		Usuario mule = new Usuario(null, "Gabi Mule", "gabimule@gmail.com");
		Usuario caio = new Usuario(null, "Caio Bode", "caiobode@yahoo.com");
		
		GamePlay game1 = new GamePlay(null, dateFormat.parse("08/01/2020"), "GamePlay Carcassonne", Arrays.asList(maia), Arrays.asList(maia, mule, caio, bia), maia);
		GamePlay game2 = new GamePlay(null, dateFormat.parse("27/01/2020"), "Jogatina de Domingo - No Thanks", Arrays.asList(mule), Arrays.asList(maia, mule, caio, patty, bia), caio);
		GamePlay game3 = new GamePlay(null, dateFormat.parse("03/03/2020"), "Ticket to Ride", Arrays.asList(patty, bia), Arrays.asList(maia, mule, patty, bia), bia);
		
		repositorio.saveAll(Arrays.asList(maia, mule, bia, caio, patty));
		gameRepositorio.saveAll(Arrays.asList(game1, game2, game3));
	}

}
