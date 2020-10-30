package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedidoListKey;

@Entity
@Table(name = "pedido_list")
public class PedidoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoListKey id = new PedidoListKey();
	
	public PedidoList() {	}

	public PedidoListKey getId() {
		return id;
	}

	public void setId(PedidoListKey id) {
		this.id = id;
	}
		
}
