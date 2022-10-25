package br.com.ApiStage3.model;

import java.util.List;

public class AuxItensVenda {

	private String email;
	private List<ProdutoDTO> produtos;
	private double preco;

	public AuxItensVenda(String email, List<ProdutoDTO> produtos, double preco) {
		super();
		this.email = email;
		this.produtos = produtos;
		this.preco = preco;
	}

	public AuxItensVenda(List<ProdutoDTO> produtos, double preco) {
		super();
		this.produtos = produtos;
		this.preco = preco;
	}

	public AuxItensVenda() {
	}

	public AuxItensVenda(List<ProdutoDTO> produtos) {
		super();
		this.produtos = produtos;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
