package br.com.ApiStage3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "PEGORIN_Usuario")
public class Usuario {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name ="increment",strategy="increment")
	private Integer id_usuario;
	@OneToMany(mappedBy = "usuario")
	private List<Estagio> estagios;
	private String nome;
	@Column(unique = true)
	private String email;
	private String senha;
	private String telefone;
	private Boolean recuperarSenha;
	private Boolean adm;


	public Usuario() {
	}

	public Usuario(List<Estagio> estagios, String nome, String email, String senha, String telefone, Boolean adm, Boolean recuperarSenha) {
		super();
		this.estagios = estagios;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.adm = adm;
		this.recuperarSenha = recuperarSenha;
	}
	
	public Usuario(String nome, String email, String senha,Boolean recuperarsenha, Boolean adm) {
		this.nome = nome;
		this.email= email;
		this.senha=senha;
		this.recuperarSenha = recuperarsenha;
		this.adm = adm;
	}
	
	public Boolean getRecuperarSenha() {
		return recuperarSenha;
	}

	public void setRecuperarSenha(Boolean recuperarSenha) {
		this.recuperarSenha = recuperarSenha;
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(String email) {
		this.email = email;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<Estagio> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<Estagio> estagios) {
		this.estagios = estagios;
	}


	public Integer getId() {
		return id_usuario;
	}

	public void setId(Integer id) {
		this.id_usuario = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAdm() {
		return adm;
	}

	public void setAdm(Boolean adm) {
		this.adm = adm;
	}

	public UsuarioDTO toUsuarioDTO() {
		UsuarioDTO usuarioDTO = new UsuarioDTO(this.getNome(), this.getEmail(), this.getTelefone(),this.getEstagios());
		return usuarioDTO;
	}

}
