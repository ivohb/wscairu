package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "item")
public class AenKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "nom_sys", length = 15)
	private String sistema;

	@Column(name = "cod_lin_prod")
	private Integer linhaProd;

	public AenKey() { }

	public AenKey(String sistema, Integer linhaProd) {
		super();
		this.sistema = sistema;
		this.linhaProd = linhaProd;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Integer getLinhaProd() {
		return linhaProd;
	}

	public void setLinhaProd(Integer linhaProd) {
		this.linhaProd = linhaProd;
	}
		
}
