package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "est_loc_reser_end")
public class EstoqReserEndKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;
	
	@Column(name = "num_reserva", nullable = false)
	private Integer reserva;
	
	public EstoqReserEndKey() { }
	
	public EstoqReserEndKey(String empresa, Integer reserva) {
		super();
		this.empresa = empresa;
		this.reserva = reserva;
	}

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getReserva() {
		return reserva;
	}
	public void setReserva(Integer reserva) {
		this.reserva = reserva;
	}	
}
