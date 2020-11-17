package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.OrdMontagLoteKey;

@Entity
@Table(name = "ordem_montag_lote")
public class OrdMontagLote implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrdMontagLoteKey id = new OrdMontagLoteKey();

	@Column(name = "ies_sit_lote", length = 1, nullable = false)
	private String situacao;

	@Column(name = "cod_transpor", length = 15, nullable = false)
	private String transportador;

	@Column(name = "dat_emis")
	private Date emissao;

	@Column(name = "cod_entrega", nullable = false)
	private Integer entrega;

	@Column(name = "cod_tip_carteira", length = 2, nullable = false)
	private String carteira;

	@Column(name = "num_placa", length = 7)
	private String placa;

	@Column(name = "val_frete_lote", nullable = false)
	private Double valFreteLote;

	@Column(name = "cod_consig", length = 15, nullable = false)
	private String consignatario;

	@Column(name = "val_frete_lote_con", nullable = false)
	private Double valFreteConsig;
	
	public OrdMontagLote() {}
	
	public OrdMontagLoteKey getId() {
		return id;
	}
	public void setId(OrdMontagLoteKey id) {
		this.id = id;
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
	public Date getEmissao() {
		return emissao;
	}
	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}
	public Integer getEntrega() {
		return entrega;
	}
	public void setEntrega(Integer entrega) {
		this.entrega = entrega;
	}
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Double getValFreteLote() {
		return valFreteLote;
	}
	public void setValFreteLote(Double valFreteLote) {
		this.valFreteLote = valFreteLote;
	}
	public String getConsignatario() {
		return consignatario;
	}
	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}
	public Double getValFreteConsig() {
		return valFreteConsig;
	}
	public void setValFreteConsig(Double valFreteConsig) {
		this.valFreteConsig = valFreteConsig;
	}		
}
