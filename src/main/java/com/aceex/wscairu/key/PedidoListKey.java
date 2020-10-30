package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "pedido_list")
public class PedidoListKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2)
	private String empresa;
	
	@Column(name = "num_pedido")
	private Integer pedido;

	@Column(name = "nom_usuario", length = 2)
	private String usuario;
	
	public PedidoListKey() { }
	
	public PedidoListKey(String empresa, Integer pedido, String usuario) {
		super();
		this.empresa = empresa;
		this.pedido = pedido;
		this.usuario = usuario;
	}

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getPedido() {
		return pedido;
	}
	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
