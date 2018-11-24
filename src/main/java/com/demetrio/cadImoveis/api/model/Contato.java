package com.demetrio.cadImoveis.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;



@Embeddable
public class Contato {
	@Email
	@Column(name="email", length = 40)
	private String email;
	
	@Column(name="fone")
	private String fone;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	
	
}
