package com.aceex.wscairu.dto;

import java.io.Serializable;

public class ItemDto implements Serializable {
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
	private Integer revisao;
	private Categoria categoria;
	private Agrupamento agrupamento;
	private Tamanho tamanho;
	private Cor cor;
	private Saldo estoque;
	private FichaTecnicaDto fichaTecnica;
	
	public ItemDto() { }

	public ItemDto(Integer ean, String codEmpresa, String codigo, 
			String descricao, String descReduz, String unidade) {
		super();
		this.ean = ean;
		this.codEmpresa = codEmpresa;
		this.codigo = codigo;
		this.descricao = descricao;
		this.descReduz = descReduz;
		this.unidade = unidade;
	}

	public ItemDto(Integer ean, String codEmpresa, String codigo, 
			String descricao, String descReduz, String unidade, String descTecnica) {
		super();
		this.ean = ean;
		this.codEmpresa = codEmpresa;
		this.codigo = codigo;
		this.descricao = descricao;
		this.descReduz = descReduz;
		this.unidade = unidade;
		this.descTecnica = descTecnica;
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

	public Integer getRevisao() {
		return revisao;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Agrupamento getAgrupamento() {
		return agrupamento;
	}

	public void setAgrupamento(Agrupamento agrupamento) {
		this.agrupamento = agrupamento;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Saldo getEstoque() {
		return estoque;
	}

	public void setEstoque(Saldo estoque) {
		this.estoque = estoque;
	}

	public FichaTecnicaDto getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(FichaTecnicaDto fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	
}

