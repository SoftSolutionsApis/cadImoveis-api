package com.demetrio.cadImoveis.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demetrio.cadImoveis.api.event.RecursoCriadoEvent;
import com.demetrio.cadImoveis.api.model.Cidade;
import com.demetrio.cadImoveis.api.repository.Cidades;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;
import com.demetrio.cadImoveis.api.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	@Autowired
	private Cidades cidades;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/listar")
	public List<Cidade> listar(){
		return cidades.findAll();
	}
	
	
	@GetMapping
	public List<Cidade> pesquisar(CidadeBairroLogradouroFilter filtro){
		return cidades.filtrar(filtro);
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade cidadeSalva = cidadeService.salvar(cidade);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cidade.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Cidade cidade = cidades.findCidadeById(id);
		return cidade != null ? ResponseEntity.ok(cidade) : ResponseEntity.notFound().build();
	}

}
