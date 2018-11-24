package com.demetrio.cadImoveis.api.resource;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demetrio.cadImoveis.api.event.RecursoCriadoEvent;
import com.demetrio.cadImoveis.api.model.Dispositivo;
import com.demetrio.cadImoveis.api.repository.Dispositivos;
import com.demetrio.cadImoveis.api.service.DispositivoService;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoResource {

	@Autowired
	private Dispositivos repositorio;
	
	@Autowired
	private DispositivoService service;
	
	@Autowired ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Dispositivo> salvar(@Valid @RequestBody Dispositivo dispositivo, HttpServletResponse response) {
		Dispositivo dispositivoSalvo = repositorio.save(dispositivo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, dispositivoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoSalvo);
	}
	
	@GetMapping("/listar")
	public List<Dispositivo> listar() {
		return  repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dispositivo> buscarPorId(@PathVariable Long id) {
		Dispositivo dispositivoSalvo = repositorio.findDispositivoById(id);
		
		return dispositivoSalvo != null ? ResponseEntity.ok(dispositivoSalvo) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}/numero")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeNumero(@PathVariable Long id, @RequestBody String numero) {
		service.atualizarNumero(id, numero);
	}
	
	@PutMapping("/{id}/disponivel")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeDisponivel(@PathVariable Long id, @RequestBody Boolean disponivel) {
		service.atualizarDisponibilidade(id, disponivel);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Dispositivo> atualizar(@PathVariable Long id, @Valid @RequestBody Dispositivo dispositivo, HttpServletResponse response) {
		Dispositivo dispositivoSalvo = service.atualizar(id, dispositivo);
		return ResponseEntity.ok(dispositivoSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		repositorio.deleteById(id);
	}
}
