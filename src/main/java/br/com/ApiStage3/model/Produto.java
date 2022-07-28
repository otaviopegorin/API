package br.com.ApiStage3.model;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_produto;
	@Column(unique = true)
	private String nome;
	private BigInteger preco;
	@Enumerated(EnumType.STRING)
	private CategoriaProduto categoria;
	private String descricao;
	private int qtd_estoque;
	private Boolean excluido;
	private Date data_excluido;
	private String img_produto;

	public Produto() {
	}
	public Produto(Integer id_produto, String nome, BigInteger preco, CategoriaProduto categoria, String descricao,
			int qtd_estoque, Boolean excluido, Date data_excluido, String img_produto) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.qtd_estoque = qtd_estoque;
		this.excluido = excluido;
		this.data_excluido = data_excluido;
		this.img_produto = img_produto;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getPreco() {
		return preco;
	}

	public void setPreco(BigInteger preco) {
		this.preco = preco;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

	public Date getData_excluido() {
		return data_excluido;
	}

	public void setData_excluido(Date data_excluido) {
		this.data_excluido = data_excluido;
	}

	public String getImg_produto() {
		return img_produto;
	}

	public void setImg_produto(String img_produto) {
		this.img_produto = img_produto;
	}

	public ProdutoDTO toDTO() {
		ProdutoDTO dto = new ProdutoDTO(nome, preco, categoria, descricao, qtd_estoque, excluido, data_excluido, img_produto);
		return dto;
	}
}
