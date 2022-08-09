package br.com.ApiStage3.model;

import java.util.List;

public class AuxVendaDTO {

	private String email;
	private Double preco;
	private List<ProdutoDTO> produtos;
	
	public AuxVendaDTO() {}
	
	public AuxVendaDTO(String email, Double preco, List<ProdutoDTO> produtos) {
		super();
		this.email = email;
		this.preco = preco;
		this.produtos = produtos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	
}
