package com.ifdeveloper.bgdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ifdeveloper.bgdemo.domain.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

}
