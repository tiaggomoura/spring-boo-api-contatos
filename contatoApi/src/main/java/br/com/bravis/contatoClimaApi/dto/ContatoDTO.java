package br.com.bravis.contatoClimaApi.dto;

import javax.validation.constraints.NotNull;

import br.com.bravis.contatoClimaApi.enums.EnumSimNao;

public class ContatoDTO {

	private Long id;

	private String numeroFone;

	private String numeroCeluar;

	private EnumSimNao numeroZap;

	@NotNull
	private Long idPessoa;

	public String getNumeroFone() {

		return numeroFone;
	}

	public void setNumeroFone(String numeroFone) {

		this.numeroFone = numeroFone;
	}

	public String getNumeroCeluar() {

		return numeroCeluar;
	}

	public void setNumeroCeluar(String numeroCeluar) {

		this.numeroCeluar = numeroCeluar;
	}

	public EnumSimNao getNumeroZap() {

		return numeroZap;
	}

	public void setNumeroZap(String numeroZap) {

		this.numeroZap = EnumSimNao.valueOf(numeroZap);
	}

	public Long getIdPessoa() {

		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {

		this.idPessoa = idPessoa;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

}
