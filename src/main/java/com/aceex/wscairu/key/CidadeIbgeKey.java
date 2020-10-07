package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "obf_cidade_ibge")
public class CidadeIbgeKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "estado_logix", length = 2)
	private String estado;
	
	@Column(name = "cidade_ibge", length = 15)
	private String cidIbge;
	
	public CidadeIbgeKey() { }

	public CidadeIbgeKey(String estado, String cidIbge) {
		super();
		this.estado = estado;
		this.cidIbge = cidIbge;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidIbge() {
		return cidIbge;
	}

	public void setCidIbge(String cidIbge) {
		this.cidIbge = cidIbge;
	}

}
