package com.demetrio.cadImoveis.api.repository.cidade;

import java.util.List;

import com.demetrio.cadImoveis.api.model.Cidade;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;

public interface CidadesQuery {

	List<Cidade> filtrar(CidadeBairroLogradouroFilter filtro);
}
