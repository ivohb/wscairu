package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estoque_lote_ender")
public class EstoqLoteEnder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "num_transac")
	private Integer id;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "cod_local", length = 10, nullable = false)
	private String local;

	@Column(name = "num_lote", length = 15)
	private String lote;

	@Column(name = "ies_situa_qtd", length = 1, nullable = false)
	private String situacao;

	@Column(name = "ies_origem_entrada", length = 1, nullable = false)
	private String origem;

	@Column(name = "qtd_saldo", nullable = false)
	private Double saldo;

	@Column(name = "endereco", length = 15, nullable = false)
	private String endereco;

	@Column(name = "num_volume", nullable = false)
	private Integer volume;

	@Column(name = "cod_grade_1", length = 15, nullable = false)
	private String grade1;

	@Column(name = "cod_grade_2", length = 15, nullable = false)
	private String grade2;

	@Column(name = "cod_grade_3", length = 15, nullable = false)
	private String grade3;

	@Column(name = "cod_grade_4", length = 15, nullable = false)
	private String grade4;

	@Column(name = "cod_grade_5", length = 15, nullable = false)
	private String grade5;

	@Column(name = "dat_hor_producao", nullable = false)
	private Date datProducao;

	@Column(name = "num_ped_ven", nullable = false)
	private Integer pedVenda;

	@Column(name = "num_seq_ped_ven", nullable = false)
	private Integer seqPedVenda;

	@Column(name = "dat_hor_validade", nullable = false)
	private Date datValidade;

	@Column(name = "num_peca", length = 15, nullable = false)
	private String numPeca;

	@Column(name = "num_serie", length = 25, nullable = false)
	private String numSerie;

	@Column(name = "comprimento", nullable = false)
	private Integer comprimento;

	@Column(name = "largura", nullable = false)
	private Integer largura;

	@Column(name = "altura", nullable = false)
	private Integer altura;

	@Column(name = "diametro", nullable = false)
	private Integer diametro;

	@Column(name = "dat_hor_reserv_1", nullable = false)
	private Date datReser1;

	@Column(name = "dat_hor_reserv_2", nullable = false)
	private Date datReser2;

	@Column(name = "dat_hor_reserv_3", nullable = false)
	private Date datReser3;

	@Column(name = "qtd_reserv_1", nullable = false)
	private Double qtdReser1;

	@Column(name = "qtd_reserv_2", nullable = false)
	private Double qtdReser2;

	@Column(name = "qtd_reserv_3", nullable = false)
	private Double qtdReser3;

	@Column(name = "num_reserv_1", nullable = false)
	private Double numReser1;

	@Column(name = "num_reserv_2", nullable = false)
	private Double numReser2;

	@Column(name = "num_reserv_3", nullable = false)
	private Double numReser3;

	@Column(name = "tex_reservado", length = 100, nullable = false)
	private String texReservado;

	@Column(name = "identif_estoque", length = 30)
	private String idEstoque;

	@Column(name = "deposit", length = 15)
	private String deposit;	
	
	public EstoqLoteEnder() { }
	
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
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
	public Date getDatProducao() {
		return datProducao;
	}
	public void setDatProducao(Date datProducao) {
		this.datProducao = datProducao;
	}
	public Integer getPedVenda() {
		return pedVenda;
	}
	public void setPedVenda(Integer pedVenda) {
		this.pedVenda = pedVenda;
	}
	public Integer getSeqPedVenda() {
		return seqPedVenda;
	}
	public void setSeqPedVenda(Integer seqPedVenda) {
		this.seqPedVenda = seqPedVenda;
	}
	public Date getDatValidade() {
		return datValidade;
	}
	public void setDatValidade(Date datValidade) {
		this.datValidade = datValidade;
	}
	public String getNumPeca() {
		return numPeca;
	}
	public void setNumPeca(String numPeca) {
		this.numPeca = numPeca;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public Integer getComprimento() {
		return comprimento;
	}
	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}
	public Integer getLargura() {
		return largura;
	}
	public void setLargura(Integer largura) {
		this.largura = largura;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Integer getDiametro() {
		return diametro;
	}
	public void setDiametro(Integer diametro) {
		this.diametro = diametro;
	}
	public Date getDatReser1() {
		return datReser1;
	}
	public void setDatReser1(Date datReser1) {
		this.datReser1 = datReser1;
	}
	public Date getDatReser2() {
		return datReser2;
	}
	public void setDatReser2(Date datReser2) {
		this.datReser2 = datReser2;
	}
	public Date getDatReser3() {
		return datReser3;
	}
	public void setDatReser3(Date datReser3) {
		this.datReser3 = datReser3;
	}
	public Double getQtdReser1() {
		return qtdReser1;
	}
	public void setQtdReser1(Double qtdReser1) {
		this.qtdReser1 = qtdReser1;
	}
	public Double getQtdReser2() {
		return qtdReser2;
	}
	public void setQtdReser2(Double qtdReser2) {
		this.qtdReser2 = qtdReser2;
	}
	public Double getQtdReser3() {
		return qtdReser3;
	}
	public void setQtdReser3(Double qtdReser3) {
		this.qtdReser3 = qtdReser3;
	}
	public Double getNumReser1() {
		return numReser1;
	}
	public void setNumReser1(Double numReser1) {
		this.numReser1 = numReser1;
	}
	public Double getNumReser2() {
		return numReser2;
	}
	public void setNumReser2(Double numReser2) {
		this.numReser2 = numReser2;
	}
	public Double getNumReser3() {
		return numReser3;
	}
	public void setNumReser3(Double numReser3) {
		this.numReser3 = numReser3;
	}
	public String getTexReservado() {
		return texReservado;
	}
	public void setTexReservado(String texReservado) {
		this.texReservado = texReservado;
	}
	public String getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(String idEstoque) {
		this.idEstoque = idEstoque;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	
}
