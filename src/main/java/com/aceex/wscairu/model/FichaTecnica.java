package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.FichaTecnicalKey;

@Entity
@Table(name = "item_compl_cairu")
public class FichaTecnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FichaTecnicalKey id = new FichaTecnicalKey();

	@Column(name = "agrupamento", length = 40)
	private String agrupamento;

	@Column(name = "sub_agrup", length = 40)
	private String subAgrupamento;

	@Column(name = "quadro", length = 160)
	private String quadro;

	@Column(name = "amortecedor_traseiro", length = 80)
	private String amortecTraseiro;
	
	@Column(name = "suspensao_garfo", length = 160)
	private String suspensao;

	@Column(name = "trava_de_suspensao", length = 80)
	private String travaSuspensao;

	@Column(name = "trocador", length = 80)
	private String trocador;

	@Column(name = "cambio_traseiro", length = 80)
	private String cambioTraseiro;

	@Column(name = "cambio_dianteiro", length = 80)
	private String cambioDianteiro;

	@Column(name = "pedivela", length = 80)
	private String pedivela;
	
	@Column(name = "cassete_roda_livre", length = 80)
	private String casseteRodaLivre;

	@Column(name = "corrente", length = 80)
	private String corrente;

	@Column(name = "alavanca_de_freio", length = 80)
	private String alavancaFreio;

	@Column(name = "freio", length = 80)
	private String freio;

	@Column(name = "movimento_central", length = 80)
	private String movimentCentral;

	@Column(name = "cubo", length = 80)
	private String cubo;

	@Column(name = "pedal", length = 80)
	private String pedal;

	@Column(name = "guidao", length = 80)
	private String guidao;

	@Column(name = "mesa", length = 80)
	private String mesa;
	
	@Column(name = "canote", length = 80)
	private String canote;
	
	@Column(name = "abracadeira_de_selim", length = 80)
	private String abracadeiraSelim;
	
	@Column(name = "selim", length = 80)
	private String selim;

	@Column(name = "pneus", length = 80)
	private String pneus;

	@Column(name = "raios", length = 80)
	private String raios;

	@Column(name = "aros", length = 80)
	private String aros;

	@Column(name = "peso", length = 80)
	private String peso;

	@Column(name = "garantia_quadro", length = 80)
	private String garantiaQuadro;

	@Column(name = "garantia_componentes", length = 80)
	private String garantiaCompon;
	public FichaTecnica() { }
	public FichaTecnicalKey getId() {
		return id;
	}
	public void setId(FichaTecnicalKey id) {
		this.id = id;
	}
	public String getAgrupamento() {
		return agrupamento;
	}
	public void setAgrupamento(String agrupamento) {
		this.agrupamento = agrupamento;
	}
	public String getSubAgrupamento() {
		return subAgrupamento;
	}
	public void setSubAgrupamento(String subAgrupamento) {
		this.subAgrupamento = subAgrupamento;
	}
	public String getQuadro() {
		return quadro;
	}
	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}
	public String getAmortecTraseiro() {
		return amortecTraseiro;
	}
	public void setAmortecTraseiro(String amortecTraseiro) {
		this.amortecTraseiro = amortecTraseiro;
	}
	public String getSuspensao() {
		return suspensao;
	}
	public void setSuspensao(String suspensao) {
		this.suspensao = suspensao;
	}
	public String getTravaSuspensao() {
		return travaSuspensao;
	}
	public void setTravaSuspensao(String travaSuspensao) {
		this.travaSuspensao = travaSuspensao;
	}
	public String getTrocador() {
		return trocador;
	}
	public void setTrocador(String trocador) {
		this.trocador = trocador;
	}
	public String getCambioTraseiro() {
		return cambioTraseiro;
	}
	public void setCambioTraseiro(String cambioTraseiro) {
		this.cambioTraseiro = cambioTraseiro;
	}
	public String getCambioDianteiro() {
		return cambioDianteiro;
	}
	public void setCambioDianteiro(String cambioDianteiro) {
		this.cambioDianteiro = cambioDianteiro;
	}
	public String getPedivela() {
		return pedivela;
	}
	public void setPedivela(String pedivela) {
		this.pedivela = pedivela;
	}
	public String getCasseteRodaLivre() {
		return casseteRodaLivre;
	}
	public void setCasseteRodaLivre(String casseteRodaLivre) {
		this.casseteRodaLivre = casseteRodaLivre;
	}
	public String getCorrente() {
		return corrente;
	}
	public void setCorrente(String corrente) {
		this.corrente = corrente;
	}
	public String getAlavancaFreio() {
		return alavancaFreio;
	}
	public void setAlavancaFreio(String alavancaFreio) {
		this.alavancaFreio = alavancaFreio;
	}
	public String getFreio() {
		return freio;
	}
	public void setFreio(String freio) {
		this.freio = freio;
	}
	public String getMovimentCentral() {
		return movimentCentral;
	}
	public void setMovimentCentral(String movimentCentral) {
		this.movimentCentral = movimentCentral;
	}
	public String getCubo() {
		return cubo;
	}
	public void setCubo(String cubo) {
		this.cubo = cubo;
	}
	public String getPedal() {
		return pedal;
	}
	public void setPedal(String pedal) {
		this.pedal = pedal;
	}
	public String getGuidao() {
		return guidao;
	}
	public void setGuidao(String guidao) {
		this.guidao = guidao;
	}
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	public String getCanote() {
		return canote;
	}
	public void setCanote(String canote) {
		this.canote = canote;
	}
	public String getAbracadeiraSelim() {
		return abracadeiraSelim;
	}
	public void setAbracadeiraSelim(String abracadeiraSelim) {
		this.abracadeiraSelim = abracadeiraSelim;
	}
	public String getSelim() {
		return selim;
	}
	public void setSelim(String selim) {
		this.selim = selim;
	}
	public String getPneus() {
		return pneus;
	}
	public void setPneus(String pneus) {
		this.pneus = pneus;
	}
	public String getRaios() {
		return raios;
	}
	public void setRaios(String raios) {
		this.raios = raios;
	}
	public String getAros() {
		return aros;
	}
	public void setAros(String aros) {
		this.aros = aros;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getGarantiaQuadro() {
		return garantiaQuadro;
	}
	public void setGarantiaQuadro(String garantiaQuadro) {
		this.garantiaQuadro = garantiaQuadro;
	}
	public String getGarantiaCompon() {
		return garantiaCompon;
	}
	public void setGarantiaCompon(String garantiaCompon) {
		this.garantiaCompon = garantiaCompon;
	}
	
}
