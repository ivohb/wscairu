package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_embalagem")
public class ItemEmbal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "num_transac")
	private Integer id;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "cod_embal", length = 3)
	private String embalagem;

	@Column(name = "ies_tip_embal", length = 1, nullable = false)
	private String tipo;

	@Column(name = "qtd_padr_embal", nullable = false)
	private Double qtdPadrao;

	@Column(name = "vol_padr_embal", nullable = false)
	private Double volPadrao;

	@Column(name = "ind_multi_volume", length = 1, nullable = false)
	private String multVolume;
	
	public ItemEmbal() { }
	
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getQtdPadrao() {
		return qtdPadrao;
	}
	public void setQtdPadrao(Double qtdPadrao) {
		this.qtdPadrao = qtdPadrao;
	}
	public Double getVolPadrao() {
		return volPadrao;
	}
	public void setVolPadrao(Double volPadrao) {
		this.volPadrao = volPadrao;
	}
	public String getMultVolume() {
		return multVolume;
	}
	public void setMultVolume(String multVolume) {
		this.multVolume = multVolume;
	}
	
}


