package com.aceex.wscairu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "desc_preco_item")
public class ListaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "num_transacao")
	private Integer id;	
	@Column(name = "cod_empresa", length = 2)
	private String empresa;
	@Column(name = "num_list_preco")
	private Integer numero;
	@Column(name = "cod_uni_feder", length = 2)
	private String uf;
	@Column(name = "cod_cliente", length = 15)
	private String cliente;
	@Column(name = "cod_lin_prod")
	private Integer linProd;
	@Column(name = "cod_lin_recei")
	private Integer linRecei;
	@Column(name = "cod_seg_merc")
	private Integer segMerc;
	@Column(name = "cod_cla_uso")
	private Integer claUso;
	@Column(name = "cod_item", length = 15)
	private String item;
	@Column(name = "pre_unit")
	private Double preUnit;
	@Column(name = "pct_desc")
	private Double pctDesc;
	@Column(name = "pct_desc_adic")
	private Double pctDescAdic;
	@Column(name = "cod_grupo", length = 2)
	private String codGrupo;
	@Column(name = "cod_acabam", length = 2)
	private String codAcabam;
	@Column(name = "cod_cnd_pgto")
	private Double codPgto;
	@Column(name = "pre_unit_adic")
	private Double preUnitAdic;
	@Column(name = "pre_unit_ant")
	private Double preUnitAnt;
	@Column(name = "pre_unit_adic_ant")
	private Double preUnitAdicAnt;
	
	public ListaItem() {}		
	
	public ListaItem(Double preUnit) {
		super();
		this.preUnit = preUnit;
	}

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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Integer getLinProd() {
		return linProd;
	}
	public void setLinProd(Integer linProd) {
		this.linProd = linProd;
	}
	public Integer getLinRecei() {
		return linRecei;
	}
	public void setLinRecei(Integer linRecei) {
		this.linRecei = linRecei;
	}
	public Integer getSegMerc() {
		return segMerc;
	}
	public void setSegMerc(Integer segMerc) {
		this.segMerc = segMerc;
	}
	public Integer getClaUso() {
		return claUso;
	}
	public void setClaUso(Integer claUso) {
		this.claUso = claUso;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getPreUnit() {
		return preUnit;
	}
	public void setPreUnit(Double preUnit) {
		this.preUnit = preUnit;
	}
	public Double getPctDesc() {
		return pctDesc;
	}
	public void setPctDesc(Double pctDesc) {
		this.pctDesc = pctDesc;
	}
	public Double getPctDescAdic() {
		return pctDescAdic;
	}
	public void setPctDescAdic(Double pctDescAdic) {
		this.pctDescAdic = pctDescAdic;
	}
	public String getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}
	public String getCodAcabam() {
		return codAcabam;
	}
	public void setCodAcabam(String codAcabam) {
		this.codAcabam = codAcabam;
	}
	public Double getCodPgto() {
		return codPgto;
	}
	public void setCodPgto(Double codPgto) {
		this.codPgto = codPgto;
	}
	public Double getPreUnitAdic() {
		return preUnitAdic;
	}
	public void setPreUnitAdic(Double preUnitAdic) {
		this.preUnitAdic = preUnitAdic;
	}
	public Double getPreUnitAnt() {
		return preUnitAnt;
	}
	public void setPreUnitAnt(Double preUnitAnt) {
		this.preUnitAnt = preUnitAnt;
	}
	public Double getPreUnitAdicAnt() {
		return preUnitAdicAnt;
	}
	public void setPreUnitAdicAnt(Double preUnitAdicAnt) {
		this.preUnitAdicAnt = preUnitAdicAnt;
	}
	
}


