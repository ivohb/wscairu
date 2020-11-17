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

	@Column(name = "num_pedido", nullable = false)
	private Integer pedido;

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "qtd_volume_item", nullable = false)
	private Double qtdVolume;

	@Column(name = "qtd_reservada", nullable = false)
	private Double qtdReservada;

	@Column(name = "pes_total_item", nullable = false)
	private Double pesTotal;

	@Column(name = "ies_bonificacao", length = 1, nullable = false)
	private String bonificacao;
	
	public OrdMontagItem() {}
	
	public OrdMontagItemKey getId() {
		return id;
	}
	public void setId(OrdMontagItemKey id) {
		this.id = id;
	}	
	public Integer getPedido() {
		return pedido;
	}
	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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
	public String getBonificacao() {
		return bonificacao;
	}
	public void setBonificacao(String bonificacao) {
		this.bonificacao = bonificacao;
	}
	
}