package br.com.bravis.contatoClimaApi.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bravis.contatoClimaApi.model.Contato;
import br.com.bravis.contatoClimaApi.model.Pessoa;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> {

	Set<Contato> findByPessoa(Pessoa pessoa);

}
