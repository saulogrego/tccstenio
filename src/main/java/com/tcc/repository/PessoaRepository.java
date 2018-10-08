package com.tcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tcc.domain.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String>{

}
