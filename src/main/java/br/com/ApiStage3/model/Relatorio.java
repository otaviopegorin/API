package br.com.ApiStage3.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "PEGORIN_Relatorio")
public class Relatorio {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name ="increment",strategy="increment")
	private Integer id_relatorio;
	@ManyToOne(fetch = FetchType.LAZY)
	private Estagio id_estagio;
	private Date dataInicio;
	private Date dataFim;
	@Enumerated(EnumType.STRING)
	private TipoRelatorio tipoDoRelatorio;
	private String relatorio;
	
	

	public Relatorio(Estagio id_estagio, Date dataInicio, Date dataFim, TipoRelatorio tipoDoRelatorio,
			String relatorio) {
		super();
		this.id_estagio = id_estagio;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipoDoRelatorio = tipoDoRelatorio;
		this.relatorio = relatorio;
	}

	public Integer getId_relatorio() {
		return id_relatorio;
	}

	public void setId_relatorio(Integer id_relatorio) {
		this.id_relatorio = id_relatorio;
	}

	public Estagio getId_estagio() {
		return id_estagio;
	}

	public void setId_estagio(Estagio id_estagio) {
		this.id_estagio = id_estagio;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public TipoRelatorio getTipoDoRelatorio() {
		return tipoDoRelatorio;
	}

	public void setTipoDoRelatorio(TipoRelatorio tipoDoRelatorio) {
		this.tipoDoRelatorio = tipoDoRelatorio;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}
	
	
}
