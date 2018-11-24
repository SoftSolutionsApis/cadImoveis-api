package com.demetrio.cadImoveis.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demetrio.cadImoveis.api.model.Bairro;
import com.demetrio.cadImoveis.api.model.Logradouro;
import com.demetrio.cadImoveis.api.repository.Bairros;
import com.demetrio.cadImoveis.api.repository.Logradouros;

@Service
public class BairroService {

	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private Logradouros logradouros;
	
	public Bairro atualizar(Long id, Bairro bairro) {
		Bairro bairroSalvo = bairros.findBairroById(id);
		BeanUtils.copyProperties(bairroSalvo, bairro, "id");
		return bairros.save(bairroSalvo);
	}

	public Bairro addLogradouro(Bairro bairro) {
		return bairros.save(bairro);
	}

	public void removerLogradouro(Long idB, Long idL) {
		Bairro bairro = bairros.findBairroById(idB);
		Logradouro logradouro = logradouros.findLogradouroById(idL);
		bairro.getLogradouros().remove(logradouro);
		bairros.save(bairro);
	}

	public Bairro salvar(Bairro bairro) {
		Long codigo = bairros.findBairroPorCidadeIdValorMaxDoCodigo(bairro.getCidade().getId());
		codigo = (Long) codigo != null ? (codigo +=1L) : (codigo = 1L);
		
		bairro.setCodigo(codigo);
		return bairros.save(bairro);
	}
}
