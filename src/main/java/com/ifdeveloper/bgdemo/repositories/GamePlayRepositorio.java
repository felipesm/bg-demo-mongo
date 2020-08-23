package com.ifdeveloper.bgdemo.repositories;

import java.util.Date;
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
	
	@Query("{ $and: [ {data: {$gte: ?1} }, {data: {$lte: ?2} }, { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<GamePlay> pesquisarPorTituloEData(String texto, Date dataInicial, Date dataFinal);

}
