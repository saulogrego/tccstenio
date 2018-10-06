package com.tcc.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> findAll(){
		Pessoa saulo = new Pessoa("Saulo Grego", "Rua Vereador José Veloso", "saulogrego@gmail.com");
		Pessoa vanessa = new Pessoa("Vanessa Grego", "Rua Vereador José Veloso", "vanessincastro@gmail.com");
		List<Pessoa> list = new ArrayList<>();
		list.addAll(Arrays.asList(saulo, vanessa));
		return ResponseEntity.ok().body(list);
	}
	
}
