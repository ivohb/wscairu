package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.OrdMontagItemKey;

@Entity
@Table(name = "ordem_montag_item")
public class OrdMontagItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdMontagItemKey id = new OrdMontagItemKey();

	@Column(name = "qtd_volume_item", nullable = false)
	private Double qtdVolume;

	@Column(name = "qtd_reservada", nullable = false)
	private Double qtdReservada;

	@Column(name = "pes_total_item", nullable = false)
	private Double pesTotal;
	
	public OrdMontagItem() {}
	
	public OrdMontagItemKey getId() {
		return id;
	}
	public void setId(OrdMontagItemKey id) {
		this.id = id;
	}
	public Double getQtdVolume() {
		return qtdVolume;
	}
	public void setQtdVolume(Double qtdVolume) {
		this.qtdVolume = qtdVolume;
	}
	public Double getQtdReservada() {
		return qtdReservada;
	}
	public void setQtdReservada(Double qtdReservada) {
		this.qtdReservada = qtdReservada;
	}
	public Double getPesTotal() {
		return pesTotal;
	}
	public void setPesTotal(Double pesTotal) {
		this.pesTotal = pesTotal;
	}	
}
