package br.com.ApiStage3.model;

public class AuxItemVendaDto {

	private int quantidade;
	private String nomeProduto;
	
	public AuxItemVendaDto() {}

	public AuxItemVendaDto(int quantidade, String nomeProduto) {
		super();
		this.quantidade = quantidade;
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

}
