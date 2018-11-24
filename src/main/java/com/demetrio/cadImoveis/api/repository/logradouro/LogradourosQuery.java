package com.demetrio.cadImoveis.api.repository.logradouro;

import java.util.List;

import com.demetrio.cadImoveis.api.model.Logradouro;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;

public interface LogradourosQuery {

	List<Logradouro> pesquisar(CidadeBairroLogradouroFilter filtro);
}
