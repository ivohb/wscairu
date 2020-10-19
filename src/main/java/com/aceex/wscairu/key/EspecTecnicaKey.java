package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "man_espf_it_cad")
public class EspecTecnicaKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "empresa", length = 2)
	private String empresa;
	
	@Column(name = "item", length = 15)
	private String item;

	@Column(name = "seq_especificacao", length = 15)
	private Integer sequencia;

	public EspecTecnicaKey() { }

	public EspecTecnicaKey(String empresa, String item, Integer sequencia) {
		super();
		this.empresa = empresa;
		this.item = item;
		this.sequencia = sequencia;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

}

