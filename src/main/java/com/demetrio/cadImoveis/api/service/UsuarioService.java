package com.demetrio.cadImoveis.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.demetrio.cadImoveis.api.model.Dispositivo;
import com.demetrio.cadImoveis.api.model.Usuario;
import com.demetrio.cadImoveis.api.repository.Usuarios;

@Service
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	
	
	@Autowired
	private DispositivoService dispositivoService;
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario usuarioSalvo = buscarUsuarioPeloId(id);
		
		BeanUtils.copyProperties(usuario, usuarioSalvo, "id");
		return usuarios.save(usuarioSalvo);
	}

	

	public void atualizarPropriedade(Long id, Boolean ativo) {
		Usuario usuarioSalvo = buscarUsuarioPeloId(id);
		usuarioSalvo.setAtivo(ativo);
		usuarios.save(usuarioSalvo);
		
	}
	
	private Usuario buscarUsuarioPeloId(Long id) {
		Usuario usuarioSalvo = usuarios.findUsuarioById(id);
		if (usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioSalvo;
	}



	public Usuario atualizarDispositivo(Long id, Usuario usuario) {
		Dispositivo dispositivoSalvo = dispositivoService.buscarPorId(usuario.getDispositivo().getId()); 
		Usuario usuarioSalvo = buscarUsuarioPeloId(id);
		usuarioSalvo.setDispositivo(dispositivoSalvo);
		return usuarios.save(usuarioSalvo);
	}



	


	
}
