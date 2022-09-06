package br.com.ApiStage3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_usuario;
	private String nome;
	@Column(unique = true)
	private String email;
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Venda> pedidos;
	private String senha;
	@Column(unique = true)
	private String telefone;
	private Boolean recuperarSenha;
	private Boolean adm;
	private String img_usuario;
	private boolean notificacao = true;

	public Usuario(Integer id_usuario, String nome, String email, List<Venda> pedidos, String senha, String telefone,
			Boolean recuperarSenha, Boolean adm, String img_usuario, boolean notificacao) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.pedidos = pedidos;
		this.senha = senha;
		this.telefone = telefone;
		this.recuperarSenha = recuperarSenha;
		this.adm = adm;
		this.img_usuario = img_usuario;
		this.notificacao = notificacao;
	}

	public Usuario() {
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String nome, String email, String senha, String telefone, Boolean adm, Boolean recuperarSenha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.adm = adm;
		this.recuperarSenha = recuperarSenha;
	}

	public Usuario(String nome, String email, String senha, Boolean recuperarsenha, Boolean adm) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.recuperarSenha = recuperarsenha;
		this.adm = adm;
	}
	
	public Usuario(String email,boolean notificacao) {
		this.email = email;
		this.notificacao = notificacao;
	}

	public List<Venda> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Venda> pedidos) {
		this.pedidos = pedidos;
	}

	public String getImg_usuario() {
		return img_usuario;
	}

	public void setImg_usuario(String img_usuario) {
		this.img_usuario = img_usuario;
	}

	public boolean getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(boolean notificacao) {
		this.notificacao = notificacao;
	}

	public Boolean getRecuperarSenha() {
		return recuperarSenha;
	}

	public void setRecuperarSenha(Boolean recuperarSenha) {
		this.recuperarSenha = recuperarSenha;
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
		UsuarioDTO usuarioDTO = new UsuarioDTO(this.getNome(), this.getEmail(), this.getTelefone(),
				this.getImg_usuario(), this.getNotificacao());
		return usuarioDTO;
	}

}
