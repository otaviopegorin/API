package br.com.ApiStage3.model;

import java.util.List;

public class EmpresaDTO {

	private String nome;
	private String cnpj;
	private String contato;
	private List<Estagio> estagios;

	public EmpresaDTO() {
	}

	public EmpresaDTO(String nome, String cnpj, String contato, List<Estagio> estagios) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.contato = contato;
		this.estagios = estagios;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Estagio> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<Estagio> estagios) {
		this.estagios = estagios;
	}

}
