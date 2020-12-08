package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.ItemEnviadoKey;

@Entity
@Table(name = "item_enviado")
public class ItemEnviado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemEnviadoKey id = new ItemEnviadoKey();

	@Column(name = "num_revisao")
	private Integer revisao;
	
	public ItemEnviado() {}

	public ItemEnviadoKey getId() {
		return id;
	}

	public void setId(ItemEnviadoKey id) {
		this.id = id;
	}

	public Integer getRevisao() {
		return revisao;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
		
}
