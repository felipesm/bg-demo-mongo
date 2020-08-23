package com.ifdeveloper.bgdemo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ifdeveloper.bgdemo.domain.GamePlay;
import com.ifdeveloper.bgdemo.domain.Usuario;
import com.ifdeveloper.bgdemo.dto.ComentarioDTO;
import com.ifdeveloper.bgdemo.dto.JogadorDTO;
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
		
		repositorio.saveAll(Arrays.asList(maia, mule, bia, caio, patty));
		
		GamePlay game1 = new GamePlay(null, dateFormat.parse("08/01/2020"), "GamePlay Carcassonne", Arrays.asList(new JogadorDTO(maia)), 
				Arrays.asList(new JogadorDTO(maia), new JogadorDTO(mule), new JogadorDTO(caio), new JogadorDTO(bia)), new JogadorDTO(maia));
		
		GamePlay game2 = new GamePlay(null, dateFormat.parse("27/01/2020"), "Jogatina de Domingo - No Thanks", Arrays.asList(new JogadorDTO(mule)), 
				Arrays.asList(new JogadorDTO(maia), new JogadorDTO(mule), new JogadorDTO(caio), new JogadorDTO(patty), new JogadorDTO(bia)), new JogadorDTO(caio));
		
		GamePlay game3 = new GamePlay(null, dateFormat.parse("03/03/2020"), "Ticket to Ride", 
				Arrays.asList(new JogadorDTO(patty), new JogadorDTO(bia)), Arrays.asList(new JogadorDTO(maia), new JogadorDTO(mule), new JogadorDTO(patty), new JogadorDTO(bia)), new JogadorDTO(bia));
		
		GamePlay game4 = new GamePlay(null, dateFormat.parse("08/03/2020"), "Five Tribes", 
				Arrays.asList(new JogadorDTO(maia)), Arrays.asList(new JogadorDTO(maia), new JogadorDTO(bia), new JogadorDTO(patty)), new JogadorDTO(maia));
		
		GamePlay game5 = new GamePlay(null, dateFormat.parse("16/03/2020"), "GamePlay Port Royal", 
				Arrays.asList(new JogadorDTO(caio)), Arrays.asList(new JogadorDTO(maia), new JogadorDTO(bia), new JogadorDTO(patty), new JogadorDTO(caio)), new JogadorDTO(caio));
		
		ComentarioDTO comentario1 = new ComentarioDTO("Mitei!", dateFormat.parse("08/01/2020"), new JogadorDTO(maia));
		ComentarioDTO comentario2 = new ComentarioDTO("Foi muita sorte...", dateFormat.parse("08/01/2020"), new JogadorDTO(bia));
		ComentarioDTO comentario3 = new ComentarioDTO("Dúvido ganhar de novo ¬¬", dateFormat.parse("09/01/2020"), new JogadorDTO(caio));
		
		ComentarioDTO comentario4 = new ComentarioDTO("Hahah arrasei", dateFormat.parse("28/01/2020"), new JogadorDTO(mule));
		ComentarioDTO comentario5 = new ComentarioDTO("Fui pegar aquela carta, me ferrei kkk :(", dateFormat.parse("28/01/2020"), new JogadorDTO(maia));
		ComentarioDTO comentario6 = new ComentarioDTO("Oxe essa doida é muito cagona", dateFormat.parse("28/01/2020"), new JogadorDTO(caio));
		ComentarioDTO comentario7 = new ComentarioDTO("Felipe só faz besteira...", dateFormat.parse("28/01/2020"), new JogadorDTO(patty));
		
		ComentarioDTO comentario8 = new ComentarioDTO("Amandinha trapaceou kkk", dateFormat.parse("03/03/2020"), new JogadorDTO(bia));
		ComentarioDTO comentario9 = new ComentarioDTO("Bia trapaceou kkkkk", dateFormat.parse("03/03/2020"), new JogadorDTO(patty));
		
		game1.getComentarios().addAll(Arrays.asList(comentario1, comentario2, comentario3));
		game2.getComentarios().addAll(Arrays.asList(comentario4, comentario5, comentario6, comentario7));
		game3.getComentarios().addAll(Arrays.asList(comentario8, comentario9));
		
		gameRepositorio.saveAll(Arrays.asList(game1, game2, game3, game4, game5));
		
		maia.getGames().addAll(Arrays.asList(game1, game4));
		caio.getGames().addAll(Arrays.asList(game2, game5));
		bia.getGames().addAll(Arrays.asList(game3));
		
		repositorio.saveAll(Arrays.asList(maia, caio, bia));
	}

}
