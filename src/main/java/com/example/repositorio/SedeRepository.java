package com.example.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entidad.Sede;

public interface SedeRepository extends MongoRepository<Sede, Integer>{

}
