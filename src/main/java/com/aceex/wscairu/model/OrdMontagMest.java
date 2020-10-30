package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.OrdMontagMestKey;

@Entity
@Table(name = "ordem_montag_mest")
public class OrdMontagMest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdMontagMestKey id = new OrdMontagMestKey();

	@Column(name = "num_lote_om", nullable = false)
	private Integer lote;

	@Column(name = "ies_sit_om", length = 1, nullable = false)
	private String situacao;

	@Column(name = "cod_transpor", length = 15)
	private String transportador;

	@Column(name = "qtd_volume_om", nullable = false)
	private Double volume;

	@Column(name = "dat_emis")
	private Date emissao;

	@Column(name = "num_nff")
	private Integer notaFiscal;
	
	public OrdMontagMest() { }
	
	public OrdMontagMestKey getId() {
		return id;
	}
	public void setId(OrdMontagMestKey id) {
		this.id = id;
	}
	public Integer getLote() {
		return lote;
	}
	public void setLote(Integer lote) {
		this.lote = lote;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTransportador() {
		return transportador;
	}
	public void setTransportador(String transportador) {
		this.transportador = transportador;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Date getEmissao() {
		return emissao;
	}
	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}
	public Integer getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(Integer notaFiscal) {
		this.notaFiscal = notaFiscal;
	}	
}
