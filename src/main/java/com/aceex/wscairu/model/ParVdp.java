package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "par_vdp")
public class ParVdp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_empresa", length = 2)
	private String id;

	@Column(name = "mes_estoque")
	private Integer mesEstoque;

	@Column(name = "ano_estoque")
	private Integer anoEstoque;

	@Column(name = "num_nff")
	private Integer numNff;

	@Column(name = "mes_faturamento")
	private Integer mesFaturamento;

	@Column(name = "ano_faturamento")
	private Integer anoFaturamento;

	@Column(name = "qtd_linhas_nff")
	private Integer qtdLinNff;

	@Column(name = "num_ult_lote_lc")
	private Integer numUltLote;

	@Column(name = "num_folha_registr")
	private Integer numFolhaRegistr;

	@Column(name = "qtd_folhas_registr")
	private Integer qtdFolhasRegistr;

	@Column(name = "qtd_dias_atr_dupl")
	private Integer diasAtrDupl;

	@Column(name = "qtd_dias_atr_med")
	private Integer diasAtrMed;

	@Column(name = "num_ult_om")
	private Integer numUltOm;

	@Column(name = "val_min_om")
	private Integer valMinOm;

	@Column(name = "pct_comis")
	private Double pctComis;

	@Column(name = "pct_desc_financ")
	private Double pctDescFinanc;

	@Column(name = "pct_desc_adic")
	private Double pctDescAdic;

	@Column(name = "num_lote_ped")
	private Integer numLotePed;

	@Column(name = "mes_pedido")
	private Integer mesPedido;

	@Column(name = "ano_pedido")
	private Integer anoPedido;

	@Column(name = "cod_moeda")
	private Integer codMoeda;

	@Column(name = "cod_estoq_prod")
	private Integer codEstoqProd;

	@Column(name = "num_prx_pedido")
	private Integer numPrxPedido;

	@Column(name = "num_prx_cliente")
	private Integer numPrxCliente;

	@Column(name = "ies_dig_verif_cli", length = 1)
	private String iesDigVerifCli;

	@Column(name = "ies_dig_verif_ped", length = 1)
	private String iesDigVerifPed;

	@Column(name = "par_vdp_txt", length = 1)
	private String parVdpTxt;
	
	public ParVdp() {}
	
	public ParVdp(Integer numPrxPedido) {
		super();
		this.numPrxPedido = numPrxPedido;
	}

	public ParVdp(Integer numPrxPedido, Integer numUltOm) {
		super();
		this.numPrxPedido = numPrxPedido;
		this.numUltOm = numUltOm;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getMesEstoque() {
		return mesEstoque;
	}
	public void setMesEstoque(Integer mesEstoque) {
		this.mesEstoque = mesEstoque;
	}
	public Integer getAnoEstoque() {
		return anoEstoque;
	}
	public void setAnoEstoque(Integer anoEstoque) {
		this.anoEstoque = anoEstoque;
	}
	public Integer getNumNff() {
		return numNff;
	}
	public void setNumNff(Integer numNff) {
		this.numNff = numNff;
	}
	public Integer getMesFaturamento() {
		return mesFaturamento;
	}
	public void setMesFaturamento(Integer mesFaturamento) {
		this.mesFaturamento = mesFaturamento;
	}
	public Integer getAnoFaturamento() {
		return anoFaturamento;
	}
	public void setAnoFaturamento(Integer anoFaturamento) {
		this.anoFaturamento = anoFaturamento;
	}
	public Integer getQtdLinNff() {
		return qtdLinNff;
	}
	public void setQtdLinNff(Integer qtdLinNff) {
		this.qtdLinNff = qtdLinNff;
	}
	public Integer getNumUltLote() {
		return numUltLote;
	}
	public void setNumUltLote(Integer numUltLote) {
		this.numUltLote = numUltLote;
	}
	public Integer getNumFolhaRegistr() {
		return numFolhaRegistr;
	}
	public void setNumFolhaRegistr(Integer numFolhaRegistr) {
		this.numFolhaRegistr = numFolhaRegistr;
	}
	public Integer getQtdFolhasRegistr() {
		return qtdFolhasRegistr;
	}
	public void setQtdFolhasRegistr(Integer qtdFolhasRegistr) {
		this.qtdFolhasRegistr = qtdFolhasRegistr;
	}
	public Integer getDiasAtrDupl() {
		return diasAtrDupl;
	}
	public void setDiasAtrDupl(Integer diasAtrDupl) {
		this.diasAtrDupl = diasAtrDupl;
	}
	public Integer getDiasAtrMed() {
		return diasAtrMed;
	}
	public void setDiasAtrMed(Integer diasAtrMed) {
		this.diasAtrMed = diasAtrMed;
	}
	public Integer getNumUltOm() {
		return numUltOm;
	}
	public void setNumUltOm(Integer numUltOm) {
		this.numUltOm = numUltOm;
	}
	public Integer getValMinOm() {
		return valMinOm;
	}
	public void setValMinOm(Integer valMinOm) {
		this.valMinOm = valMinOm;
	}
	public Double getPctComis() {
		return pctComis;
	}
	public void setPctComis(Double pctComis) {
		this.pctComis = pctComis;
	}
	public Double getPctDescFinanc() {
		return pctDescFinanc;
	}
	public void setPctDescFinanc(Double pctDescFinanc) {
		this.pctDescFinanc = pctDescFinanc;
	}
	public Double getPctDescAdic() {
		return pctDescAdic;
	}
	public void setPctDescAdic(Double pctDescAdic) {
		this.pctDescAdic = pctDescAdic;
	}
	public Integer getNumLotePed() {
		return numLotePed;
	}
	public void setNumLotePed(Integer numLotePed) {
		this.numLotePed = numLotePed;
	}
	public Integer getMesPedido() {
		return mesPedido;
	}
	public void setMesPedido(Integer mesPedido) {
		this.mesPedido = mesPedido;
	}
	public Integer getAnoPedido() {
		return anoPedido;
	}
	public void setAnoPedido(Integer anoPedido) {
		this.anoPedido = anoPedido;
	}
	public Integer getCodMoeda() {
		return codMoeda;
	}
	public void setCodMoeda(Integer codMoeda) {
		this.codMoeda = codMoeda;
	}
	public Integer getCodEstoqProd() {
		return codEstoqProd;
	}
	public void setCodEstoqProd(Integer codEstoqProd) {
		this.codEstoqProd = codEstoqProd;
	}
	public Integer getNumPrxPedido() {
		return numPrxPedido;
	}
	public void setNumPrxPedido(Integer numPrxPedido) {
		this.numPrxPedido = numPrxPedido;
	}
	public Integer getNumPrxCliente() {
		return numPrxCliente;
	}
	public void setNumPrxCliente(Integer numPrxCliente) {
		this.numPrxCliente = numPrxCliente;
	}
	public String getIesDigVerifCli() {
		return iesDigVerifCli;
	}
	public void setIesDigVerifCli(String iesDigVerifCli) {
		this.iesDigVerifCli = iesDigVerifCli;
	}
	public String getIesDigVerifPed() {
		return iesDigVerifPed;
	}
	public void setIesDigVerifPed(String iesDigVerifPed) {
		this.iesDigVerifPed = iesDigVerifPed;
	}
	public String getParVdpTxt() {
		return parVdpTxt;
	}
	public void setParVdpTxt(String parVdpTxt) {
		this.parVdpTxt = parVdpTxt;
	}
	
}

