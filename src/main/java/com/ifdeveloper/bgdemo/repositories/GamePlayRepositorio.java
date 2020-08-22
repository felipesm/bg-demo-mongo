package com.ifdeveloper.bgdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ifdeveloper.bgdemo.domain.GamePlay;

@Repository
public interface GamePlayRepositorio extends MongoRepository<GamePlay, String> {

}
