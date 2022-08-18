package br.com.ApiStage3.model;

import java.time.LocalDateTime;

public class VendaDTO {

	private LocalDateTime data_venda;
	private double preco;
	private Boolean excluido;
	private LocalDateTime dataExcluido;

	public VendaDTO(LocalDateTime data_venda, double preco, boolean excluido, LocalDateTime dataExcluido) {
		super();
		this.data_venda = data_venda;
		this.preco = preco;
		this.excluido = excluido;
		this.dataExcluido = dataExcluido;
	}

	public LocalDateTime getData_venda() {
		return data_venda;
	}

	public void setData_venda(LocalDateTime data_venda) {
		this.data_venda = data_venda;
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

	public LocalDateTime getDataExcluido() {
		return dataExcluido;
	}

	public void setDataExcluido(LocalDateTime dataExcluido) {
		this.dataExcluido = dataExcluido;
	}

}
