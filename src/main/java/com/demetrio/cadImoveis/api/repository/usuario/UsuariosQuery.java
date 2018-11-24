package com.demetrio.cadImoveis.api.repository.usuario;

import java.util.List;

import com.demetrio.cadImoveis.api.model.Usuario;
import com.demetrio.cadImoveis.api.repository.filter.UsuarioFilter;

public interface UsuariosQuery {
	
	List<Usuario> pesquisar(UsuarioFilter filtro);
}
