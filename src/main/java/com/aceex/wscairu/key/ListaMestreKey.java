package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "desc_preco_mest")
public class ListaMestreKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2)
	private String empresa;
	
	@Column(name = "num_list_preco")
	private Integer numero;

	public ListaMestreKey() { }

	public ListaMestreKey(String empresa, Integer numero) {
		super();
		this.empresa = empresa;
		this.numero = numero;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
