package br.com.bravis.contatoClimaApi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bravis.contatoClimaApi.dto.PessoaDTO;
import br.com.bravis.contatoClimaApi.model.Pessoa;
import br.com.bravis.contatoClimaApi.service.PessoaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pessoa> getPessoa(@PathVariable Long id) throws ObjectNotFoundException {

		Pessoa obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> incluir(@Valid @RequestBody PessoaDTO obj) {

		Pessoa novaPessoa = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaPessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody PessoaDTO objDto, @PathVariable Long id) {

		Pessoa obj = this.service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
