package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ped_compl_pedido")
public class PedComplPedKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "empresa", length = 2)
	private String empresa;
	
	@Column(name = "pedido")
	private Integer numero;
	
	public PedComplPedKey() { }

	public PedComplPedKey(String empresa, Integer numero) {
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
