package br.com.bravis.contatoClimaApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bravis.contatoClimaApi.dto.ContatoDTO;
import br.com.bravis.contatoClimaApi.exceptions.ObjectNotFoundException;
import br.com.bravis.contatoClimaApi.model.Contato;
import br.com.bravis.contatoClimaApi.model.Pessoa;
import br.com.bravis.contatoClimaApi.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ContatoRepository repository;

	public Contato findById(Long id) throws ObjectNotFoundException {

		Optional<Contato> obj = this.repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado para o ID: " + id + ", Tipo: " + Contato.class.getName()));
	}

	public Contato insert(ContatoDTO obj) throws ObjectNotFoundException {

		Pessoa registro = this.pessoaService.findById(obj.getIdPessoa());

		Contato novoContato = new Contato(obj).registrarPara(registro);

		return this.repository.save(novoContato);
	}
}
