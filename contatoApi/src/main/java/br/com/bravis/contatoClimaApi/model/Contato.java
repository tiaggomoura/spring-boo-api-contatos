package br.com.bravis.contatoClimaApi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.bravis.contatoClimaApi.dto.ContatoDTO;
import br.com.bravis.contatoClimaApi.enums.EnumSimNao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_fone")
	private String numeroFone;

	@Column(name = "numero_celuar")
	private String numeroCeluar;

	@Enumerated(EnumType.STRING)
	@Column(name = "numero_zap")
	private EnumSimNao numeroZap;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public Contato(ContatoDTO obj) {
		this.numeroFone = obj.getNumeroFone();
		this.numeroCeluar = obj.getNumeroCeluar();
		this.numeroZap = obj.getNumeroZap();
	}

	public Contato registrarPara(Pessoa pessoa) {

		this.setPessoa(pessoa);
		return this;
	}

	public boolean isNumeroCelularZap() {

		return this.getNumeroZap().isSim();
	}

}
