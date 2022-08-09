package br.com.ApiStage3.model;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

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
	private List<Produto> produto;
	@ManyToOne
	private Venda venda;
	private int quantidade;
	private BigInteger preco;
	private Boolean excluido;
	private Date data_excluido;

	public Item_venda() {}
	
	
	public Item_venda(List<Produto> produto, int quantidade, BigInteger preco) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}


	public Item_venda(Integer id_item_venda, List<Produto> produto, Venda venda, int quantidade, BigInteger preco,
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
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

	public Item_vendaDTO toDTO() {
		Item_vendaDTO dto = new Item_vendaDTO(produto, venda, quantidade, preco, excluido, data_excluido);
		return dto;
	}

}