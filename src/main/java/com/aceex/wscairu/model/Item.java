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

	@Column(name = "cod_local_estoq", length = 10)
	private String localEstoq;

	@Column(name = "pes_unit")
	private Double peso;

	@Column(name = "cod_lin_prod")
	private Integer categoria;

	@Column(name = "cod_lin_recei")
	private Integer modelo;

	@Column(name = "cod_seg_merc")
	private Integer tamanho;
	
	@Column(name = "cod_cla_uso")
	private Integer cor;

	@Column(name = "ies_situacao", length = 1)
	private String situacao;
	
	public Item() { }
	
	public Item(String unidade, String localEstoq) {
		super();
		this.unidade = unidade;
		this.localEstoq = localEstoq;
	}

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
	public String getLocalEstoq() {
		return localEstoq;
	}
	public void setLocalEstoq(String localEstoq) {
		this.localEstoq = localEstoq;
	}	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
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
