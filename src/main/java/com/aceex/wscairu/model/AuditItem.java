package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "audit_item")
public class AuditItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_empresa", length = 2)
	private String empresa;

	@Column(name = "cod_item", length = 15)
	private String item;
	
	@Column(name = "texto", length = 200)
	private String texto;
	
	@Column(name = "num_programa", length = 200)
	private String programa;
	
	@Column(name = "dat_cadastro")
	@Temporal(TemporalType.DATE)
	private Date cadastro;
	
	@Column(name = "dat_atualiz_cad")
	@Temporal(TemporalType.DATE)	
	private Date atualizacao;
	
	@Column(name = "num_revisao")
	private Integer revisao;
	
	@Column(name = "hor_proces", length = 8)
	private String hora;
	
	@Column(name = "nom_usuario", length = 8)
	private String usuario;
	
	public AuditItem() {}
		
	public AuditItem(String item) {
		super();
		this.item = item;
	}

	public AuditItem(String item, Integer revisao) {
		super();
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
	public Date getCadastro() {
		return cadastro;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}
	public Date getAtualizacao() {
		return atualizacao;
	}
	public void setAtualizacao(Date atualizacao) {
		this.atualizacao = atualizacao;
	}
	public Integer getRevisao() {
		return revisao;
	}
	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
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
