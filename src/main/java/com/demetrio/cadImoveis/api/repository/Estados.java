package com.demetrio.cadImoveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demetrio.cadImoveis.api.model.Estado;

public interface Estados extends JpaRepository<Estado, Long>{

	@Query(value = "select max(codigo) from estado", nativeQuery = true)
	Long findCodigoMax();

}
