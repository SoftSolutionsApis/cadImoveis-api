package com.demetrio.cadImoveis.api.repository.filter;

import java.time.LocalDate;

public class UsuarioFilter {

	private String nome;
	private String sobreNome;
	
	private LocalDate contratadoDe;
	private LocalDate contratadoAte;
	private String cpf;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getContratadoDe() {
		return contratadoDe;
	}
	public void setContratadoDe(LocalDate contratadoDe) {
		this.contratadoDe = contratadoDe;
	}
	public LocalDate getContratadoAte() {
		return contratadoAte;
	}
	public void setContratadoAte(LocalDate contratadoAte) {
		this.contratadoAte = contratadoAte;
	}
	
	
	
	
}
