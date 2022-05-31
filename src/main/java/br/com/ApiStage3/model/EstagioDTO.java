package br.com.ApiStage3.model;

import java.util.List;

public class EstagioDTO {
	
	private String nomeEmpresa;
	private String nomeUsuario;
	private String atividades;
	private String requisitos;
	private String coordenador;
	private StatusEstagio status;
	private List<Relatorio> relatorios;
	
	
	
	public EstagioDTO(String nomeEmpresa, String nomeUsuario, String atividades, String requisitos, String coordenador,
			StatusEstagio status) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.nomeUsuario = nomeUsuario;
		this.atividades = atividades;
		this.requisitos = requisitos;
		this.coordenador = coordenador;
		this.status = status;
	}
	
	public StatusEstagio getStatus() {
		return status;
	}

	public void setStatus(StatusEstagio status) {
		this.status = status;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	public EstagioDTO() {}
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

}
