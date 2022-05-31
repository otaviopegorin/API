package br.com.ApiStage3.model;

import java.util.List;

public class UsuarioDTO {

	private String nome;
	private String email;
	private String telefone;
	private List<Estagio> estagios;
	

	public UsuarioDTO() {}
	
	public UsuarioDTO(String nome, String email, String telefone, List<Estagio> estagio) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.estagios = estagio;
}
	
	public List<Estagio> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<Estagio> estagios) {
		this.estagios = estagios;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
