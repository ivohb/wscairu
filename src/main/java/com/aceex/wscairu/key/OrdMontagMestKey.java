package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ordem_montag_mest")
public class OrdMontagMestKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;
	
	@Column(name = "num_om", nullable = false)
	private Integer ordem;		
	
	public OrdMontagMestKey() { }
	
	public OrdMontagMestKey(String empresa, Integer ordem) {
		super();
		this.empresa = empresa;
		this.ordem = ordem;
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
}
