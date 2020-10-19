package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedObservacaoKey;

@Entity
@Table(name = "ped_observacao")
public class PedObservacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedObservacaoKey id = new PedObservacaoKey();
	@Column(name = "tex_observ_1", length = 76)
	private String txtObs1;
	@Column(name = "tex_observ_2", length = 76)
	private String txtObs2;
	
	public PedObservacao() { }
	
	public PedObservacaoKey getId() {
		return id;
	}
	public void setId(PedObservacaoKey id) {
		this.id = id;
	}
	public String getTxtObs1() {
		return txtObs1;
	}
	public void setTxtObs1(String txtObs1) {
		this.txtObs1 = txtObs1;
	}
	public String getTxtObs2() {
		return txtObs2;
	}
	public void setTxtObs2(String txtObs2) {
		this.txtObs2 = txtObs2;
	}

}
