package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ordem_montag_lote")
public class OrdMontagLoteKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;
	
	@Column(name = "num_lote_om", nullable = false)
	private Integer lote;	
	
	public OrdMontagLoteKey() { }
	
	public OrdMontagLoteKey(String empresa, Integer lote) {
		super();
		this.empresa = empresa;
		this.lote = lote;
	}

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getLote() {
		return lote;
	}
	public void setLote(Integer lote) {
		this.lote = lote;
	}	
}
