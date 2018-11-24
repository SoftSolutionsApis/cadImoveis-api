package com.demetrio.cadImoveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demetrio.cadImoveis.api.model.Bairro;
import com.demetrio.cadImoveis.api.repository.bairro.BairrosQuery;

public interface Bairros extends JpaRepository<Bairro, Long>, BairrosQuery{

	Bairro findBairroById(Long id);

	@Query(value = "select max(codigo) from bairro where cidade_id = :cidade_id", nativeQuery = true)
	Long findBairroPorCidadeIdValorMaxDoCodigo(@Param("cidade_id") Long cidade_id);
}
