package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.ItemKey;


@Entity
@Table(name = "item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemKey id = new ItemKey();

	@Column(name = "den_item", length = 76)
	private String descricao;

	@Column(name = "den_item_reduz", length = 76)
	private String descReduz;

	@Column(name = "cod_unid_med", length = 3)
	private String unidade;

	@Column(name = "cod_lin_prod")
	private Integer categoria;

	@Column(name = "cod_lin_recei")
	private Integer agrupamento;

	@Column(name = "cod_seg_merc")
	private Integer tamanho;
	
	@Column(name = "cod_cla_uso")
	private Integer cor;

	@Column(name = "ies_situacao", length = 1)
	private String situacao;

	public Item() { }

	public ItemKey getId() {
		return id;
	}

	public void setId(ItemKey id) {
		this.id = id;
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
