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

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "cod_embal_int", length = 3, nullable = false)
	private String embalInt;

	@Column(name = "cod_embal_ext", length = 3, nullable = false)
	private String embalExt;
	
	public OrdMontagEmbalKey() { }
	
	public OrdMontagEmbalKey(String empresa, Integer ordem, Integer sequencia, String item, String embalInt,
			String embalExt) {
		super();
		this.empresa = empresa;
		this.ordem = ordem;
		this.sequencia = sequencia;
		this.item = item;
		this.embalInt = embalInt;
		this.embalExt = embalExt;
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getEmbalInt() {
		return embalInt;
	}
	public void setEmbalInt(String embalInt) {
		this.embalInt = embalInt;
	}
	public String getEmbalExt() {
		return embalExt;
	}
	public void setEmbalExt(String embalExt) {
		this.embalExt = embalExt;
	}
	 
}

