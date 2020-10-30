package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_api_cairu")
public class Systema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nom_sys", length = 15)
	private String id;	
	
	@Column(name = "user_envio", length = 15)
	private String userEnvio;
	
	@Column(name = "senha_envio", length = 80)
	private String senhaEnvio;

	@Column(name = "uri_env_prod", length = 80)
	private String uriEnvProd;

	@Column(name = "uri_env_estoq", length = 80)
	private String uriEnvEstoq;

	@Column(name = "uri_canc_pedido", length = 80)
	private String uriCancPedido;	
	
	@Column(name = "user_req_serv", length = 15)
	private String userReq;
	
	@Column(name = "senha_req_serv", length = 80)
	private String senhaReq;

	@Column(name = "qtd_lin_page")
	private Integer linPage;

	@Column(name = "max_lin_page")
	private Integer maxLinha;

	public Systema() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserEnvio() {
		return userEnvio;
	}

	public void setUserEnvio(String userEnvio) {
		this.userEnvio = userEnvio;
	}

	public String getSenhaEnvio() {
		return senhaEnvio;
	}

	public void setSenhaEnvio(String senhaEnvio) {
		this.senhaEnvio = senhaEnvio;
	}

	public String getUriEnvProd() {
		return uriEnvProd;
	}

	public void setUriEnvProd(String uriEnvProd) {
		this.uriEnvProd = uriEnvProd;
	}

	public String getUriEnvEstoq() {
		return uriEnvEstoq;
	}

	public void setUriEnvEstoq(String uriEnvEstoq) {
		this.uriEnvEstoq = uriEnvEstoq;
	}

	public String getUriCancPedido() {
		return uriCancPedido;
	}

	public void setUriCancPedido(String uriCancPedido) {
		this.uriCancPedido = uriCancPedido;
	}

	public String getUserReq() {
		return userReq;
	}

	public void setUserReq(String userReq) {
		this.userReq = userReq;
	}

	public String getSenhaReq() {
		return senhaReq;
	}

	public void setSenhaReq(String senhaReq) {
		this.senhaReq = senhaReq;
	}

	public Integer getLinPage() {
		return linPage;
	}

	public void setLinPage(Integer linPage) {
		this.linPage = linPage;
	}

	public Integer getMaxLinha() {
		return maxLinha;
	}

	public void setMaxLinha(Integer maxLinha) {
		this.maxLinha = maxLinha;
	}
	
}

