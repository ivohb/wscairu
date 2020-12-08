package com.aceex.wscairu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.EspecTecnicaDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.LinhaProdDao;
import com.aceex.wscairu.dao.ListaItemDao;
import com.aceex.wscairu.dao.ParametroDao;
import com.aceex.wscairu.dto.Agrupamento;
import com.aceex.wscairu.dto.Categoria;
import com.aceex.wscairu.dto.Cor;
import com.aceex.wscairu.dto.Saldo;
import com.aceex.wscairu.dto.Tamanho;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EspecTecnica;
import com.aceex.wscairu.model.Estoque;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.LinhaProd;
import com.aceex.wscairu.model.ListaItem;
import com.aceex.wscairu.model.Parametro;

@Service
public class ItemComplService {

	@Autowired
	private LinhaProdDao linDao;
	@Autowired
	private EspecTecnicaDao etDao;
	@Autowired
	private ParametroDao parDao;
	@Autowired
	private ListaItemDao lstDao;
	@Autowired
	private EstoqueDao eDao;
	

	public Categoria getCategoria(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), 0, 0, 0);			
		Categoria cat = new Categoria();
		cat.setCodigo(obj.getCategoria());
		cat.setDescricao(lp.getDescricao());
		return cat;
	}
	
	public Agrupamento getAgrupamento(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), obj.getAgrupamento(), 0, 0);			
		Agrupamento agru = new Agrupamento();
		agru.setCodigo(obj.getAgrupamento());
		agru.setDescricao(lp.getDescricao());
		return agru;
	}

	public Tamanho getTamanho(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), 
				obj.getAgrupamento(), obj.getTamanho(), 0);			
		Tamanho tam = new Tamanho();
		tam.setCodigo(obj.getTamanho());
		tam.setDescricao(lp.getDescricao());
		return tam;
	}

	public Cor getCor(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), 
				obj.getAgrupamento(), obj.getTamanho(), obj.getCor());			
		Cor cor = new Cor();
		cor.setCodigo(obj.getCor());
		cor.setDescricao(lp.getDescricao());
		return cor;
	}

	public Saldo getEstoque( 
			String empresa, String codigo) {

		Double zero = 0.0;
		Estoque obj = eDao.findEstoque(empresa, codigo);
		Saldo sdo = new Saldo();
		if (obj == null) {
			sdo.setQtdLiberada(zero);
			sdo.setQtdReservada(zero);
		} else {
			sdo.setQtdLiberada(obj.getQtdLiberada());
			sdo.setQtdReservada(obj.getQtdReservada());			
		}
		sdo.setQtdDisponivel(sdo.getQtdLiberada() - sdo.getQtdReservada());
		return sdo;
	}

	public String getEspecTecnica(String empresa, String item) {
		EspecTecnica et = etDao.findByKey(empresa, item);
		if (et == null) {
			return "";
		}
		return et.getDescTecnica();
	}
	
	public Double getPreco(Empresa empresa, String item) {
		Parametro par = parDao.findByEmpresa(empresa.getId());
		ListaItem lst = lstDao.findByEmpresaAndNumeroAndItem(
				empresa.getEmpresa(), par.getLista(), item);
		if (lst == null) {
			return 0.0;
		}
		return lst.getPreUnit();		
	}

}
