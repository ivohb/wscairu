package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedInfComMestKey;

@Entity
@Table(name = "ped_inf_com_mestre")
public class PedInfComMest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedInfComMestKey id = new PedInfComMestKey();

	@Column(name = "usuario", length = 8)
	private String usuario;

	@Column(name = "pedido_pallet", length = 1)
	private String pedidoPallet;

	@Column(name = "pct_tolera_minima")
	private Double pctTolMin;

	@Column(name = "pct_tolera_maxima")
	private Double pctTolMax;

	@Column(name = "nota_empenho", length = 10)
	private String notaEmpenho;

	@Column(name = "contrato_compra", length = 10)
	private String contratoCompra;

	@Column(name = "dat_min_fat")
	private Date datMinFat;

	@Column(name = "dat_inclusao")
	private Date datInclusao;

	@Column(name = "hor_inclusao", length = 8)
	private String horInclusao;

	@Column(name = "tip_importacao", length = 15)
	private String tipImportacao;

	@Column(name = "val_frete_sug")
	private Double valFreteSug;

	@Column(name = "regra_cotacao", length = 2)
	private String regraCotacao;

	@Column(name = "val_cotacao_fixa")
	private Double valCotacaoFixa;

	@Column(name = "data_vigencia")
	private Date datVigencia;
	
	public PedInfComMest() {}
	
	public PedInfComMestKey getId() {
		return id;
	}
	public void setId(PedInfComMestKey id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPedidoPallet() {
		return pedidoPallet;
	}
	public void setPedidoPallet(String pedidoPallet) {
		this.pedidoPallet = pedidoPallet;
	}
	public Double getPctTolMin() {
		return pctTolMin;
	}
	public void setPctTolMin(Double pctTolMin) {
		this.pctTolMin = pctTolMin;
	}
	public Double getPctTolMax() {
		return pctTolMax;
	}
	public void setPctTolMax(Double pctTolMax) {
		this.pctTolMax = pctTolMax;
	}
	public String getNotaEmpenho() {
		return notaEmpenho;
	}
	public void setNotaEmpenho(String notaEmpenho) {
		this.notaEmpenho = notaEmpenho;
	}
	public String getContratoCompra() {
		return contratoCompra;
	}
	public void setContratoCompra(String contratoCompra) {
		this.contratoCompra = contratoCompra;
	}
	public Date getDatMinFat() {
		return datMinFat;
	}
	public void setDatMinFat(Date datMinFat) {
		this.datMinFat = datMinFat;
	}
	public Date getDatInclusao() {
		return datInclusao;
	}
	public void setDatInclusao(Date datInclusao) {
		this.datInclusao = datInclusao;
	}
	public String getHorInclusao() {
		return horInclusao;
	}
	public void setHorInclusao(String horInclusao) {
		this.horInclusao = horInclusao;
	}
	public String getTipImportacao() {
		return tipImportacao;
	}
	public void setTipImportacao(String tipImportacao) {
		this.tipImportacao = tipImportacao;
	}
	public Double getValFreteSug() {
		return valFreteSug;
	}
	public void setValFreteSug(Double valFreteSug) {
		this.valFreteSug = valFreteSug;
	}
	public String getRegraCotacao() {
		return regraCotacao;
	}
	public void setRegraCotacao(String regraCotacao) {
		this.regraCotacao = regraCotacao;
	}
	public Double getValCotacaoFixa() {
		return valCotacaoFixa;
	}
	public void setValCotacaoFixa(Double valCotacaoFixa) {
		this.valCotacaoFixa = valCotacaoFixa;
	}
	public Date getDatVigencia() {
		return datVigencia;
	}
	public void setDatVigencia(Date datVigencia) {
		this.datVigencia = datVigencia;
	}
		
}
               
