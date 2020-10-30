package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedInfComItemKey;

@Entity
@Table(name = "ped_inf_com_item")
public class PedInfComItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedInfComItemKey id = new PedInfComItemKey();

	@Column(name = "tip_item", length = 1)
	private String tipItem;

	@Column(name = "aen_remessa", length = 8)
	private String aenRemessa;

	@Column(name = "ind_reajuste")
	private Double indReajuste;

	@Column(name = "dat_ult_alteracao")
	private Date dat_ult_alteracao;

	@Column(name = "motivo_alteracao")
	private Double motivoAlteracao;
	
	public PedInfComItem() {}
	
	public PedInfComItemKey getId() {
		return id;
	}
	public void setId(PedInfComItemKey id) {
		this.id = id;
	}
	public String getTipItem() {
		return tipItem;
	}
	public void setTipItem(String tipItem) {
		this.tipItem = tipItem;
	}
	public String getAenRemessa() {
		return aenRemessa;
	}
	public void setAenRemessa(String aenRemessa) {
		this.aenRemessa = aenRemessa;
	}
	public Double getIndReajuste() {
		return indReajuste;
	}
	public void setIndReajuste(Double indReajuste) {
		this.indReajuste = indReajuste;
	}
	public Date getDat_ult_alteracao() {
		return dat_ult_alteracao;
	}
	public void setDat_ult_alteracao(Date dat_ult_alteracao) {
		this.dat_ult_alteracao = dat_ult_alteracao;
	}
	public Double getMotivoAlteracao() {
		return motivoAlteracao;
	}
	public void setMotivoAlteracao(Double motivoAlteracao) {
		this.motivoAlteracao = motivoAlteracao;
	}
	
}

                      
