package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_api_cairu")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cnpj", length = 19)
	private String id;

	@Column(name = "empresa", length = 2)
	private String empresa;

	@Column(name = "uf", length = 2)
	private String uf;

	@Column(name = "enviar", length = 1)
	private String enviar;

	@Column(name = "gerar", length = 1)
	private String gerar;

	public Empresa() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEnviar() {
		return enviar;
	}

	public void setEnviar(String enviar) {
		this.enviar = enviar;
	}

	public String getGerar() {
		return gerar;
	}

	public void setGerar(String gerar) {
		this.gerar = gerar;
	}

}
