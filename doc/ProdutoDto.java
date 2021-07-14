package com.aceex.wscairu.dto;

import java.io.Serializable;

public class ProdutoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cnpjEmpresa;
	private String codEmpresa;
	private Integer ean;
	private String codigo;
	private String descricao;
	private String descReduz;
	private String unidade;
	private Double preco;
	private String descTecnica;
	private Integer categoria;
	private String descCategoria;
	private Integer agrupamento;
	private String descAgrupamento;
	private Integer tamanho;
	private String descTamanho;
	private Integer cor;
	private String descCor;	
	private Double liberado;
	private Double reservada;	
	private Double disponivel;	
	
	public ProdutoDto() { }
	
	public ProdutoDto(Integer ean, String codEmpresa, String codigo, 
			String descricao, String descReduz, String unidade, String descTecnica,
			Integer categoria, Integer agrupamento, Integer tamanho, Integer cor,
			Double liberado, Double reservada) {
		super();
		this.ean = ean;
		this.codEmpresa = codEmpresa;
		this.codigo = codigo;
		this.descricao = descricao;
		this.descReduz = descReduz;
		this.unidade = unidade;
		this.descTecnica = descTecnica;
		this.categoria = categoria;
		this.agrupamento = agrupamento;
		this.tamanho = tamanho;
		this.cor = cor;
		this.liberado = liberado;
		this.reservada = reservada;
	}


	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public Integer getEan() {
		return ean;
	}
	public void setEan(Integer ean) {
		this.ean = ean;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescReduz() {
		return descReduz;
	}
	public void setDescReduz(String descReduz) {
		this.descReduz = descReduz;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getDescTecnica() {
		return descTecnica;
	}
	public void setDescTecnica(String descTecnica) {
		this.descTecnica = descTecnica;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public String getDescCategoria() {
		return descCategoria;
	}
	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}
	public Integer getAgrupamento() {
		return agrupamento;
	}
	public void setAgrupamento(Integer agrupamento) {
		this.agrupamento = agrupamento;
	}
	public String getDescAgrupamento() {
		return descAgrupamento;
	}
	public void setDescAgrupamento(String descAgrupamento) {
		this.descAgrupamento = descAgrupamento;
	}
	public Integer getTamanho() {
		return tamanho;
	}
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	public String getDescTamanho() {
		return descTamanho;
	}
	public void setDescTamanho(String descTamanho) {
		this.descTamanho = descTamanho;
	}
	public Integer getCor() {
		return cor;
	}
	public void setCor(Integer cor) {
		this.cor = cor;
	}
	public String getDescCor() {
		return descCor;
	}
	public void setDescCor(String descCor) {
		this.descCor = descCor;
	}
	public Double getLiberado() {
		return liberado;
	}
	public void setLiberado(Double liberado) {
		this.liberado = liberado;
	}
	public Double getReservada() {
		return reservada;
	}
	public void setReservada(Double reservada) {
		this.reservada = reservada;
	}
	public Double getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(Double disponivel) {
		this.disponivel = disponivel;
	}
	
}

