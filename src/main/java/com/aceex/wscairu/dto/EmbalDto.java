package com.aceex.wscairu.dto;

import java.io.Serializable;

public class EmbalDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codEmbal;
	private Double qtdPadrao;
	private String codMatriz;
	private Double pesUnit;
	
	public EmbalDto() {}
	
	public EmbalDto(String codEmbal, Double qtdPadrao, String codMatriz, Double pesUnit) {
		super();
		this.codEmbal = codEmbal;
		this.qtdPadrao = qtdPadrao;
		this.codMatriz = codMatriz;
		this.pesUnit = pesUnit;
	}

	public String getCodEmbal() {
		return codEmbal;
	}
	public void setCodEmbal(String codEmbal) {
		this.codEmbal = codEmbal;
	}
	public Double getQtdPadrao() {
		return qtdPadrao;
	}
	public void setQtdPadrao(Double qtdPadrao) {
		this.qtdPadrao = qtdPadrao;
	}
	public String getCodMatriz() {
		return codMatriz;
	}
	public void setCodMatriz(String codMatriz) {
		this.codMatriz = codMatriz;
	}
	public Double getPesUnit() {
		return pesUnit;
	}
	public void setPesUnit(Double pesUnit) {
		this.pesUnit = pesUnit;
	}	
}
