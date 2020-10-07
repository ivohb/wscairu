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
@Table(name = "credcad_cli")
public class CredcadCli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_cliente", length = 15)
	private String id;

	@Column(name = "val_capital_regist", nullable = false)
	private Double valCapitalRegist;

	@Column(name = "dat_capital_regist")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datCapitalRegist;

	@Column(name = "val_credito_conced", nullable = false)
	private Double valCreditoConced;

	@Column(name = "dat_credito_conced")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datCreditoConced;

	@Column(name = "val_ult_pedido", nullable = false)
	private Double valUltPedido;

	@Column(name = "dat_ult_pedido")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datUltPedido;

	@Column(name = "val_pedidos", nullable = false)
	private Double valPedidos;

	@Column(name = "val_pedidos_aprov", nullable = false)
	private Double valPedidosAprov;

	@Column(name = "val_estoque", nullable = false)
	private Double valEstoque;

	@Column(name = "val_vendas_a_vista", nullable = false)
	private Double valVendasAvista;

	@Column(name = "val_vendas_a_prazo", nullable = false)
	private Double valVendasAprazo;

	@Column(name = "val_ult_fat", nullable = false)
	private Double valUltFat;

	@Column(name = "dat_ult_fat")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datUltFat;

	@Column(name = "val_maior_fat", nullable = false)
	private Double valMaiorFat;

	@Column(name = "dat_maior_fat")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date daMaiorFat;

	@Column(name = "val_faturado_mes", nullable = false)
	private Double valFaturadoMes;

	@Column(name = "val_pago_mes", nullable = false)
	private Double valPagoMes;

	@Column(name = "qtd_dupl_pagas_mes", nullable = false)
	private Double qtdDuplPagasMes;

	@Column(name = "dat_ult_pagto")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datUltPagto;

	@Column(name = "val_maior_acumulo", nullable = false)
	private Double valMaiorAcumulo;

	@Column(name = "dat_maior_acumulo")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datMaiorAcumulo;

	@Column(name = "val_debito_vencido", nullable = false)
	private Double valDebitoVencido;

	@Column(name = "val_debito_a_venc", nullable = false)
	private Double valDebitoAvencer;

	@Column(name = "val_juro_nao_pag", nullable = false)
	private Double valJuroNaoPag;

	@Column(name = "val_cheques", nullable = false)
	private Double valCheques;

	@Column(name = "val_creditos", nullable = false)
	private Double valCreditos;

	@Column(name = "val_lucros_perdas", nullable = false)
	private Double valLucrosPerdas;

	@Column(name = "dat_lucros_perdas")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datLucrosPerdas;

	@Column(name = "qtd_dias_maior_atr", nullable = false)
	private Double qtdDiasMaiorAtr;

	@Column(name = "dat_maior_atraso")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datMaiorAtraso;

	@Column(name = "qtd_dias_atras_med", nullable = false)
	private Double qtdDiasAtrasMed;

	@Column(name = "dat_ult_atu_manual")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datUltAtuManual;

	@Column(name = "dat_ult_atu_autom")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datUltAtuAutom;

	@Column(name = "ies_titulos_c_advo", nullable = false)
	private String iesTitulosCadvo;

	@Column(name = "cod_situa_cred")
	private Double codSituaCred;

	@Column(name = "ies_atua_sit_cre")
	private String iesAtuaSitCre;

	@Column(name = "ies_situa_cliente", nullable = false)
	private String iesSituaCliente;

	@Column(name = "ies_cheque_devolv", nullable = false)
	private String iesChequeDevolv;

	@Column(name = "ies_aprovacao", nullable = false)
	private String iesAprovacao;

	@Column(name = "qtd_cons_solic_mes", nullable = false)
	private Double qtdConsSolicMes;

	@Column(name = "ies_cli_colig", nullable = false)
	private String iesCliColig;

	@Column(name = "dat_ult_inf_solic")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date datUltInfSolic;

	public CredcadCli() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getValCapitalRegist() {
		return valCapitalRegist;
	}

	public void setValCapitalRegist(Double valCapitalRegist) {
		this.valCapitalRegist = valCapitalRegist;
	}

	public Date getDatCapitalRegist() {
		return datCapitalRegist;
	}

	public void setDatCapitalRegist(Date datCapitalRegist) {
		this.datCapitalRegist = datCapitalRegist;
	}

	public Double getValCreditoConced() {
		return valCreditoConced;
	}

	public void setValCreditoConced(Double valCreditoConced) {
		this.valCreditoConced = valCreditoConced;
	}

	public Date getDatCreditoConced() {
		return datCreditoConced;
	}

	public void setDatCreditoConced(Date datCreditoConced) {
		this.datCreditoConced = datCreditoConced;
	}

	public Double getValUltPedido() {
		return valUltPedido;
	}

	public void setValUltPedido(Double valUltPedido) {
		this.valUltPedido = valUltPedido;
	}

	public Date getDatUltPedido() {
		return datUltPedido;
	}

	public void setDatUltPedido(Date datUltPedido) {
		this.datUltPedido = datUltPedido;
	}

	public Double getValPedidos() {
		return valPedidos;
	}

	public void setValPedidos(Double valPedidos) {
		this.valPedidos = valPedidos;
	}

	public Double getValPedidosAprov() {
		return valPedidosAprov;
	}

	public void setValPedidosAprov(Double valPedidosAprov) {
		this.valPedidosAprov = valPedidosAprov;
	}

	public Double getValEstoque() {
		return valEstoque;
	}

	public void setValEstoque(Double valEstoque) {
		this.valEstoque = valEstoque;
	}

	public Double getValVendasAvista() {
		return valVendasAvista;
	}

	public void setValVendasAvista(Double valVendasAvista) {
		this.valVendasAvista = valVendasAvista;
	}

	public Double getValVendasAprazo() {
		return valVendasAprazo;
	}

	public void setValVendasAprazo(Double valVendasAprazo) {
		this.valVendasAprazo = valVendasAprazo;
	}

	public Double getValUltFat() {
		return valUltFat;
	}

	public void setValUltFat(Double valUltFat) {
		this.valUltFat = valUltFat;
	}

	public Date getDatUltFat() {
		return datUltFat;
	}

	public void setDatUltFat(Date datUltFat) {
		this.datUltFat = datUltFat;
	}

	public Double getValMaiorFat() {
		return valMaiorFat;
	}

	public void setValMaiorFat(Double valMaiorFat) {
		this.valMaiorFat = valMaiorFat;
	}

	public Date getDaMaiorFat() {
		return daMaiorFat;
	}

	public void setDaMaiorFat(Date daMaiorFat) {
		this.daMaiorFat = daMaiorFat;
	}

	public Double getValFaturadoMes() {
		return valFaturadoMes;
	}

	public void setValFaturadoMes(Double valFaturadoMes) {
		this.valFaturadoMes = valFaturadoMes;
	}

	public Double getValPagoMes() {
		return valPagoMes;
	}

	public void setValPagoMes(Double valPagoMes) {
		this.valPagoMes = valPagoMes;
	}

	public Double getQtdDuplPagasMes() {
		return qtdDuplPagasMes;
	}

	public void setQtdDuplPagasMes(Double qtdDuplPagasMes) {
		this.qtdDuplPagasMes = qtdDuplPagasMes;
	}

	public Date getDatUltPagto() {
		return datUltPagto;
	}

	public void setDatUltPagto(Date datUltPagto) {
		this.datUltPagto = datUltPagto;
	}

	public Double getValMaiorAcumulo() {
		return valMaiorAcumulo;
	}

	public void setValMaiorAcumulo(Double valMaiorAcumulo) {
		this.valMaiorAcumulo = valMaiorAcumulo;
	}

	public Date getDatMaiorAcumulo() {
		return datMaiorAcumulo;
	}

	public void setDatMaiorAcumulo(Date datMaiorAcumulo) {
		this.datMaiorAcumulo = datMaiorAcumulo;
	}

	public Double getValDebitoVencido() {
		return valDebitoVencido;
	}

	public void setValDebitoVencido(Double valDebitoVencido) {
		this.valDebitoVencido = valDebitoVencido;
	}

	public Double getValDebitoAvencer() {
		return valDebitoAvencer;
	}

	public void setValDebitoAvencer(Double valDebitoAvencer) {
		this.valDebitoAvencer = valDebitoAvencer;
	}

	public Double getValJuroNaoPag() {
		return valJuroNaoPag;
	}

	public void setValJuroNaoPag(Double valJuroNaoPag) {
		this.valJuroNaoPag = valJuroNaoPag;
	}

	public Double getValCheques() {
		return valCheques;
	}

	public void setValCheques(Double valCheques) {
		this.valCheques = valCheques;
	}

	public Double getValCreditos() {
		return valCreditos;
	}

	public void setValCreditos(Double valCreditos) {
		this.valCreditos = valCreditos;
	}

	public Double getValLucrosPerdas() {
		return valLucrosPerdas;
	}

	public void setValLucrosPerdas(Double valLucrosPerdas) {
		this.valLucrosPerdas = valLucrosPerdas;
	}

	public Date getDatLucrosPerdas() {
		return datLucrosPerdas;
	}

	public void setDatLucrosPerdas(Date datLucrosPerdas) {
		this.datLucrosPerdas = datLucrosPerdas;
	}

	public Double getQtdDiasMaiorAtr() {
		return qtdDiasMaiorAtr;
	}

	public void setQtdDiasMaiorAtr(Double qtdDiasMaiorAtr) {
		this.qtdDiasMaiorAtr = qtdDiasMaiorAtr;
	}

	public Date getDatMaiorAtraso() {
		return datMaiorAtraso;
	}

	public void setDatMaiorAtraso(Date datMaiorAtraso) {
		this.datMaiorAtraso = datMaiorAtraso;
	}

	public Double getQtdDiasAtrasMed() {
		return qtdDiasAtrasMed;
	}

	public void setQtdDiasAtrasMed(Double qtdDiasAtrasMed) {
		this.qtdDiasAtrasMed = qtdDiasAtrasMed;
	}

	public Date getDatUltAtuManual() {
		return datUltAtuManual;
	}

	public void setDatUltAtuManual(Date datUltAtuManual) {
		this.datUltAtuManual = datUltAtuManual;
	}

	public Date getDatUltAtuAutom() {
		return datUltAtuAutom;
	}

	public void setDatUltAtuAutom(Date datUltAtuAutom) {
		this.datUltAtuAutom = datUltAtuAutom;
	}

	public String getIesTitulosCadvo() {
		return iesTitulosCadvo;
	}

	public void setIesTitulosCadvo(String iesTitulosCadvo) {
		this.iesTitulosCadvo = iesTitulosCadvo;
	}

	public Double getCodSituaCred() {
		return codSituaCred;
	}

	public void setCodSituaCred(Double codSituaCred) {
		this.codSituaCred = codSituaCred;
	}

	public String getIesAtuaSitCre() {
		return iesAtuaSitCre;
	}

	public void setIesAtuaSitCre(String iesAtuaSitCre) {
		this.iesAtuaSitCre = iesAtuaSitCre;
	}

	public String getIesSituaCliente() {
		return iesSituaCliente;
	}

	public void setIesSituaCliente(String iesSituaCliente) {
		this.iesSituaCliente = iesSituaCliente;
	}

	public String getIesChequeDevolv() {
		return iesChequeDevolv;
	}

	public void setIesChequeDevolv(String iesChequeDevolv) {
		this.iesChequeDevolv = iesChequeDevolv;
	}

	public String getIesAprovacao() {
		return iesAprovacao;
	}

	public void setIesAprovacao(String iesAprovacao) {
		this.iesAprovacao = iesAprovacao;
	}

	public Double getQtdConsSolicMes() {
		return qtdConsSolicMes;
	}

	public void setQtdConsSolicMes(Double qtdConsSolicMes) {
		this.qtdConsSolicMes = qtdConsSolicMes;
	}

	public String getIesCliColig() {
		return iesCliColig;
	}

	public void setIesCliColig(String iesCliColig) {
		this.iesCliColig = iesCliColig;
	}

	public Date getDatUltInfSolic() {
		return datUltInfSolic;
	}

	public void setDatUltInfSolic(Date datUltInfSolic) {
		this.datUltInfSolic = datUltInfSolic;
	}
		
}

