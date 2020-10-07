package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.ClienteParamKey;

@Entity
@Table(name = "vdp_cli_parametro")
public class ClienteParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClienteParamKey id = new ClienteParamKey();
	
	@Column(name = "des_parametro", length = 60, nullable = false)
	private String desParametro;

	@Column(name = "tip_parametro", length = 1)
	private String tipParametro;

	@Column(name = "texto_parametro", length = 70)
	private String txtParametro;

	@Column(name = "val_parametro")
	private Double valParametro;

	@Column(name = "num_parametro")
	private Double numParametro;

	@Column(name = "dat_parametro")
	private Date datParametro;

	public ClienteParam() { }

	public ClienteParamKey getId() {
		return id;
	}

	public void setId(ClienteParamKey id) {
		this.id = id;
	}

	public String getDesParametro() {
		return desParametro;
	}

	public void setDesParametro(String desParametro) {
		this.desParametro = desParametro;
	}

	public String getTipParametro() {
		return tipParametro;
	}

	public void setTipParametro(String tipParametro) {
		this.tipParametro = tipParametro;
	}

	public String getTxtParametro() {
		return txtParametro;
	}

	public void setTxtParametro(String txtParametro) {
		this.txtParametro = txtParametro;
	}

	public Double getValParametro() {
		return valParametro;
	}

	public void setValParametro(Double valParametro) {
		this.valParametro = valParametro;
	}

	public Double getNumParametro() {
		return numParametro;
	}

	public void setNumParametro(Double numParametro) {
		this.numParametro = numParametro;
	}

	public Date getDatParametro() {
		return datParametro;
	}

	public void setDatParametro(Date datParametro) {
		this.datParametro = datParametro;
	}
		
}

