package com.aceex.wscairu.dto;

import java.io.Serializable;

public class EstoqueDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cnpjEmpresa;
	private String codEmpresa;
	private String codigo;
	private Double qtdLiberada;
	private Double qtdReservada;	
	private Double qtdDisponivel;	
	
	public EstoqueDto() { }
		
	public EstoqueDto(String codEmpresa, String codigo, 
			Double qtdLiberada, Double qtdReservada) {
		super();
		this.codEmpresa = codEmpresa;
		this.codigo = codigo;
		this.qtdLiberada = qtdLiberada;
		this.qtdReservada = qtdReservada;
	}

	public EstoqueDto(String codEmpresa, String codigo, 
			Double qtdLiberada, Double qtdReservada, Double qtdDisponivel) {
		super();
		this.codEmpresa = codEmpresa;
		this.codigo = codigo;
		this.qtdLiberada = qtdLiberada;
		this.qtdReservada = qtdReservada;
		this.qtdDisponivel = qtdDisponivel;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

