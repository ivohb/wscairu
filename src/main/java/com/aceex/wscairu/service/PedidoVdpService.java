package com.aceex.wscairu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.dao.PedidoVdpDao;
import com.aceex.wscairu.dto.PedidoDto;
import com.aceex.wscairu.dto.ProdutoDto;
import com.aceex.wscairu.model.PedidoVdp;

@Service
public class PedidoVdpService {

	@Autowired
	private PedidoVdpDao dao;
	
	public List<PedidoVdp> findAll() {
		return dao.findAll();
	}

	@Transactional
	public PedidoVdp insert(PedidoDto dto) {
		System.out.println(dto.getPedido().getCnpjCliente());
		System.out.println(dto.getEntrega().getBairro());
		System.out.println(dto.getCliente().getRazSocial());
		List<ProdutoDto> prodDto = dto.getProduto();
		System.out.println(prodDto.get(0).getDatEntrega());
		System.out.println(prodDto.get(0).getTxtProd2());
		return new PedidoVdp();
	}
}
