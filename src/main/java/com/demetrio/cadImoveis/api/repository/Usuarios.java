package com.demetrio.cadImoveis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demetrio.cadImoveis.api.model.Usuario;
import com.demetrio.cadImoveis.api.repository.usuario.UsuariosQuery;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQuery{

	Usuario findUsuarioById(Long id);

	
}
