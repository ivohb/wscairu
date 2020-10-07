package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "vdp_cli_parametro")
public class ClienteParamKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cliente", length = 15)
	private String cliente;
	
	@Column(name = "parametro", length = 20)
	private String parametro;
	
	public ClienteParamKey() { }

	public ClienteParamKey(String cliente, String parametro) {
		super();
		this.cliente = cliente;
		this.parametro = parametro;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}	

}
