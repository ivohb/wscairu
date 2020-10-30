package com.aceex.wscairu.dto;

import java.io.Serializable;

public class PedidoItemDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private Double quantidade;
	private String datEntrega;
	private Double preUnit;
	private String txtProd1;
	private String txtProd2;
	private String txtProd3;
	private String txtProd4;
	private String txtProd5;

	public PedidoItemDto() { }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getDatEntrega() {
		return datEntrega;
	}

	public void setDatEntrega(String datEntrega) {
		this.datEntrega = datEntrega;
	}

	public Double getPreUnit() {
		return preUnit;
	}

	public void setPreUnit(Double preUnit) {
		this.preUnit = preUnit;
	}

	public String getTxtProd1() {
		return txtProd1;
	}

	public void setTxtProd1(String txtProd1) {
		this.txtProd1 = txtProd1;
	}

	public String getTxtProd2() {
		return txtProd2;
	}

	public void setTxtProd2(String txtProd2) {
		this.txtProd2 = txtProd2;
	}

	public String getTxtProd3() {
		return txtProd3;
	}

	public void setTxtProd3(String txtProd3) {
		this.txtProd3 = txtProd3;
	}

	public String getTxtProd4() {
		return txtProd4;
	}

	public void setTxtProd4(String txtProd4) {
		this.txtProd4 = txtProd4;
	}

	public String getTxtProd5() {
		return txtProd5;
	}

	public void setTxtProd5(String txtProd5) {
		this.txtProd5 = txtProd5;
	}
	
}
