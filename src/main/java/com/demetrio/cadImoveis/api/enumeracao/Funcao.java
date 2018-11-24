package com.demetrio.cadImoveis.api.enumeracao;

public enum Funcao {
		
	ADMINISTRADOR("ADMINISTRADOR"),
	ATENDENTE("ATENDENTE"),
	CADASTRADOR("CADASTRADOR"),
	DESENVOLVEDOR("DESENVOLVEDOR"),
	DIGITADOR("DIGITADOR"),
	DIRETOR("DIRETOR"),
	GERENTE("GERENTE");
	
	private String descricao;
	
	private Funcao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
