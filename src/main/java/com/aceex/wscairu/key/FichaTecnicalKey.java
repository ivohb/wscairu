package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "item_compl_cairu")
public class FichaTecnicalKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "empresa", length = 2)
	private String empresa;
	
	@Column(name = "item", length = 15)
	private String codigo;

	public FichaTecnicalKey() { }

	public FichaTecnicalKey(String empresa, String codigo) {
		super();
		this.empresa = empresa;
		this.codigo = codigo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
		
}
