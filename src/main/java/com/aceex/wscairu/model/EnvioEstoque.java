package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "envio_estoq")
public class EnvioEstoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_sys", length = 15)
	private String  sistema;

	@Column(name = "cod_empresa", length = 2)
	private String  empresa;

	@Column(name = "num_cnpj", length = 19)
	private String  cnpj;

	@Column(name = "cod_item", length = 15)
	private String  item;

	@Column(name = "qtd_liberada")
	private Double qtdLiberada;
	
	@Column(name = "qtd_reservada")
	private Double qtdReservada;	

	@Column(name = "qtd_disponivel")
	private Double qtdDisponivel;	
	
	public EnvioEstoque() {}
	
	public EnvioEstoque(String sistema) {
		super();
		this.sistema = sistema;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getQtdLiberada() {
		return qtdLiberada;
	}
	public void setQtdLiberada(Double qtdLiberada) {
		this.qtdLiberada = qtdLiberada;
	}
	public Double getQtdReservada() {
		return qtdReservada;
	}
	public void setQtdReservada(Double qtdReservada) {
		this.qtdReservada = qtdReservada;
	}
	public Double getQtdDisponivel() {
		return qtdDisponivel;
	}
	public void setQtdDisponivel(Double qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}
	
}

  