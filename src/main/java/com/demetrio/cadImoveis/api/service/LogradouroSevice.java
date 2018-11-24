package com.demetrio.cadImoveis.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demetrio.cadImoveis.api.model.Logradouro;
import com.demetrio.cadImoveis.api.repository.Logradouros;

@Service
public class LogradouroSevice {
	
	
	@Autowired
	private Logradouros logradouros;
	
	public Logradouro salvar(Logradouro logradouro) {
		Long codigo = logradouros.findLogradouroByCidade(logradouro.getCidade().getId());
		codigo = (Long) codigo != null ? (codigo +=1L) : (codigo = 1L);
		logradouro.setCodigo(codigo);
		return logradouros.save(logradouro);
		
	}

}
