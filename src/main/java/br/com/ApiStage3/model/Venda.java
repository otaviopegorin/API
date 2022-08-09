package br.com.ApiStage3.model;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_venda;
	private String emailUsuario;
	@ManyToMany
	private List<Produto> produtos;
	private Date data_venda;
	private BigInteger preco;
	private Boolean excluido = false;
	private Date dataExcluido;

	public Venda() {
		
	}
	
	
	public Venda(String emailUsuario, List<Produto> produtos, BigInteger preco) {
		super();
		this.emailUsuario = emailUsuario;
		this.produtos = produtos;
		this.preco = preco;
	}


	public Venda(Integer id_venda, String usuario, List<Produto> produtos, Date data_venda, BigInteger preco,
			Boolean excluido, Date dataExcluido) {
		super();
		this.id_venda = id_venda;
		this.emailUsuario = usuario;
		this.produtos = produtos;
		this.data_venda = data_venda;
		this.preco = preco;
		this.excluido = excluido;
		this.dataExcluido = dataExcluido;
	}
	
	

	public Venda(String usuario, BigInteger preco) {
		super();
		this.emailUsuario = usuario;
		this.preco = preco;
	}
	
	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}

	public String getUsuario() {
		return emailUsuario;
	}

	public void setUsuario(String usuario) {
		this.emailUsuario = usuario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
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
