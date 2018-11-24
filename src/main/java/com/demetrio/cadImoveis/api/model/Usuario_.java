package com.demetrio.cadImoveis.api.model;

import com.demetrio.cadImoveis.api.enumeracao.Funcao;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, Funcao> funcao;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, Boolean> ativo;
	public static volatile SingularAttribute<Usuario, Dispositivo> dispositivo;
	public static volatile SingularAttribute<Usuario, LocalDate> contratadoEm;
	public static volatile SingularAttribute<Usuario, String> cpf;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile ListAttribute<Usuario, Cidade> cidades;
	public static volatile SingularAttribute<Usuario, String> sobreNome;
	public static volatile SingularAttribute<Usuario, Contato> contato;

}

