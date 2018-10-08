package com.tcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.domain.Pessoa;
import com.tcc.dto.PessoaDTO;
import com.tcc.repository.PessoaRepository;
import com.tcc.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa findById(String id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.insert(pessoa);
	}
	
	public Pessoa fromDTO(PessoaDTO pessoaDto) {
		return new Pessoa(pessoaDto.getId(), pessoaDto.getNome(), pessoaDto.getEndereco(), pessoaDto.getEmail());
	}
}
