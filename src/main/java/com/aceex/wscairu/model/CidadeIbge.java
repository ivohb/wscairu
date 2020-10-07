package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.CidadeIbgeKey;

@Entity
@Table(name = "obf_cidade_ibge")
public class CidadeIbge implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CidadeIbgeKey id = new CidadeIbgeKey();
	
	@Column(name = "cidade_logix", length = 5)
	private String cidLogix;

	public CidadeIbgeKey getId() {
		return id;
	}

	public void setId(CidadeIbgeKey id) {
		this.id = id;
	}

	public String getCidLogix() {
		return cidLogix;
	}

	public void setCidLogix(String cidLogix) {
		this.cidLogix = cidLogix;
	}

}
