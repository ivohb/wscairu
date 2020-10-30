package com.aceex.wscairu.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.aceex.wscairu.validation.ClienteValidation;

@ClienteValidation()
public class ClienteDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "campo_obrigatorio")
	private String cpfCnpj;

	@NotEmpty(message = "campo_obrigatorio")
	@Pattern(regexp="[FJ]", message = "conteudo_invalido")
	private String tipo;

	@NotEmpty(message = "campo_obrigatorio")
	private String razSocial;

	@NotEmpty(message = "campo_obrigatorio")
	private String nomeReduz;

	private String contato;

	@NotEmpty(message = "campo_obrigatorio")
	private String logradouro;

	private String bairro;

	private String cidadeIbge;

	@NotEmpty(message = "campo_obrigatorio")
	private String uf;

	private String inscEstadual;	
	private String cep;
	private String telefone;
	private String email;

	public ClienteDto() { }

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRazSocial() {
		return razSocial;
	}

	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial.trim();
	}

	public String getNomeReduz() {
		return nomeReduz;
	}

	public void setNomeReduz(String nomeReduz) {
		this.nomeReduz = nomeReduz.trim();
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato.trim();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.trim();
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.trim();
	}

	public String getCidadeIbge() {
		return cidadeIbge;
	}

	public void setCidadeIbge(String cidadeIbge) {
		this.cidadeIbge = cidadeIbge;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual.trim();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.trim();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}
		
}
