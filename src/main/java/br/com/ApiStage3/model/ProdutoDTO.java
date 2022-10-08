package br.com.ApiStage3.model;

public class ProdutoDTO {

	private Integer id;
	private String nome;
	private Double preco;
	private String categoria;
	private String descricao;
	private int qtd_estoque;
	private int quantidade = 0;
	private Boolean excluido;
	private String data_excluido;
	private String img_produto;

	public ProdutoDTO(Integer id, String nome, double preco, String categoria, String descricao, int qtd_estoque,
			Boolean excluido, String data_excluido, String img_produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.qtd_estoque = qtd_estoque;
		this.excluido = excluido;
		this.data_excluido = data_excluido;
		this.img_produto = img_produto;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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

}
