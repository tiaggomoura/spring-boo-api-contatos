package br.com.bravis.contatoClimaApi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.bravis.contatoClimaApi.model.Pessoa;

public class PessoaDTO {

	@NotEmpty(message = "Campo Nome é obrigatório.")
	private String nome;

	@NotNull(message = "Campo Idade é obrigatório.")
	private Integer idade;

	public PessoaDTO() {

	}

	public PessoaDTO(Pessoa obj) {

		this.nome = obj.getNome();
		this.idade = obj.getIdade();

	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public Integer getIdade() {

		return idade;
	}

	public void setIdade(Integer idade) {

		this.idade = idade;
	}

}
