package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.EanKey;

@Entity
@Table(name = "item_barra")
public class Ean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EanKey id = new EanKey();

	@Column(name = "cod_item_barra_ser")
	private Integer ean;

	@Column(name = "cod_item_barra_dig")
	private Integer digito;

	public Ean() {}

	public EanKey getId() {
		return id;
	}

	public void setId(EanKey id) {
		this.id = id;
	}

	public Integer getEan() {
		return ean;
	}

	public void setEan(Integer ean) {
		this.ean = ean;
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}
	
}
