package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.PedidoTextoKey;

@Entity
@Table(name = "ped_itens_texto")
public class PedidoTexto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoTextoKey id = new PedidoTextoKey();
	@Column(name = "den_texto_1", length = 76)
	private String txtPed1;
	@Column(name = "den_texto_2", length = 76)
	private String txtPed2;
	@Column(name = "den_texto_3", length = 76)
	private String txtPed3;
	@Column(name = "den_texto_4", length = 76)
	private String txtPed4;
	@Column(name = "den_texto_5", length = 76)
	private String txtPed5;
	
	public PedidoTexto() {}
	
	public PedidoTextoKey getId() {
		return id;
	}
	public void setId(PedidoTextoKey id) {
		this.id = id;
	}
	public String getTxtPed1() {
		return txtPed1;
	}
	public void setTxtPed1(String txtPed1) {
		this.txtPed1 = txtPed1;
	}
	public String getTxtPed2() {
		return txtPed2;
	}
	public void setTxtPed2(String txtPed2) {
		this.txtPed2 = txtPed2;
	}
	public String getTxtPed3() {
		return txtPed3;
	}
	public void setTxtPed3(String txtPed3) {
		this.txtPed3 = txtPed3;
	}
	public String getTxtPed4() {
		return txtPed4;
	}
	public void setTxtPed4(String txtPed4) {
		this.txtPed4 = txtPed4;
	}
	public String getTxtPed5() {
		return txtPed5;
	}
	public void setTxtPed5(String txtPed5) {
		this.txtPed5 = txtPed5;
	}
	
}
