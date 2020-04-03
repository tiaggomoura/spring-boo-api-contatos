package br.com.bravis.contatoClimaApi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bravis.contatoClimaApi.dto.PessoaDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pessoa(PessoaDTO obj) {

		this.setNome(obj.getNome());
		this.setIdade(obj.getIdade());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "idade")
	private Integer idade;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contato> contatos = new ArrayList<Contato>();

	public Pessoa adcionarContato(Contato contato) {

		contato.registrarPara(this);
		this.getContatos().add(contato);
		return this;
	}

}
