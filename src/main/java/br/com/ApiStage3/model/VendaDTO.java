package br.com.ApiStage3.model;

import java.sql.Date;

public class VendaDTO {

	private Date data_venda;
	private double preco;
	private Boolean excluido;
	private Date dataExcluido;

	public VendaDTO(Date data_venda, double preco, boolean excluido, Date dataExcluido) {
		super();
		this.data_venda = data_venda;
		this.preco = preco;
		this.excluido = excluido;
		this.dataExcluido = dataExcluido;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
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

	public Date getDataExcluido() {
		return dataExcluido;
	}

	public void setDataExcluido(Date dataExcluido) {
		this.dataExcluido = dataExcluido;
	}

}
