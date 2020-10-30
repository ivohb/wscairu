package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedComplPedKey;

@Entity
@Table(name = "ped_compl_pedido")
public class PedComplPed implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedComplPedKey id = new PedComplPedKey();

	@Column(name = "dat_hor_inclusao")
	private Date data;

	@Column(name = "usuario_inclusao", length = 8)
	private String usuario;

	@Column(name = "portador")
	private Integer portador;

	@Column(name = "tip_portador", length = 1)
	private String tipPortador;

	@Column(name = "forma_pagto", length = 2)
	private String formaPagto;

	@Column(name = "finalidade_uso", length = 1)
	private String finalidade;

	@Column(name = "tip_desc")
	private Integer tipDesc;

	@Column(name = "emissao_pedido", length = 1)
	private String emisPedido;

	@Column(name = "processo_export", length = 12)
	private String procesExport;

	@Column(name = "empresa_venda", length = 2)
	private String empresaVenda;
	
	public PedComplPed() {}
	
	public PedComplPedKey getId() {
		return id;
	}
	public void setId(PedComplPedKey id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getPortador() {
		return portador;
	}
	public void setPortador(Integer portador) {
		this.portador = portador;
	}
	public String getTipPortador() {
		return tipPortador;
	}
	public void setTipPortador(String tipPortador) {
		this.tipPortador = tipPortador;
	}
	public String getFormaPagto() {
		return formaPagto;
	}
	public void setFormaPagto(String formaPagto) {
		this.formaPagto = formaPagto;
	}
	public String getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}
	public Integer getTipDesc() {
		return tipDesc;
	}
	public void setTipDesc(Integer tipDesc) {
		this.tipDesc = tipDesc;
	}
	public String getEmisPedido() {
		return emisPedido;
	}
	public void setEmisPedido(String emisPedido) {
		this.emisPedido = emisPedido;
	}
	public String getProcesExport() {
		return procesExport;
	}
	public void setProcesExport(String procesExport) {
		this.procesExport = procesExport;
	}
	public String getEmpresaVenda() {
		return empresaVenda;
	}
	public void setEmpresaVenda(String empresaVenda) {
		this.empresaVenda = empresaVenda;
	}
	
}

