package com.demetrio.cadImoveis.api.repository.cidade;

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

import com.demetrio.cadImoveis.api.model.Cidade;
import com.demetrio.cadImoveis.api.model.Cidade_;
import com.demetrio.cadImoveis.api.repository.filter.CidadeBairroLogradouroFilter;

public class CidadesImpl implements CidadesQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cidade> filtrar(CidadeBairroLogradouroFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cidade> criteria = builder.createQuery(Cidade.class);
		Root<Cidade> root = criteria.from(Cidade.class);

		Predicate[] predicates = criarRestricoes(filtro, builder, root);
		criteria.where(predicates);

		TypedQuery<Cidade> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(CidadeBairroLogradouroFilter filtro, CriteriaBuilder builder,
			Root<Cidade> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		if (filtro.getCodigo() != null) {
			predicates.add(builder.equal(
					root.get(Cidade_.codigo), 
					filtro.getCodigo()));
		}
		if (!StringUtils.isEmpty(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(
					root.get(Cidade_.nome)), 
					"%"+ filtro.getNome().toLowerCase() +"%"));
		}
		if (filtro.getFkEstado() != null) {
			predicates.add(builder.equal(
					root.get(Cidade_.estado), 
					filtro.getFkEstado()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
