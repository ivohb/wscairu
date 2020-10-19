package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "linha_prod")
public class LinhaProdKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_lin_prod")
	private Integer categoria;
	
	@Column(name = "cod_lin_recei")
	private Integer agrupamento;

	@Column(name = "cod_seg_merc")
	private Integer tamanho;

	@Column(name = "cod_cla_uso")
	private Integer cor;

	public LinhaProdKey() { }

	public LinhaProdKey(Integer categoria, Integer agrupamento, Integer tamanho, Integer cor) {
		super();
		this.categoria = categoria;
		this.agrupamento = agrupamento;
		this.tamanho = tamanho;
		this.cor = cor;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getAgrupamento() {
		return agrupamento;
	}

	public void setAgrupamento(Integer agrupamento) {
		this.agrupamento = agrupamento;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getCor() {
		return cor;
	}

	public void setCor(Integer cor) {
		this.cor = cor;
	}

}

