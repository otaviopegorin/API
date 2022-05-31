package br.com.ApiStage3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "PEGORIN_Empresa")
public class Empresa {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name ="increment",strategy="increment")
	private Integer id_empresa;
	private String nome;
	private String contato;
	private String cnpj;

	@OneToMany(mappedBy = "empresa")
	private List<Estagio> estagios;

	public Empresa(String nome, String cnpj, List<Estagio> estagios) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.estagios = estagios;
	}

	public Empresa() {
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Estagio> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<Estagio> estagios) {
		this.estagios = estagios;
	}

	public EmpresaDTO toEmpresaDTO() {
		EmpresaDTO empresaDTO = new EmpresaDTO(this.nome, this.cnpj,this.contato, this.estagios);
		return empresaDTO;
	}
}
