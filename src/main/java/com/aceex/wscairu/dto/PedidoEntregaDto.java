package com.aceex.wscairu.dto;

import java.io.Serializable;

public class PedidoEntregaDto implements Serializable {
	private static final long serialVersionUID = 1L;


	private String endereco;
	private String bairro;
	private String cidade;
	private String cepEntrega;
	private String ufEntrega;
	private String cnpjEntrga;
	private String inscEstadual;
	
	public PedidoEntregaDto() { }
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCepEntrega() {
		return cepEntrega;
	}
	public void setCepEntrega(String cepEntrega) {
		this.cepEntrega = cepEntrega;
	}
	public String getUfEntrega() {
		return ufEntrega;
	}
	public void setUfEntrega(String ufEntrega) {
		this.ufEntrega = ufEntrega;
	}
	public String getCnpjEntrga() {
		return cnpjEntrga;
	}
	public void setCnpjEntrga(String cnpjEntrga) {
		this.cnpjEntrga = cnpjEntrga;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

}
