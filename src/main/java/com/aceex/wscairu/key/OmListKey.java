package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "om_list")
public class OmListKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;
	
	@Column(name = "num_om", nullable = false)
	private Integer ordem;

	@Column(name = "num_pedido", nullable = false)
	private Integer pedido;	
	
	public OmListKey() { }
	
	public OmListKey(String empresa, Integer ordem, Integer pedido) {
		super();
		this.empresa = empresa;
		this.ordem = ordem;
		this.pedido = pedido;
	}

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Integer getPedido() {
		return pedido;
	}
	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}	
}
