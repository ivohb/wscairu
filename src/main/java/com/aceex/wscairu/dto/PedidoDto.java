package com.aceex.wscairu.dto;

import java.io.Serializable;
import java.util.List;

public class PedidoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private PedidoVdpDto pedido;
	private PedEntregaDto entrega;
	private PedObservacaoDto observacao;
	private PedTextoDto texto;
	private List<ProdutoDto> produto ;
	private ClienteDto cliente;
	
	public PedidoDto() { }
	
	public PedidoVdpDto getPedido() {
		return pedido;
	}
	public void setPedido(PedidoVdpDto pedido) {
		this.pedido = pedido;
	}
	public PedEntregaDto getEntrega() {
		return entrega;
	}
	public void setEntrega(PedEntregaDto entrega) {
		this.entrega = entrega;
	}
	public PedObservacaoDto getObservacao() {
		return observacao;
	}
	public void setObservacao(PedObservacaoDto observacao) {
		this.observacao = observacao;
	}
	public PedTextoDto getTexto() {
		return texto;
	}
	public void setTexto(PedTextoDto texto) {
		this.texto = texto;
	}
	public List<ProdutoDto> getProduto() {
		return produto;
	}
	public void setProduto(List<ProdutoDto> produto) {
		this.produto = produto;
	}

	public ClienteDto getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
}
