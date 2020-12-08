package com.aceex.wscairu.key;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "audit_item")
public class AuditItemKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2)
	private String empresa;
	
	@Column(name = "cod_item", length = 15)
	private String item;

	@Column(name = "num_revisao")
	private Integer revisao;
	
	public AuditItemKey() { }
	
	public AuditItemKey(String empresa, String item, Date data, Integer revisao) {
		super();
		this.empresa = empresa;
		this.item = item;
		this.revisao = revisao;
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
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}
	
}
