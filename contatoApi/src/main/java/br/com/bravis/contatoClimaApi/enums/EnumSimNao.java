package br.com.bravis.contatoClimaApi.enums;

public enum EnumSimNao {

	N("Não"), S("Sim");

	private String descricao;

	private EnumSimNao(String descricao) {

		this.descricao = descricao;
	}

	public String getDescricao() {

		return this.descricao;
	}

	public boolean isSim() {

		return this.equals(S);
	}

}
