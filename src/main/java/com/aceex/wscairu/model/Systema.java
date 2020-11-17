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

	@Column(name = "user_req_serv", length = 15)
	private String userReq;
	
	@Column(name = "senha_req_serv", length = 80)
	private String senhaReq;

	@Column(name = "user_erp", length = 8)
	private String userErp;

	@Column(name = "qtd_lin_page")
	private Integer linPage;

	@Column(name = "max_lin_page")
	private Integer maxLinha;

	@Column(name = "user_envio", length = 15)
	private String userEnvio;
	
	@Column(name = "senha_envio", length = 80)
	private String senhaEnvio;

	@Column(name = "uri_inc_prod", length = 80)
	private String uriIncProd;

	@Column(name = "uri_alt_prod", length = 80)
	private String uriAltProd;
	   
	@Column(name = "uri_alt_estoq", length = 80)
	private String uriAltEstoq;
	
	@Column(name = "uri_canc_pedido", length = 80)
	private String uriCancPedido;
	
	public Systema() { }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getUserErp() {
		return userErp;
	}
	public void setUserErp(String userErp) {
		this.userErp = userErp;
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
	public String getUriIncProd() {
		return uriIncProd;
	}
	public void setUriIncProd(String uriIncProd) {
		this.uriIncProd = uriIncProd;
	}
	public String getUriAltProd() {
		return uriAltProd;
	}
	public void setUriAltProd(String uriAltProd) {
		this.uriAltProd = uriAltProd;
	}
	public String getUriAltEstoq() {
		return uriAltEstoq;
	}
	public void setUriAltEstoq(String uriAltEstoq) {
		this.uriAltEstoq = uriAltEstoq;
	}
	public String getUriCancPedido() {
		return uriCancPedido;
	}
	public void setUriCancPedido(String uriCancPedido) {
		this.uriCancPedido = uriCancPedido;
	}
	
}

