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
import com.demetrio.cadImoveis.api.model.Logradouro;
import com.demetrio.cadImoveis.api.repository.Logradouros;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;
import com.demetrio.cadImoveis.api.service.LogradouroSevice;

@RestController
@RequestMapping("/logradouros")
public class LogradouroResource {

	@Autowired
	private Logradouros logradouros;
	
	@Autowired
	private LogradouroSevice logradouroService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/listar")
	public List<Logradouro> listar(){
		return logradouros.findAll();
	}
	
	@GetMapping
	public List<Logradouro> pesquisar(CidadeBairroLogradouroFilter filtro){
		return logradouros.pesquisar(filtro);
	}
	
	
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Logradouro logradouro, HttpServletResponse response) {
			Logradouro logradouroSalvo = logradouroService.salvar(logradouro);
			publisher.publishEvent(new RecursoCriadoEvent(this, response, logradouroSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(logradouroSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Logradouro logradouro = logradouros.findLogradouroById(id);
		return logradouro != null ? ResponseEntity.ok(logradouro) : ResponseEntity.notFound().build();
	}
	
	
}
