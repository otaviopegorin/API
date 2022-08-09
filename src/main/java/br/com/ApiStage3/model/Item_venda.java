package br.com.ApiStage3.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Item_venda")
public class Item_venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_item_venda;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Venda venda;
	private int quantidade;
	private double preco;
	private Boolean excluido = false;
	private String data_excluido = "";

	public Item_venda() {}
	
	
	public Item_venda(Produto produto, int quantidade, double preco) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}


	public Item_venda(Integer id_item_venda, Produto produto, Venda venda, int quantidade, double preco,
			Boolean excluido, Date data_excluido) {
		super();
		this.id_item_venda = id_item_venda;
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


	public Integer getId_item_venda() {
		return id_item_venda;
	}

	public void setId_item_venda(Integer id_item_venda) {
		this.id_item_venda = id_item_venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
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

	public Item_vendaDTO toDTO() {
		Item_vendaDTO dto = new Item_vendaDTO(produto, venda, quantidade, preco, excluido, data_excluido);
		return dto;
	}

}