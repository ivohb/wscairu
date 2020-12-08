package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trans_proces")
public class TransProces implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "num_transac")
	private Integer id;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;

	@Column(name = "dat_atualiz")
	private Date datAtualiz;

	@Column(name = "hor_atualiz", length = 8)
	private String horAtualiz;

	public TransProces() { }
	
	public TransProces(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getDatAtualiz() {
		return datAtualiz;
	}
	public void setDatAtualiz(Date datAtualiz) {
		this.datAtualiz = datAtualiz;
	}
	public String getHorAtualiz() {
		return horAtualiz;
	}
	public void setHorAtualiz(String horAtualiz) {
		this.horAtualiz = horAtualiz;
	}
}
