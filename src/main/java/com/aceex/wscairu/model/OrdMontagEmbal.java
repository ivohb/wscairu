package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.OrdMontagEmbalKey;

@Entity
@Table(name = "ordem_montag_embal")
public class OrdMontagEmbal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdMontagEmbalKey id = new OrdMontagEmbalKey();

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "cod_embal_int", length = 3, nullable = false)
	private String embalInt;

	@Column(name = "cod_embal_ext", length = 3, nullable = false)
	private String embalExt;

	@Column(name = "qtd_embal_int", nullable = false)
	private Double qtdEmbalInt;

	@Column(name = "qtd_embal_ext", nullable = false)
	private Double qtdEmbalExt;

	@Column(name = "ies_lotacao", length = 1, nullable = false)
	private String iesLotacao;

	@Column(name = "num_embal_inicio", nullable = false)
	private Integer NumEmbalInicio;

	@Column(name = "num_embal_final", nullable = false)
	private Integer NumEmbalFinal;

	@Column(name = "qtd_pecas", nullable = false)
	private Double qtdPecas;	
	
	public OrdMontagEmbal() {}
	
	public OrdMontagEmbalKey getId() {
		return id;
	}
	public void setId(OrdMontagEmbalKey id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getEmbalInt() {
		return embalInt;
	}
	public void setEmbalInt(String embalInt) {
		this.embalInt = embalInt;
	}
	public String getEmbalExt() {
		return embalExt;
	}
	public void setEmbalExt(String embalExt) {
		this.embalExt = embalExt;
	}
	public Double getQtdEmbalInt() {
		return qtdEmbalInt;
	}
	public void setQtdEmbalInt(Double qtdEmbalInt) {
		this.qtdEmbalInt = qtdEmbalInt;
	}
	public Double getQtdEmbalExt() {
		return qtdEmbalExt;
	}
	public void setQtdEmbalExt(Double qtdEmbalExt) {
		this.qtdEmbalExt = qtdEmbalExt;
	}
	public String getIesLotacao() {
		return iesLotacao;
	}
	public void setIesLotacao(String iesLotacao) {
		this.iesLotacao = iesLotacao;
	}
	public Integer getNumEmbalInicio() {
		return NumEmbalInicio;
	}
	public void setNumEmbalInicio(Integer numEmbalInicio) {
		NumEmbalInicio = numEmbalInicio;
	}
	public Integer getNumEmbalFinal() {
		return NumEmbalFinal;
	}
	public void setNumEmbalFinal(Integer numEmbalFinal) {
		NumEmbalFinal = numEmbalFinal;
	}
	public Double getQtdPecas() {
		return qtdPecas;
	}
	public void setQtdPecas(Double qtdPecas) {
		this.qtdPecas = qtdPecas;
	}
	
}
