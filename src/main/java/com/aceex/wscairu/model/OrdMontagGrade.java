package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordem_montag_grade")
public class OrdMontagGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "num_reserva")
	private Integer id;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;

	@Column(name = "num_om", nullable = false)
	private Integer ordem;

	@Column(name = "num_pedido", nullable = false)
	private Integer pedido;

	@Column(name = "num_sequencia", nullable = false)
	private Integer sequencia;

	@Column(name = "cod_item", length = 2, nullable = false)
	private String item;

	@Column(name = "qtd_reservada", nullable = false)
	private Double qtdReservada;

	@Column(name = "cod_grade_1", length = 15)
	private String grade1;

	@Column(name = "cod_grade_2", length = 15)
	private String grade2;

	@Column(name = "cod_grade_3", length = 15)
	private String grade3;

	@Column(name = "cod_grade_4", length = 15)
	private String grade4;

	@Column(name = "cod_grade_5", length = 15)
	private String grade5;

	@Column(name = "cod_composicao", length = 10)
	private String composicao;
	
	public OrdMontagGrade() { }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Integer getPedido() {
		return pedido;
	}
	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getQtdReservada() {
		return qtdReservada;
	}
	public void setQtdReservada(Double qtdReservada) {
		this.qtdReservada = qtdReservada;
	}
	public String getGrade1() {
		return grade1;
	}
	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}
	public String getGrade2() {
		return grade2;
	}
	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}
	public String getGrade3() {
		return grade3;
	}
	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}
	public String getGrade4() {
		return grade4;
	}
	public void setGrade4(String grade4) {
		this.grade4 = grade4;
	}
	public String getGrade5() {
		return grade5;
	}
	public void setGrade5(String grade5) {
		this.grade5 = grade5;
	}
	public String getComposicao() {
		return composicao;
	}
	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}	
}
