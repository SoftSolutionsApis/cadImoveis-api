package com.demetrio.cadImoveis.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demetrio.cadImoveis.api.event.RecursoCriadoEvent;
import com.demetrio.cadImoveis.api.exceptionhandle.CadImoveisExceptionHandle.Erro;
import com.demetrio.cadImoveis.api.model.Dispositivo;
import com.demetrio.cadImoveis.api.model.Usuario;
import com.demetrio.cadImoveis.api.repository.Dispositivos;
import com.demetrio.cadImoveis.api.repository.Usuarios;
import com.demetrio.cadImoveis.api.repository.filter.UsuarioFilter;
import com.demetrio.cadImoveis.api.service.DispositivoService;
import com.demetrio.cadImoveis.api.service.UsuarioService;
import com.demetrio.cadImoveis.api.service.exception.DispositivoInexistenteOuIndisponivelException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired 
	private UsuarioService service;
	
	@Autowired
	private Dispositivos dispositivos;
	
	@Autowired
	private DispositivoService dispositivoService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/listar")
	public List<Usuario> listar() {
		return usuarios.findAll();
	}
	
	@GetMapping
	public List<Usuario> pesquisar(UsuarioFilter filtro) {
		return usuarios.pesquisar(filtro);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		
		Dispositivo dispositivo = dispositivos.findDispositivoById(usuario.getDispositivo().getId());
		
		if (dispositivo == null || dispositivo.isIndisponivel()) {
			throw new DispositivoInexistenteOuIndisponivelException();
		}
		dispositivoService.atualizarDisponibilidade(dispositivo.getId(), false);
		
		Usuario usuarioSalvo = usuarios.save(usuario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = service.atualizar(id, usuario);
		
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Boolean ativo) {
		service.atualizarPropriedade(id, ativo);
	}
	
	@PutMapping("/{id}/dispositivo")
	public ResponseEntity<Usuario> atualizarDispositivo(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = service.atualizarDispositivo(id, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Usuario usuarioEncontrado = usuarios.findUsuarioById(id);
		
		return usuarioEncontrado != null ? ResponseEntity.ok(usuarioEncontrado) : ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		usuarios.deleteById(id);
	}
	
	@ExceptionHandler( {DispositivoInexistenteOuIndisponivelException.class} )
	public ResponseEntity<Object> handleDispositivoInexistenteOuIndisponivelException(DispositivoInexistenteOuIndisponivelException ex) {
		
		String mensagemUsuario = messageSource.getMessage("dispositivo.inexistente-ou-insdisponivel", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
	
}
