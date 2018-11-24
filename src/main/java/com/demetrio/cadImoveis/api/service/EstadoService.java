package com.demetrio.cadImoveis.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demetrio.cadImoveis.api.model.Estado;
import com.demetrio.cadImoveis.api.repository.Estados;

@Service
public class EstadoService {

	@Autowired
	private Estados estados;
	
	public Estado salvar(Estado estado) {
		Long codigo = estados.findCodigoMax();
		codigo = (Long) codigo != null ? (codigo +=1L) : (codigo = 1L);
		estado.setCodigo(codigo);
		return estados.save(estado);
	}

}
