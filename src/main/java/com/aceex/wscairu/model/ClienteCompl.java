package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vdp_cliente_compl")
public class ClienteCompl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cliente", length = 15)
	private String id;
	
	@Column(name = "email", length = 40)
	private String email;

	@Column(name = "email_secund", length = 40)
	private String emailSec;

	@Column(name = "endereco_web", length = 75)
	private String site;

	public ClienteCompl() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailSec() {
		return emailSec;
	}

	public void setEmailSec(String emailSec) {
		this.emailSec = emailSec;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
		
}
