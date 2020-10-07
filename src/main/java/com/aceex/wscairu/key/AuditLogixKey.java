package com.aceex.wscairu.key;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
@Table(name = "audit_logix")
public class AuditLogixKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2)
	private String empresa;
	
	@Column(name = "num_programa", length = 10)
	private String programa;

	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "hora", length = 8)
	private String hora;

	public AuditLogixKey() { }

	public AuditLogixKey(String empresa, String programa, Date data, String hora) {
		super();
		this.empresa = empresa;
		this.programa = programa;
		this.data = data;
		this.hora = hora;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
