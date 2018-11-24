package com.demetrio.cadImoveis.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dados_cadastrais")
public class DadosCadastrais {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="matricula")	
	private Long matricula;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "quadra_id")
	private Quadra quadra;
	
	
	@Column(length = 4)
	private String lote;
	
	@Column(length = 3)
	private String unidade;
	
	@Column(name = "nova_inscricao")
	private String novaInscricao;
	
	@Column(name = "antiga_inscricao")
	private String AntigaInscricao;
	
	@Column(name="cadastrado_em")
	private LocalDate cadastradoEm;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getNovaInscricao() {
		return novaInscricao;
	}

	public void setNovaInscricao(String novaInscricao) {
		this.novaInscricao = novaInscricao;
	}

	public String getAntigaInscricao() {
		return AntigaInscricao;
	}

	public void setAntigaInscricao(String antigaInscricao) {
		AntigaInscricao = antigaInscricao;
	}
	
	public LocalDate getCadastradoEm() {
		return cadastradoEm;
	}

	public void setCadastradoEm(LocalDate cadastradoEm) {
		this.cadastradoEm = cadastradoEm;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosCadastrais other = (DadosCadastrais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
