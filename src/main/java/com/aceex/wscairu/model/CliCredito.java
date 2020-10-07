package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cli_credito")
public class CliCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_cliente", length = 15)
	private String id;
	
	@Column(name = "qtd_dias_atr_dupl", nullable = false)
	private Double atrasoDupl;
	
	@Column(name = "qtd_dias_atr_med", nullable = false)
	private Double atrasoMedido;

	@Column(name = "val_ped_carteira", nullable = false)
	private Double valCarteira;

	@Column(name = "val_dup_aberto", nullable = false)
	private Double dupAberto;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dat_ult_fat")
	private Date ultFat;
	
	@Column(name = "val_limite_cred", nullable = false)
	private Double limitCredito;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dat_val_lmt_cr")
	private Date datLimitCred;
		
	@Column(name = "ies_nota_debito", length = 1, nullable = false)
	private String iesNotaDeb;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dat_atualiz", nullable = false)
	private Date datAtualiz;

	public CliCredito() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAtrasoDupl() {
		return atrasoDupl;
	}

	public void setAtrasoDupl(Double atrasoDupl) {
		this.atrasoDupl = atrasoDupl;
	}

	public Double getAtrasoMedido() {
		return atrasoMedido;
	}

	public void setAtrasoMedido(Double atrasoMedido) {
		this.atrasoMedido = atrasoMedido;
	}

	public Double getValCarteira() {
		return valCarteira;
	}

	public void setValCarteira(Double valCarteira) {
		this.valCarteira = valCarteira;
	}

	public Double getDupAberto() {
		return dupAberto;
	}

	public void setDupAberto(Double dupAberto) {
		this.dupAberto = dupAberto;
	}

	public Date getUltFat() {
		return ultFat;
	}

	public void setUltFat(Date ultFat) {
		this.ultFat = ultFat;
	}

	public Double getLimitCredito() {
		return limitCredito;
	}

	public void setLimitCredito(Double limitCredito) {
		this.limitCredito = limitCredito;
	}

	public Date getDatLimitCred() {
		return datLimitCred;
	}

	public void setDatLimitCred(Date datLimitCred) {
		this.datLimitCred = datLimitCred;
	}

	public String getIesNotaDeb() {
		return iesNotaDeb;
	}

	public void setIesNotaDeb(String iesNotaDeb) {
		this.iesNotaDeb = iesNotaDeb;
	}

	public Date getDatAtualiz() {
		return datAtualiz;
	}

	public void setDatAtualiz(Date datAtualiz) {
		this.datAtualiz = datAtualiz;
	}
		
}
