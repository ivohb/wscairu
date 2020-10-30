package com.aceex.wscairu.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ordem_montag_item")
public class OrdMontagItemKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "cod_empresa", length = 2, nullable = false)
	private String empresa;
	
	@Column(name = "num_om", nullable = false)
	private Integer ordem;

	@Column(name = "num_pedido", nullable = false)
	private Integer pedido;

	@Column(name = "num_sequencia", nullable = false)
	private Integer sequencia;

	@Column(name = "cod_item", length = 15, nullable = false)
	private String item;

	@Column(name = "ies_bonificacao", length = 1, nullable = false)
	private String bonificacao;
	
	public OrdMontagItemKey() { }
	
	public OrdMontagItemKey(String empresa, Integer ordem, Integer pedido, Integer sequencia, String item,
			String bonificacao) {
		super();
		this.empresa = empresa;
		this.ordem = ordem;
		this.pedido = pedido;
		this.sequencia = sequencia;
		this.item = item;
		this.bonificacao = bonificacao;
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
	public String getBonificacao() {
		return bonificacao;
	}
	public void setBonificacao(String bonificacao) {
		this.bonificacao = bonificacao;
	}	
}

