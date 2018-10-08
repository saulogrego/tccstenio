package com.tcc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.domain.Pessoa;
import com.tcc.dto.PessoaDTO;
import com.tcc.services.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<Pessoa> list = pessoaService.findAll();
		List<PessoaDTO> listDto = list.stream().map(pessoa -> new PessoaDTO(pessoa)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PessoaDTO> findById(@PathVariable String id){
		Pessoa pessoa = pessoaService.findById(id);
		return ResponseEntity.ok().body(new PessoaDTO(pessoa));
	}
}
