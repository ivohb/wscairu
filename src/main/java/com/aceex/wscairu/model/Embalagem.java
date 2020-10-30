package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "embalagem")
public class Embalagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_embal", length = 3)
	private String id;

	@Column(name = "den_embal", length = 26, nullable = false)
	private String descricao;

	@Column(name = "pes_unit", nullable = false)
	private Double pesUnit;

	@Column(name = "ies_etiqueta_exp", length = 1, nullable = false)
	private String iesEtiqueta;

	@Column(name = "cod_embal_matriz", length = 3)
	private String codMatriz;

	@Column(name = "altura")
	private Integer altura;

	@Column(name = "largura")
	private Integer largura;

	@Column(name = "profundidade")
	private Integer profundidade;

	@Column(name = "cod_tipo_embal")
	private Integer tipo;

	@Column(name = "volume")
	private Integer volume;

	@Column(name = "area")
	private Integer area;

	@Column(name = "preco_unit_us")
	private Double precoUs;

	@Column(name = "cod_nbm")
	private Integer codNbm;
	
	public Embalagem() { }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPesUnit() {
		return pesUnit;
	}
	public void setPesUnit(Double pesUnit) {
		this.pesUnit = pesUnit;
	}
	public String getIesEtiqueta() {
		return iesEtiqueta;
	}
	public void setIesEtiqueta(String iesEtiqueta) {
		this.iesEtiqueta = iesEtiqueta;
	}
	public String getCodMatriz() {
		return codMatriz;
	}
	public void setCodMatriz(String codMatriz) {
		this.codMatriz = codMatriz;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Integer getLargura() {
		return largura;
	}
	public void setLargura(Integer largura) {
		this.largura = largura;
	}
	public Integer getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(Integer profundidade) {
		this.profundidade = profundidade;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Double getPrecoUs() {
		return precoUs;
	}
	public void setPrecoUs(Double precoUs) {
		this.precoUs = precoUs;
	}
	public Integer getCodNbm() {
		return codNbm;
	}
	public void setCodNbm(Integer codNbm) {
		this.codNbm = codNbm;
	}
	
}
