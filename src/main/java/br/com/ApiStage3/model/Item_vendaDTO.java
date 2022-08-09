package br.com.ApiStage3.model;

import java.math.BigInteger;
import java.sql.Date;

public class Item_vendaDTO {

	private Produto produto;
	private Venda venda;
	private int quantidade;
	private BigInteger preco;
	private Boolean excluido;
	private Date data_excluido;

	public Item_vendaDTO(Produto produto, Venda venda, int quantidade, BigInteger preco, Boolean excluido,
			Date data_excluido) {
		super();
		this.produto = produto;
		this.venda = venda;
		this.quantidade = quantidade;
		this.preco = preco;
		this.excluido = excluido;
		this.data_excluido = data_excluido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigInteger getPreco() {
		return preco;
	}

	public void setPreco(BigInteger preco) {
		this.preco = preco;
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

}