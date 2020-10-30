package com.aceex.wscairu.dto;

import java.io.Serializable;

public class Saldo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double qtdLiberada;
	private Double qtdReservada;	
	private Double qtdDisponivel;	

	public Saldo() { }

	public Saldo(Double qtdLiberada, Double qtdReservada, Double qtdDisponivel) {
		super();
		this.qtdLiberada = qtdLiberada;
		this.qtdReservada = qtdReservada;
		this.qtdDisponivel = qtdDisponivel;
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
