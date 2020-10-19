package com.aceex.wscairu.dto;

import java.io.Serializable;

public class Tamanho implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String descricao;
	
	public Tamanho() {}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}		
}
