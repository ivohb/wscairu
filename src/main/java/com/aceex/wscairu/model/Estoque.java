package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.EstoqueKey;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstoqueKey id = new EstoqueKey();

	@Column(name = "qtd_liberada", nullable = false)
	private Double qtdLiberada;

	@Column(name = "qtd_impedida", nullable = false)
	private Double qtdImpedida;

	@Column(name = "qtd_rejeitada", nullable = false)
	private Double qtdRejeitada;

	@Column(name = "qtd_lib_excep", nullable = false)
	private Double qtdLibExcep;

	@Column(name = "qtd_disp_venda", nullable = false)
	private Double qtdDispVenda;

	@Column(name = "qtd_reservada", nullable = false)
	private Double qtdReservada;

	@Column(name = "dat_ult_invent")
	private Date datUltInvent;

	@Column(name = "dat_ult_entrada")
	private Date datUltEntrada;

	@Column(name = "dat_ult_saida")
	private Date datUltSaida;
	
	public Estoque() { }
	
	public Estoque(Double qtdLiberada, Double qtdReservada) {
		super();
		this.qtdLiberada = qtdLiberada;
		this.qtdReservada = qtdReservada;
	}

	public EstoqueKey getId() {
		return id;
	}
	public void setId(EstoqueKey id) {
		this.id = id;
	}
	public Double getQtdLiberada() {
		return qtdLiberada;
	}
	public void setQtdLiberada(Double qtdLiberada) {
		this.qtdLiberada = qtdLiberada;
	}
	public Double getQtdImpedida() {
		return qtdImpedida;
	}
	public void setQtdImpedida(Double qtdImpedida) {
		this.qtdImpedida = qtdImpedida;
	}
	public Double getQtdRejeitada() {
		return qtdRejeitada;
	}
	public void setQtdRejeitada(Double qtdRejeitada) {
		this.qtdRejeitada = qtdRejeitada;
	}
	public Double getQtdLibExcep() {
		return qtdLibExcep;
	}
	public void setQtdLibExcep(Double qtdLibExcep) {
		this.qtdLibExcep = qtdLibExcep;
	}
	public Double getQtdDispVenda() {
		return qtdDispVenda;
	}
	public void setQtdDispVenda(Double qtdDispVenda) {
		this.qtdDispVenda = qtdDispVenda;
	}
	public Double getQtdReservada() {
		return qtdReservada;
	}
	public void setQtdReservada(Double qtdReservada) {
		this.qtdReservada = qtdReservada;
	}
	public Date getDatUltInvent() {
		return datUltInvent;
	}
	public void setDatUltInvent(Date datUltInvent) {
		this.datUltInvent = datUltInvent;
	}
	public Date getDatUltEntrada() {
		return datUltEntrada;
	}
	public void setDatUltEntrada(Date datUltEntrada) {
		this.datUltEntrada = datUltEntrada;
	}
	public Date getDatUltSaida() {
		return datUltSaida;
	}
	public void setDatUltSaida(Date datUltSaida) {
		this.datUltSaida = datUltSaida;
	}	
}
