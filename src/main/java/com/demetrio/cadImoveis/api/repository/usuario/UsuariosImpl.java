package com.demetrio.cadImoveis.api.repository.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.demetrio.cadImoveis.api.model.Usuario;
import com.demetrio.cadImoveis.api.model.Usuario_;
import com.demetrio.cadImoveis.api.repository.filter.UsuarioFilter;

public class UsuariosImpl implements UsuariosQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Usuario> pesquisar(UsuarioFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);

		Predicate[] predicates = criarRestrincoes(filtro, builder, root);
		criteria.where(predicates);
		TypedQuery<Usuario> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestrincoes(UsuarioFilter filtro, CriteriaBuilder builder, Root<Usuario> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filtro.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Usuario_.nome)), 
					filtro.getNome()));
		}
		if (!StringUtils.isEmpty(filtro.getSobreNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Usuario_.sobreNome)), 
					filtro.getSobreNome()));
		}
		if (!StringUtils.isEmpty(filtro.getCpf())) {
			predicates.add(builder.like(
					builder.lower(root.get(Usuario_.cpf)), 
					filtro.getCpf()));
		}
		
		if (filtro.getContratadoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(
					root.get(Usuario_.contratadoEm), filtro.getContratadoDe()));
		}
		
		if (filtro.getContratadoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(
					root.get(Usuario_.contratadoEm), filtro.getContratadoAte()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
