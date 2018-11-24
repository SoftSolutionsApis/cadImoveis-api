package com.demetrio.cadImoveis.api.repository.bairro;

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

import com.demetrio.cadImoveis.api.model.Bairro;
import com.demetrio.cadImoveis.api.model.Bairro_;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;

public class BairrosImpl implements BairrosQuery{
	
	@PersistenceContext 
	private EntityManager manager;

	@Override
	public List<Bairro> pesquisar(CidadeBairroLogradouroFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Bairro> criteria = builder.createQuery(Bairro.class);
		Root<Bairro> root = criteria.from(Bairro.class);
		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Bairro> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(CidadeBairroLogradouroFilter filtro, CriteriaBuilder builder,
			Root<Bairro> root) {

		List<Predicate> predicates = new ArrayList<>();
		if (filtro.getCodigo() != null) {
			predicates.add(builder.equal(
					root.get(Bairro_.codigo), 
					filtro.getCodigo()));
		}
		if (!StringUtils.isEmpty(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(
					root.get(Bairro_.nome)), 
					"%"+ filtro.getNome().toLowerCase() +"%"));
		}
		if (filtro.getFkCidade() != null) {
			predicates.add(builder.equal(
					root.get(Bairro_.cidade), 
					filtro.getFkCidade()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
