package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aceex.wscairu.key.AuditItemKey;

@Entity
@Table(name = "audit_item")
public class AuditItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuditItemKey id = new AuditItemKey();
	
	@Column(name = "texto", length = 200)
	private String texto;

	@Column(name = "num_programa", length = 8)
	private String programa;

	@Column(name = "dat_cadastro")
	@Temporal(TemporalType.DATE)
	private Date cadastrado;

	@Column(name = "dat_atualiz_cad")
	@Temporal(TemporalType.DATE)
	private Date atualizado;

	@Column(name = "hor_proces", length = 8)
	private String hora;

	@Column(name = "nom_usuario", length = 8)
	private String usuario;	
	
	public AuditItem() { }
	
	public AuditItemKey getId() {
		return id;
	}
	public void setId(AuditItemKey id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public Date getCadastrado() {
		return cadastrado;
	}
	public void setCadastrado(Date cadastrado) {
		this.cadastrado = cadastrado;
	}
	public Date getAtualizado() {
		return atualizado;
	}
	public void setAtualizado(Date atualizado) {
		this.atualizado = atualizado;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
