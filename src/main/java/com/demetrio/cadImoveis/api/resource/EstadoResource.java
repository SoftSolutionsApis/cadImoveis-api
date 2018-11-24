package com.demetrio.cadImoveis.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demetrio.cadImoveis.api.event.RecursoCriadoEvent;
import com.demetrio.cadImoveis.api.model.Estado;
import com.demetrio.cadImoveis.api.repository.Estados;
import com.demetrio.cadImoveis.api.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private Estados estados;
	
	@Autowired
	private EstadoService estadoService; 
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping("/listar")
	public List<Estado> listar(){
		return estados.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@Valid @RequestBody Estado estado, HttpServletResponse response){
		Estado estadoSalvo = estadoService.salvar(estado);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, estadoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
	}
	
	
}
