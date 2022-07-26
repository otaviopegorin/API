package br.com.ApiStage3.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_venda;
	@ManyToOne
	private Usuario usuario;
	@OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
	private List<Item_venda> itens;
	private LocalDateTime data_venda;
	private double preco;
	private Boolean excluido = false;
	private LocalDateTime dataExcluido;
	@Column(name = "status_venda")
	private String statusVenda = "EM ANDAMENTO";

	public List<Item_venda> getItens() {
		return itens;
	}

	public void setItens(List<Item_venda> itens) {
		this.itens = itens;
	}

	public String getStatusVenda() {
		return statusVenda;
	}

	public void setStatusVenda(String statusVenda) {
		this.statusVenda = statusVenda;
	}

	public Venda(Integer id_venda, Usuario usuario, List<Item_venda> itens, LocalDateTime data_venda, double preco,
			Boolean excluido, LocalDateTime dataExcluido, String statusVenda) {
		super();
		this.id_venda = id_venda;
		this.usuario = usuario;
		this.itens = itens;
		this.data_venda = data_venda;
		this.preco = preco;
		this.excluido = excluido;
		this.dataExcluido = dataExcluido;
		this.statusVenda = statusVenda;
	}

	public Venda() {

	}

	public Venda(Usuario usuario, List<Item_venda> produtos, double preco) {
		super();
		this.usuario = usuario;
		this.itens = produtos;
		this.preco = preco;
	}

	public Venda(Integer id_venda, Usuario usuario, List<Item_venda> produtos, LocalDateTime data_venda, double preco,
			Boolean excluido, LocalDateTime dataExcluido) {
		super();
		this.id_venda = id_venda;
		this.usuario = usuario;
		this.itens = produtos;
		this.data_venda = data_venda;
		this.preco = preco;
		this.excluido = excluido;
		this.dataExcluido = dataExcluido;
	}

	public Venda(Usuario usuario, double preco) {
		super();
		this.usuario = usuario;
		this.preco = preco;
	}

	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Item_venda> getProdutos() {
		return itens;
	}

	public void setProdutos(List<Item_venda> produtos) {
		this.itens = produtos;
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

	public VendaDTO toDTO() {
		VendaDTO dto = new VendaDTO(this.data_venda, this.preco, this.excluido, this.dataExcluido);
		return dto;
	}
}
