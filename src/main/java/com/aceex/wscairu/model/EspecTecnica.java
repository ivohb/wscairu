package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.EspecTecnicaKey;

@Entity
@Table(name = "man_espf_it_cad")
public class EspecTecnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EspecTecnicaKey id = new EspecTecnicaKey();

	@Column(name = "des_espf_item", length = 4000)
	private String descTecnica;
	
	public EspecTecnica() {}

	public EspecTecnicaKey getId() {
		return id;
	}

	public void setId(EspecTecnicaKey id) {
		this.id = id;
	}

	public String getDescTecnica() {
		return descTecnica;
	}

	public void setDescTecnica(String descTecnica) {
		this.descTecnica = descTecnica;
	}
	
}
