package com.aceex.wscairu.dto;

import java.io.Serializable;

import com.aceex.wscairu.model.Aen;

public class CategoriaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String descricao;
	
	public CategoriaDto() {}
	
	public CategoriaDto(Aen obj) {
		this.codigo = obj.getId().getLinhaProd();
		this.descricao = obj.getDescricao();
	}
	
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
