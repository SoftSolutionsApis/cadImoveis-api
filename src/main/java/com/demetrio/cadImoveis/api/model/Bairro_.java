package com.demetrio.cadImoveis.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bairro.class)
public abstract class Bairro_ {

	public static volatile SingularAttribute<Bairro, Long> codigo;
	public static volatile SingularAttribute<Bairro, Cidade> cidade;
	public static volatile ListAttribute<Bairro, Logradouro> logradouros;
	public static volatile SingularAttribute<Bairro, String> nome;
	public static volatile SingularAttribute<Bairro, Long> id;

}

