package com.demetrio.cadImoveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demetrio.cadImoveis.api.model.Logradouro;
import com.demetrio.cadImoveis.api.repository.logradouro.LogradourosQuery;

public interface Logradouros extends JpaRepository<Logradouro, Long>, LogradourosQuery{

	Logradouro findLogradouroById(Long id);
	
	@Query(value = "select max(codigo) from logradouro where cidade_id = :cidade_id", nativeQuery = true)
	Long findLogradouroByCidade(@Param("cidade_id") Long cidade_id);
}
