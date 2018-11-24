package com.demetrio.cadImoveis.api.repository.logradouro;

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

import com.demetrio.cadImoveis.api.model.Logradouro;
import com.demetrio.cadImoveis.api.model.Logradouro_;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;

public class LogradourosImpl implements LogradourosQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Logradouro> pesquisar(CidadeBairroLogradouroFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Logradouro> criteria = builder.createQuery(Logradouro.class);
		Root<Logradouro> root = criteria.from(Logradouro.class);
		
		Predicate[] predicates = criarRestrincoes(filtro, builder, root);
		criteria.where(predicates);
		TypedQuery<Logradouro> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestrincoes(CidadeBairroLogradouroFilter filtro, CriteriaBuilder builder,
			Root<Logradouro> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (filtro.getCodigo() != null) {
			predicates.add(builder.equal(
					root.get(Logradouro_.codigo), 
					filtro.getCodigo()));
		}
		if (!StringUtils.isEmpty(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(
					root.get(Logradouro_.nome)), 
					"%"+ filtro.getNome().toLowerCase() +"%"));
		}
		if (filtro.getFkCidade() != null) {
			predicates.add(builder.equal(
					root.get(Logradouro_.cidade), 
					filtro.getFkCidade()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
