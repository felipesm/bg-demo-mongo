package com.ifdeveloper.bgdemo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifdeveloper.bgdemo.domain.GamePlay;

@Repository
public interface GamePlayRepositorio extends MongoRepository<GamePlay, String> {
	
	/*
	 * ?0 - primeiro parâmetro do método
	 * ?1 - segundo parâmetro do método
	 * ...
	 */
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<GamePlay> pesquisarPorTitulo(String texto);
	
	List<GamePlay> findByTituloContainingIgnoreCase(String texto);

}
