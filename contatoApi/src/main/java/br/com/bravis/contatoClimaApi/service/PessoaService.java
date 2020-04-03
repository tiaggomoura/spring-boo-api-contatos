package br.com.bravis.contatoClimaApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bravis.contatoClimaApi.dto.PessoaDTO;
import br.com.bravis.contatoClimaApi.exceptions.ObjectNotFoundException;
import br.com.bravis.contatoClimaApi.model.Pessoa;
import br.com.bravis.contatoClimaApi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa findById(Long id) throws ObjectNotFoundException {

		Optional<Pessoa> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado para o ID: " + id + ", Tipo: " + Pessoa.class.getName()));

	}

	public Pessoa insert(PessoaDTO obj) {

		Pessoa novaPessoa = new Pessoa(obj);
		return this.repository.save(novaPessoa);
	}

}
