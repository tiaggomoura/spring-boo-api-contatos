package br.com.bravis.contatoClimaApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bravis.contatoClimaApi.dto.ContatoDTO;
import br.com.bravis.contatoClimaApi.dto.PessoaDTO;
import br.com.bravis.contatoClimaApi.exceptions.ObjectNotFoundException;
import br.com.bravis.contatoClimaApi.exceptions.RegraNegocioException;
import br.com.bravis.contatoClimaApi.model.Contato;
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

		if (this.repository.existsByNome(obj.getNome())) {
			throw new RegraNegocioException("Já existe uma Pessoa cadastrada com o nome: " + obj.getNome() + ", Tipo: " + Pessoa.class.getName());
		}
		
		Pessoa novaPessoa = new Pessoa(obj);
		return this.repository.save(novaPessoa);
	}

	public Pessoa update(Pessoa obj) {

		Pessoa newObj = this.findById(obj.getId());
		this.updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Pessoa newObj, Pessoa obj) {

		newObj.setNome(obj.getNome());
		newObj.setIdade(obj.getIdade());

	}

	public Pessoa fromDTO(PessoaDTO objDto) {

		return new Pessoa(objDto).comID(objDto.getId());
	}

	public void delete(Long id) {

		this.findById(id);
		this.repository.deleteById(id);

	}

}
