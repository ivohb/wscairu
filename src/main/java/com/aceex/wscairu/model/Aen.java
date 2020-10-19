package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.AenKey;

@Entity
@Table(name = "aen_api_cairu")
public class Aen implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AenKey id = new AenKey();

	@Column(name = "desc_linha", length = 30)
	private String descricao;
	
	public Aen() {}

	public AenKey getId() {
		return id;
	}

	public void setId(AenKey id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
