package com.demetrio.cadImoveis.api.repository.filter;

public class CidadeBairroLogradouroFilter {

	private Long codigo;
	private String nome;
	private Long fkEstado;
	private Long fkCidade;
	private Long fkBairro;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getFkEstado() {
		return fkEstado;
	}
	public void setFkEstado(Long fkEstado) {
		this.fkEstado = fkEstado;
	}
	public Long getFkCidade() {
		return fkCidade;
	}
	public void setFkCidade(Long fkCidade) {
		this.fkCidade = fkCidade;
	}
	public Long getFkBairro() {
		return fkBairro;
	}
	public void setFkBairro(Long fkBairro) {
		this.fkBairro = fkBairro;
	}
	
	
}
