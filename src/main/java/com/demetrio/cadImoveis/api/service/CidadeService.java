package com.demetrio.cadImoveis.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demetrio.cadImoveis.api.model.Cidade;
import com.demetrio.cadImoveis.api.repository.Cidades;

@Service
public class CidadeService {

	
	
	@Autowired
	private Cidades cidades;
	
	

	public Cidade salvar(Cidade cidade) {
		Long codigo = cidades.findCidadeCodigoMaxDoEstado(cidade.getEstado().getId());
		codigo = (Long) codigo != null ? (codigo +=1L) : (codigo = 1L);
		cidade.setCodigo(codigo);
		return cidades.save(cidade);
	}
	
	
}
