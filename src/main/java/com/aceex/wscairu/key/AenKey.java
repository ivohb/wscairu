package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "aen_api_cairu")
public class AenKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "nom_sys", length = 15)
	private String sistema;

	@Column(name = "cnpj", length = 19)
	private String cnpj;

	@Column(name = "cod_lin_prod")
	private Integer linhaProd;

	public AenKey() { }

	public AenKey(String sistema, String cnpj, Integer linhaProd) {
		super();
		this.sistema = sistema;
		this.cnpj = cnpj;
		this.linhaProd = linhaProd;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getLinhaProd() {
		return linhaProd;
	}

	public void setLinhaProd(Integer linhaProd) {
		this.linhaProd = linhaProd;
	}
		
}
