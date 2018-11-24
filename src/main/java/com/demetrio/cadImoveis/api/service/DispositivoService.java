package com.demetrio.cadImoveis.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.demetrio.cadImoveis.api.model.Dispositivo;
import com.demetrio.cadImoveis.api.repository.Dispositivos;

@Service
public class DispositivoService {

	@Autowired 
	private Dispositivos dispositivos;

	public void atualizarNumero(Long id, String numero) {
		Dispositivo dispositivoSalvo = dispositivos.findDispositivoById(id);
		if (dispositivoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		dispositivoSalvo.setNumero(numero);
		dispositivos.save(dispositivoSalvo);
		
	}

	public Dispositivo atualizar(Long id, Dispositivo dispositivo) {
		Dispositivo dispositivoSalvo = dispositivos.findDispositivoById(id);
		BeanUtils.copyProperties(dispositivo, dispositivoSalvo, "id");
		return dispositivos.save(dispositivoSalvo);
	}

	public void atualizarDisponibilidade(Long id, Boolean disponivel) {
		Dispositivo dispositivoSalvo = buscarPorId(id);
		dispositivoSalvo.setDisponivel(disponivel);
		dispositivos.save(dispositivoSalvo);
		
	}

	public Dispositivo buscarPorId(Long id) {
		Dispositivo dispositivo = dispositivos.findDispositivoById(id);
		if (dispositivo == null) {
			new EmptyResultDataAccessException(1);
		}
		return dispositivo;
	}
	
	
}
