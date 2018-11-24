package com.demetrio.cadImoveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demetrio.cadImoveis.api.model.Dispositivo;

public interface Dispositivos extends JpaRepository<Dispositivo, Long>{

	Dispositivo findDispositivoById(Long id);

	
}
