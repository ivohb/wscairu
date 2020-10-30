package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "par_api_cairu")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cnpj_empresa", length = 19)
	private String id;

	@Column(name = "pct_comissao")
	private Double pctComissao;
	@Column(name = "cod_nat_oper")
	private Integer natOper;
	@Column(name = "ies_finalidade")
	private Double finalidade;
	@Column(name = "ies_frete")
	private Double tipFrete;
	@Column(name = "ies_preco", length = 1 )
	private String tipPreco;
	@Column(name = "cod_cnd_pgto")
	private Double codPgto;
	@Column(name = "ies_embal_padrao", length = 1 )
	private String embalPadrao;
	@Column(name = "ies_tip_entrega")
	private Double tipEntrega;
	@Column(name = "ies_sit_pedido", length = 1 )
	private String situacao;
	@Column(name = "num_list_preco")
	private Integer lista;
	@Column(name = "cod_repres")
	private Double representante;
	@Column(name = "cod_tip_venda")
	private Double tipVenda;
	@Column(name = "cod_moeda")
	private Double moeda;
	@Column(name = "ies_comissao", length = 1)
	private String temComissao;
	@Column(name = "cod_tip_carteira", length = 2)
	private String carteira;
	@Column(name = "cod_local_estoq", length = 10)
	private String localEstoque;
	@Column(name = "bloqueio_estoque", length = 1)
	private String bloqEstoque;
	
	public Parametro() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPctComissao() {
		return pctComissao;
	}
	public void setPctComissao(Double pctComissao) {
		this.pctComissao = pctComissao;
	}
	public Integer getNatOper() {
		return natOper;
	}
	public void setNatOper(Integer natOper) {
		this.natOper = natOper;
	}
	public Double getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(Double finalidade) {
		this.finalidade = finalidade;
	}
	public Double getTipFrete() {
		return tipFrete;
	}
	public void setTipFrete(Double tipFrete) {
		this.tipFrete = tipFrete;
	}
	public String getTipPreco() {
		return tipPreco;
	}
	public void setTipPreco(String tipPreco) {
		this.tipPreco = tipPreco;
	}
	public Double getCodPgto() {
		return codPgto;
	}
	public void setCodPgto(Double codPgto) {
		this.codPgto = codPgto;
	}
	public String getEmbalPadrao() {
		return embalPadrao;
	}
	public void setEmbalPadrao(String embalPadrao) {
		this.embalPadrao = embalPadrao;
	}
	public Double getTipEntrega() {
		return tipEntrega;
	}
	public void setTipEntrega(Double tipEntrega) {
		this.tipEntrega = tipEntrega;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Integer getLista() {
		return lista;
	}
	public void setLista(Integer lista) {
		this.lista = lista;
	}
	public Double getRepresentante() {
		return representante;
	}
	public void setRepresentante(Double representante) {
		this.representante = representante;
	}
	public Double getTipVenda() {
		return tipVenda;
	}
	public void setTipVenda(Double tipVenda) {
		this.tipVenda = tipVenda;
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
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public String getLocalEstoque() {
		return localEstoque;
	}
	public void setLocalEstoque(String localEstoque) {
		this.localEstoque = localEstoque;
	}
	public String getBloqEstoque() {
		return bloqEstoque;
	}
	public void setBloqEstoque(String bloqEstoque) {
		this.bloqEstoque = bloqEstoque;
	}
}
