package com.aceex.wscairu.dto;

import java.io.Serializable;

public class PedidoVdpDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cnpjEmpresa;
	private String cnpjCliente;
	private Integer natOperacao;
	private Integer finalidade;
	private Integer cndPgto;
	private Integer tipEntrega;
	private Integer tipVenda;
	private String tipCarteira;
	private Double descFinanc;
	private Double descAdic;
	private Double listPreco;
	private Double moeda;
	private String temComissao;
	private Double codRepres1;
	private Double pctComis1;
	private Double codRepres2;
	private Double pctComis2;
	private Double codRepres3;
	private Double pctComis3;
	private String pedidoRepres;
	private String pedidoCliente;
	private String datEmissao;
	private String codTranspor;
	private String codConsig;
	private Integer tipFrete;
	private Double pctFrete;
	private String tipEmbal;
	
	public PedidoVdpDto() { }
	
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public String getCnpjCliente() {
		return cnpjCliente;
	}
	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}
	public Integer getNatOperacao() {
		return natOperacao;
	}
	public void setNatOperacao(Integer natOperacao) {
		this.natOperacao = natOperacao;
	}
	public Integer getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(Integer finalidade) {
		this.finalidade = finalidade;
	}
	public Integer getCndPgto() {
		return cndPgto;
	}
	public void setCndPgto(Integer cndPgto) {
		this.cndPgto = cndPgto;
	}
	public Integer getTipEntrega() {
		return tipEntrega;
	}
	public void setTipEntrega(Integer tipEntrega) {
		this.tipEntrega = tipEntrega;
	}
	public Integer getTipVenda() {
		return tipVenda;
	}
	public void setTipVenda(Integer tipVenda) {
		this.tipVenda = tipVenda;
	}
	public String getTipCarteira() {
		return tipCarteira;
	}
	public void setTipCarteira(String tipCarteira) {
		this.tipCarteira = tipCarteira;
	}
	public Double getDescFinanc() {
		return descFinanc;
	}
	public void setDescFinanc(Double descFinanc) {
		this.descFinanc = descFinanc;
	}
	public Double getDescAdic() {
		return descAdic;
	}
	public void setDescAdic(Double descAdic) {
		this.descAdic = descAdic;
	}
	public Double getListPreco() {
		return listPreco;
	}
	public void setListPreco(Double listPreco) {
		this.listPreco = listPreco;
	}
	public Double getMoeda() {
		return moeda;
	}
	public void setMoeda(Double moeda) {
		this.moeda = moeda;
	}
	public String getTemComissao() {
		return temComissao;
	}
	public void setTemComissao(String temComissao) {
		this.temComissao = temComissao;
	}
	public Double getCodRepres1() {
		return codRepres1;
	}
	public void setCodRepres1(Double codRepres1) {
		this.codRepres1 = codRepres1;
	}
	public Double getPctComis1() {
		return pctComis1;
	}
	public void setPctComis1(Double pctComis1) {
		this.pctComis1 = pctComis1;
	}
	public Double getCodRepres2() {
		return codRepres2;
	}
	public void setCodRepres2(Double codRepres2) {
		this.codRepres2 = codRepres2;
	}
	public Double getPctComis2() {
		return pctComis2;
	}
	public void setPctComis2(Double pctComis2) {
		this.pctComis2 = pctComis2;
	}
	public Double getCodRepres3() {
		return codRepres3;
	}
	public void setCodRepres3(Double codRepres3) {
		this.codRepres3 = codRepres3;
	}
	public Double getPctComis3() {
		return pctComis3;
	}
	public void setPctComis3(Double pctComis3) {
		this.pctComis3 = pctComis3;
	}
	public String getPedidoRepres() {
		return pedidoRepres;
	}
	public void setPedidoRepres(String pedidoRepres) {
		this.pedidoRepres = pedidoRepres;
	}
	public String getPedidoCliente() {
		return pedidoCliente;
	}
	public void setPedidoCliente(String pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}
	public String getDatEmissao() {
		return datEmissao;
	}
	public void setDatEmissao(String datEmissao) {
		this.datEmissao = datEmissao;
	}
	public String getCodTranspor() {
		return codTranspor;
	}
	public void setCodTranspor(String codTranspor) {
		this.codTranspor = codTranspor;
	}
	public String getCodConsig() {
		return codConsig;
	}
	public void setCodConsig(String codConsig) {
		this.codConsig = codConsig;
	}
	public Integer getTipFrete() {
		return tipFrete;
	}
	public void setTipFrete(Integer tipFrete) {
		this.tipFrete = tipFrete;
	}
	public Double getPctFrete() {
		return pctFrete;
	}
	public void setPctFrete(Double pctFrete) {
		this.pctFrete = pctFrete;
	}
	public String getTipEmbal() {
		return tipEmbal;
	}
	public void setTipEmbal(String tipEmbal) {
		this.tipEmbal = tipEmbal;
	}

}
