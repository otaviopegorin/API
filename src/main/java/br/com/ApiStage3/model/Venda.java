package br.com.ApiStage3.model;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
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
	@OneToMany(mappedBy = "venda")
	private List<Item_venda> produtos;
	private Date data_venda;
	private BigInteger preco;
	private Boolean excluido;
	private Date dataExcluido;

	public Venda() {
		
	}
	public Venda(Integer id_venda, Usuario usuario, List<Item_venda> produtos, Date data_venda, BigInteger preco,
			Boolean excluido, Date dataExcluido) {
		super();
		this.id_venda = id_venda;
		this.usuario = usuario;
		this.produtos = produtos;
		this.data_venda = data_venda;
		this.preco = preco;
		this.excluido = excluido;
		this.dataExcluido = dataExcluido;
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
		return produtos;
	}

	public void setProdutos(List<Item_venda> produtos) {
		this.produtos = produtos;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
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

	public Date getDataExcluido() {
		return dataExcluido;
	}

	public void setDataExcluido(Date dataExcluido) {
		this.dataExcluido = dataExcluido;
	}

	public VendaDTO toDTO() {
		VendaDTO dto = new VendaDTO(this.data_venda, this.preco, this.excluido, this.dataExcluido);
		return dto;
	}
}