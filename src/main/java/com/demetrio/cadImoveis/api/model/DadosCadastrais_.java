package com.demetrio.cadImoveis.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DadosCadastrais.class)
public abstract class DadosCadastrais_ {

	public static volatile SingularAttribute<DadosCadastrais, Distrito> distrito;
	public static volatile SingularAttribute<DadosCadastrais, Setor> setor;
	public static volatile SingularAttribute<DadosCadastrais, String> novaInscricao;
	public static volatile SingularAttribute<DadosCadastrais, String> lote;
	public static volatile SingularAttribute<DadosCadastrais, String> AntigaInscricao;
	public static volatile SingularAttribute<DadosCadastrais, Quadra> quadra;
	public static volatile SingularAttribute<DadosCadastrais, Long> matricula;
	public static volatile SingularAttribute<DadosCadastrais, String> unidade;
	public static volatile SingularAttribute<DadosCadastrais, Usuario> usuario;
	public static volatile SingularAttribute<DadosCadastrais, Long> id;
	public static volatile SingularAttribute<DadosCadastrais, LocalDate> cadastradoEm;

}

