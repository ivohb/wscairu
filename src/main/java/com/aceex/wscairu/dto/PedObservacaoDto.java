package com.aceex.wscairu.dto;

import java.io.Serializable;

public class PedObservacaoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String txtObs1;
	private String txtObs2;
	
	public PedObservacaoDto() { }
	
	public String getTxtObs1() {
		return txtObs1;
	}
	public void setTxtObs1(String txtObs1) {
		this.txtObs1 = txtObs1;
	}
	public String getTxtObs2() {
		return txtObs2;
	}
	public void setTxtObs2(String txtObs2) {
		this.txtObs2 = txtObs2;
	}
	
}
