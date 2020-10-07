package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.AuditLogixKey;

@Entity
@Table(name = "audit_logix")
public class AuditLogix implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuditLogixKey id = new AuditLogixKey();
	
	@Column(name = "texto", length = 200)
	private String texto;
	
	@Column(name = "usuario", length = 8)
	private String usuario;
	
	public AuditLogix() { }

	public AuditLogixKey getId() {
		return id;
	}

	public void setId(AuditLogixKey id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
