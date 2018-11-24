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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demetrio.cadImoveis.api.event.RecursoCriadoEvent;
import com.demetrio.cadImoveis.api.model.Bairro;
import com.demetrio.cadImoveis.api.repository.Bairros;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;
import com.demetrio.cadImoveis.api.service.BairroService;

@RestController
@RequestMapping("/bairros")
public class BairroResource {
	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private BairroService bairroService;
	
	@GetMapping("/listar")
	public List<Bairro> listar() {
		return bairros.findAll();
	}
	
	@GetMapping
	public List<Bairro> pesquisar(CidadeBairroLogradouroFilter filtro) {
		return bairros.pesquisar(filtro);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Bairro bairro, HttpServletResponse response) {
		Bairro bairroSalvo = bairroService.salvar(bairro);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, bairroSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroSalvo);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Bairro bairro, HttpServletResponse response) {
		Bairro bairroSalvo = bairroService.atualizar(id, bairro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroSalvo); 
	}
	
	@PutMapping
	public ResponseEntity<?> addLogradouro(@Valid @RequestBody Bairro bairro, HttpServletResponse response) {
		Bairro bairroSalvo = bairroService.addLogradouro(bairro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bairroSalvo); 
	}
	
	@PutMapping("/{id}/logradouro/{idL}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerLogradouro(@PathVariable Long id, @PathVariable Long idL) {
		
		bairroService.removerLogradouro(id, idL);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Bairro bairroSalvo = bairros.findBairroById(id);
		
		return bairroSalvo != null ? ResponseEntity.ok(bairroSalvo) : ResponseEntity.notFound().build();
	}
	
	
	
}

