package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;

//colocando co cod_empresa como Id, então ao inserir na tabela
//é preciso passar um valor na chave que não existe na tabela e
//em seguida fazer updade para o valor correto.
//No dao:
@Modifying
@Transactional(readOnly=false)
@Query("UPDATE AuditLogix SET id = :id WHERE id = 'ZZ' ")
public void update(@Param("id") String id);
//pois foi inserido um registro com ZZ no cod_empresa.

@Entity
@Table(name = "audit_logix")
public class AuditLogix implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_empresa", length = 2)
	private String id;
	
	@Column(name = "texto", length = 200)
	private String texto;
	
	@Column(name = "num_programa", length = 10)
	private String programa;

	@Column(name = "data")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "hora", length = 8)
	private String hora;

	@Column(name = "usuario", length = 8)
	private String usuario;
	
	public AuditLogix() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}			
}
