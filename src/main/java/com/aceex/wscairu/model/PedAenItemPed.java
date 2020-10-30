package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedAenItemPedKey;

@Entity
@Table(name = "ped_aen_item_ped")
public class PedAenItemPed implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedAenItemPedKey id = new PedAenItemPedKey();

	@Column(name = "linha_produto")
	private Integer linProduto;

	@Column(name = "linha_receita")
	private Integer linReceita;

	@Column(name = "segmto_mercado")
	private Integer segMercado;

	@Column(name = "classe_uso")
	private Integer classeUso;
	
	public PedAenItemPed() {}
	
	public PedAenItemPedKey getId() {
		return id;
	}
	public void setId(PedAenItemPedKey id) {
		this.id = id;
	}
	public Integer getLinProduto() {
		return linProduto;
	}
	public void setLinProduto(Integer linProduto) {
		this.linProduto = linProduto;
	}
	public Integer getLinReceita() {
		return linReceita;
	}
	public void setLinReceita(Integer linReceita) {
		this.linReceita = linReceita;
	}
	public Integer getSegMercado() {
		return segMercado;
	}
	public void setSegMercado(Integer segMercado) {
		this.segMercado = segMercado;
	}
	public Integer getClasseUso() {
		return classeUso;
	}
	public void setClasseUso(Integer classeUso) {
		this.classeUso = classeUso;
	}
	
}
