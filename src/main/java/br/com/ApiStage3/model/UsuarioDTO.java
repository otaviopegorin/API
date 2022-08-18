package br.com.ApiStage3.model;

public class UsuarioDTO {

	private String nome;
	private String email;
	private String telefone;
	private String img_usuario;
	

	public UsuarioDTO(String nome, String email, String telefone, String img_usuario) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.img_usuario = img_usuario;
	}

	public String getImg_usuario() {
		return img_usuario;
	}

	public void setImg_usuario(String img_usuario) {
		this.img_usuario = img_usuario;
	}

	public UsuarioDTO() {}
	
	public UsuarioDTO(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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
