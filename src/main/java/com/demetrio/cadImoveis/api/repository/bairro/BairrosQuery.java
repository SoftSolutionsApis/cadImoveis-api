package com.demetrio.cadImoveis.api.repository.bairro;

import java.util.List;

import com.demetrio.cadImoveis.api.model.Bairro;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;

public interface BairrosQuery {
	List<Bairro> pesquisar(CidadeBairroLogradouroFilter filtro);
}
