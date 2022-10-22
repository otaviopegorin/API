package br.com.ApiStage3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_produto;
	@Column(unique = true)
	private String nome;
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<Item_venda> itens;
	private double preco;
	private String categoria;
	private String descricao;
	private int qtd_estoque;
	private Boolean excluido = false;
	private String data_excluido = "";
	private String img_produto;
	private int quantidade = 0;
	
	public Produto() {
	}
	
	public Produto(String nome, double preco, String categoria, String descricao, int qtd_estoque, String img_produto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.qtd_estoque = qtd_estoque;
		this.img_produto = img_produto;
	}

	public Produto(Integer id_produto, String nome, double preco, String categoria, String descricao,
			int qtd_estoque, Boolean excluido, String data_excluido, String img_produto) {
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
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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

	public String getData_excluido() {
		return data_excluido;
	}

	public void setData_excluido(String data_excluido) {
		this.data_excluido = data_excluido;
	}

	public String getImg_produto() {
		return img_produto;
	}

	public void setImg_produto(String img_produto) {
		this.img_produto = img_produto;
	}

	public ProdutoDTO toDTO() {
		ProdutoDTO dto = new ProdutoDTO(id_produto, nome, preco, categoria, descricao, qtd_estoque, excluido, data_excluido, img_produto);
		return dto;
	}
}
