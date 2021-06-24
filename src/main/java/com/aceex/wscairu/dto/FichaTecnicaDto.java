package com.aceex.wscairu.dto;

import java.io.Serializable;

import com.aceex.wscairu.model.FichaTecnica;

public class FichaTecnicaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String categoria;
	private String agrupamento;
	private String subAgrupamento;
	private String tamanho;
	private String cor;
	private String quadro;
	private String amortecTraseiro;
	private String suspensao;
	private String travaSuspensao;
	private String trocador;
	private String cambioTraseiro;
	private String cambioDianteiro;
	private String pedivela;
	private String casseteRodaLivre;
	private String corrente;
	private String alavancaFreio;
	private String freio;
	private String movimentCentral;
	private String cubo;
	private String pedal;
	private String guidao;
	private String mesa;
	private String canote;
	private String abracadeiraSelim;
	private String selim;
	private String pneus;
	private String raios;
	private String aros;
	private String peso;
	private String garantiaQuadro;
	private String garantiaCompon;

	public FichaTecnicaDto() { }

	public FichaTecnicaDto(FichaTecnica obj) { 
		this.categoria       = obj.getCategoria();
		this.agrupamento     = obj.getAgrupamento();
		this.subAgrupamento  = obj.getSubAgrupamento();
		this.tamanho         = obj.getTamanho();
		this.cor             = obj.getCor();
		this.quadro         = obj.getQuadro();
		this.amortecTraseiro = obj.getAmortecTraseiro();
		this.suspensao       = obj.getSuspensao();
		this.travaSuspensao  = obj.getTravaSuspensao();
		this.trocador        = obj.getTrocador();
		this.cambioTraseiro  = obj.getCambioTraseiro();
		this.cambioDianteiro = obj.getCambioDianteiro();
		this.pedivela        = obj.getPedivela();
		this.casseteRodaLivre= obj.getCasseteRodaLivre();
		this.corrente        = obj.getCorrente();
		this.alavancaFreio   = obj.getAlavancaFreio();
		this.freio           = obj.getFreio();
		this.movimentCentral = obj.getMovimentCentral();
		this.cubo            = obj.getCubo();
		this.pedal           = obj.getPedal();
		this.guidao          = obj.getGuidao();
		this.mesa            = obj.getMesa();
		this.canote          = obj.getCanote();
		this.abracadeiraSelim= obj.getAbracadeiraSelim();
		this.selim           = obj.getSelim();
		this.pneus           = obj.getPneus();
		this.raios           = obj.getRaios();
		this.aros            = obj.getAros();
		this.peso            = obj.getPeso();
		this.garantiaQuadro  = obj.getGarantiaQuadro();
		this.garantiaCompon  = obj.getGarantiaCompon(); 
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
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
		return trocador.trim();
	}
	public void setTrocador(String trocador) {
		this.trocador = trocador.trim();
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
