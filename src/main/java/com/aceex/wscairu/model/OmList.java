package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.OmListKey;

@Entity
@Table(name = "om_list")
public class OmList implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OmListKey id = new OmListKey();

	@Column(name = "dat_emis", nullable = false)
	private Date emissao;

	@Column(name = "nom_usuario", length = 8, nullable = false)
	private String usuario;
	
	public OmList() {}
	
	public OmListKey getId() {
		return id;
	}
	public void setId(OmListKey id) {
		this.id = id;
	}
	public Date getEmissao() {
		return emissao;
	}
	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
