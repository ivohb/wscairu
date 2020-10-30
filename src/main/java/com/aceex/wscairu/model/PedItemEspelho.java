package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ped_itens_espelho")
public class PedItemEspelho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "cod_empresa", length = 2)
	private String empresa;

	@Column(name = "num_pedido")
	private Integer numero;

	@Column(name = "num_sequencia")
	private Integer sequencia;

	@Column(name = "cod_item", length = 15)
	private String item;

	@Column(name = "prz_entrega")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date przEntrega;

	@Column(name = "pre_unit")
	private Double preUnit;

	@Column(name = "qtd_pecas_solic")
	private Double qtdSolicit;
	
	@Column(name = "qtd_pecas_atend")
	private Double qtdAtendida;
	
	@Column(name = "qtd_pecas_cancel")
	private Double qtdCancelada;
	
	public PedItemEspelho() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Date getPrzEntrega() {
		return przEntrega;
	}
	public void setPrzEntrega(Date przEntrega) {
		this.przEntrega = przEntrega;
	}
	public Double getPreUnit() {
		return preUnit;
	}
	public void setPreUnit(Double preUnit) {
		this.preUnit = preUnit;
	}
	public Double getQtdSolicit() {
		return qtdSolicit;
	}
	public void setQtdSolicit(Double qtdSolicit) {
		this.qtdSolicit = qtdSolicit;
	}
	public Double getQtdAtendida() {
		return qtdAtendida;
	}
	public void setQtdAtendida(Double qtdAtendida) {
		this.qtdAtendida = qtdAtendida;
	}
	public Double getQtdCancelada() {
		return qtdCancelada;
	}
	public void setQtdCancelada(Double qtdCancelada) {
		this.qtdCancelada = qtdCancelada;
	}
	

}
