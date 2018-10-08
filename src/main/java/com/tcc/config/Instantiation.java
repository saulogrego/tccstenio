package com.tcc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tcc.domain.Pessoa;
import com.tcc.repository.PessoaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "Lamar","Cincinnati","Dawn@per.com");
		Pessoa p2= new Pessoa(null, "Quentin","Tulsa","Hasad@Lorem.us");
		Pessoa p3= new Pessoa(null, "Rhona","Minot","Jescie@mus.edu");
		
		pessoaRepository.deleteAll();
		pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
