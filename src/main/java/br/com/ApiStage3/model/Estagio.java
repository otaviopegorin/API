package br.com.ApiStage3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "PEGORIN_Estagio")
public class Estagio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name ="increment",strategy="increment")
	private Integer id_estagio;
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	@OneToMany(mappedBy = "id_estagio")
	private List<Relatorio> relatorios;
	
	private String atividades;
	private String requisitos;
	private String coordenador;

	@Enumerated(EnumType.STRING)
	private StatusEstagio statusEstagio;

	public Estagio(Empresa empresa, Usuario usuario, List<Relatorio> relatorios, String atividades,
			String requisitos, String coordenador, StatusEstagio statusEstagio) {
		super();
		this.empresa = empresa;
		this.usuario = usuario;
		this.relatorios = relatorios;
		this.atividades = atividades;
		this.requisitos = requisitos;
		this.coordenador = coordenador;
		this.statusEstagio = statusEstagio;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}
	
	public StatusEstagio getStatusEstagio() {
		return statusEstagio;
	}

	public void setStatusEstagio(StatusEstagio statusEstagio) {
		this.statusEstagio = statusEstagio;
	}
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Integer getId_estagio() {
		return id_estagio;
	}

	public void setId_estagio(Integer id_estagio) {
		this.id_estagio = id_estagio;
	}

	public Estagio() {
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}


	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}


	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public EstagioDTO toEstagioDTO() {
		EstagioDTO estagio = new EstagioDTO(this.empresa.getNome(),this.usuario.getNome(),this.atividades,this.requisitos,this.coordenador,this.statusEstagio);
		return estagio;
	}
}
