package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.LinhaProdKey;

@Entity
@Table(name = "linha_prod")
public class LinhaProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LinhaProdKey id = new LinhaProdKey();

	@Column(name = "den_estr_linprod", length = 20)
	private String descricao;

	public LinhaProd() { }

	public LinhaProdKey getId() {
		return id;
	}

	public void setId(LinhaProdKey id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
