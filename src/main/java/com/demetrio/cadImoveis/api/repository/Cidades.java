package com.demetrio.cadImoveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demetrio.cadImoveis.api.model.Cidade;
import com.demetrio.cadImoveis.api.repository.cidade.CidadesQuery;

public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQuery{

	Cidade findCidadeById(Long id);

	@Query(value = "select max(codigo) from cidade where uf_id = :uf_id", nativeQuery = true)
	Long findCidadeCodigoMaxDoEstado(@Param("uf_id") Long uf_id);

	

	

}
