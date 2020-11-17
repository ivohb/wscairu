package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estoque_loc_reser")
public class EstoqLocReser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "num_reserva")
	private Integer id;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "cod_local", length = 10, nullable = false)
	private String local;

	@Column(name = "qtd_reservada", nullable = false)
	private Double qtdReservada;

	@Column(name = "num_lote", length = 15)
	private String lote;

	@Column(name = "ies_origem", length = 1, nullable = false)
	private String origem;

	@Column(name = "num_docum", length = 10)
	private String numDocum;

	@Column(name = "num_referencia", length = 15)
	private String numReferencia;

	@Column(name = "ies_situacao", length = 1)
	private String situacao;

	@Column(name = "dat_prev_baixa")
	private Date prevBaixa;

	@Column(name = "num_conta_deb", length = 23)
	private String contaDeb;

	@Column(name = "cod_uni_funcio", length = 10)
	private String uniFuncio;

	@Column(name = "nom_solicitante", length = 8)
	private String solicitante;

	@Column(name = "dat_solicitacao")
	private Date datSolicitacao;

	@Column(name = "nom_aprovante", length = 8)
	private String aprovante;

	@Column(name = "dat_aprovacao")
	private Date datAprovacao;

	@Column(name = "qtd_atendida")
	private Double qtdAtendida;

	@Column(name = "dat_ult_atualiz")
	private Date datAtualiz;
	
	public EstoqLocReser() {}

	public EstoqLocReser(Double qtdReservada) {
		this.qtdReservada = qtdReservada;
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Double getQtdReservada() {
		return qtdReservada;
	}
	public void setQtdReservada(Double qtdReservada) {
		this.qtdReservada = qtdReservada;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getNumDocum() {
		return numDocum;
	}
	public void setNumDocum(String numDocum) {
		this.numDocum = numDocum;
	}
	public String getNumReferencia() {
		return numReferencia;
	}
	public void setNumReferencia(String numReferencia) {
		this.numReferencia = numReferencia;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getPrevBaixa() {
		return prevBaixa;
	}
	public void setPrevBaixa(Date prevBaixa) {
		this.prevBaixa = prevBaixa;
	}
	public String getContaDeb() {
		return contaDeb;
	}
	public void setContaDeb(String contaDeb) {
		this.contaDeb = contaDeb;
	}
	public String getUniFuncio() {
		return uniFuncio;
	}
	public void setUniFuncio(String uniFuncio) {
		this.uniFuncio = uniFuncio;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public Date getDatSolicitacao() {
		return datSolicitacao;
	}
	public void setDatSolicitacao(Date datSolicitacao) {
		this.datSolicitacao = datSolicitacao;
	}
	public String getAprovante() {
		return aprovante;
	}
	public void setAprovante(String aprovante) {
		this.aprovante = aprovante;
	}
	public Date getDatAprovacao() {
		return datAprovacao;
	}
	public void setDatAprovacao(Date datAprovacao) {
		this.datAprovacao = datAprovacao;
	}
	public Double getQtdAtendida() {
		return qtdAtendida;
	}
	public void setQtdAtendida(Double qtdAtendida) {
		this.qtdAtendida = qtdAtendida;
	}
	public Date getDatAtualiz() {
		return datAtualiz;
	}
	public void setDatAtualiz(Date datAtualiz) {
		this.datAtualiz = datAtualiz;
	}
	
}
 