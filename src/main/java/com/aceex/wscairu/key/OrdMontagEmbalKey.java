package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ordem_montag_embal")
public class OrdMontagEmbalKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;
	
	@Column(name = "num_om", nullable = false)
	private Integer ordem;

	@Column(name = "num_sequencia", nullable = false)
	private Integer sequencia;	
	
	public OrdMontagEmbalKey() { }
	
	public OrdMontagEmbalKey(String empresa, Integer ordem, Integer sequencia) {
		super();
		this.empresa = empresa;
		this.ordem = ordem;
		this.sequencia = sequencia;
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
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	
}

