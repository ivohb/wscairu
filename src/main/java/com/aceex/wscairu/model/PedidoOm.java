package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido_om")
public class PedidoOm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "num_pedido", nullable = false)
	private Integer numPedido; 

	@Column(name = "num_om", nullable = false)
	private Integer numOm; 

	@Column(name = "dat_geracao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data; 
	
	public PedidoOm() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}
	public Integer getNumOm() {
		return numOm;
	}
	public void setNumOm(Integer numOm) {
		this.numOm = numOm;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
