package com.aceex.wscairu.dto;
import java.io.Serializable;

public class CredenciaisDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String senha;
	private String empresa;
	
	public CredenciaisDto() {}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
}
