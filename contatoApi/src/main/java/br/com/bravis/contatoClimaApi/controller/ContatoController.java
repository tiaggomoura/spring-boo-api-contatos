package br.com.bravis.contatoClimaApi.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bravis.contatoClimaApi.dto.ContatoDTO;
import br.com.bravis.contatoClimaApi.model.Contato;
import br.com.bravis.contatoClimaApi.service.ContatoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private ContatoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> getContato(@PathVariable Long id) throws ObjectNotFoundException {

		Contato obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> incluir(@RequestBody ContatoDTO obj) throws ObjectNotFoundException {

		Contato novoContato = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoContato.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @RequestBody ContatoDTO objDto, @PathVariable Long id) {

		Contato obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	

}
