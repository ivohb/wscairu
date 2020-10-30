package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ped_aen_item_ped")
public class PedAenItemPedKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "empresa", length = 2)
	private String empresa;
	
	@Column(name = "pedido")
	private Integer numero;

	@Column(name = "sequencia")
	private Integer sequencia;
	
	public PedAenItemPedKey() { }


	public PedAenItemPedKey(String empresa, Integer numero, Integer sequencia) {
		super();
		this.empresa = empresa;
		this.numero = numero;
		this.sequencia = sequencia;
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

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	
}
