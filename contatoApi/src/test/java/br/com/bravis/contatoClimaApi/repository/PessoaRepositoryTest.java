package br.com.bravis.contatoClimaApi.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.bravis.contatoClimaApi.model.Pessoa;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PessoaRepositoryTest {

	@Autowired
	PessoaRepository repository;

	@Test
	public void deveVerificarSeJaExistePessoaCadastradaComMesmoNome() {

		Pessoa pessoa = Pessoa.builder().idade(18).nome("Tiago Moura").build();
		this.repository.save(pessoa);

		boolean condicao = this.repository.existsByNome("Tiago Moura");

		Assertions.assertThat(condicao).isTrue();
	}

}
