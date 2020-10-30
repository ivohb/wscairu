package com.aceex.wscairu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.EspecTecnicaDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.LinhaProdDao;
import com.aceex.wscairu.dao.ListaItemDao;
import com.aceex.wscairu.dao.ParametroDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dto.Agrupamento;
import com.aceex.wscairu.dto.Categoria;
import com.aceex.wscairu.dto.Cor;
import com.aceex.wscairu.dto.EstoqueDto;
import com.aceex.wscairu.dto.ItemDto;
import com.aceex.wscairu.dto.Saldo;
import com.aceex.wscairu.dto.Tamanho;
import com.aceex.wscairu.exception.ObjectNotFoundException;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EspecTecnica;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.LinhaProd;
import com.aceex.wscairu.model.ListaItem;
import com.aceex.wscairu.model.Parametro;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.security.UsuarioSS;

@Service
public class ItemService {

	@Autowired
	private ItemDao dao;
	@Autowired
	private EmpresaDao empDao;
	@Autowired
	private LinhaProdDao linDao;
	@Autowired
	private EspecTecnicaDao etDao;
	@Autowired
	private SystemaDao sysDao;
	@Autowired
	private ParametroDao parDao;
	@Autowired
	private ListaItemDao lstDao;
	@Autowired
	private EstoqueDao eDao;
	
	public Item findByCodigo(String cnpjEmpresa, String codigo) {
		Item prod = null;
		Empresa empresa = empDao.findByCnpj(cnpjEmpresa);
		if (empresa != null) {
			prod = dao.findByKey(empresa.getEmpresa(), codigo);
			
		}
		
		if (prod == null) {
			throw new ObjectNotFoundException (
				"Não encontrado! Codigo: " + codigo + ", "
						+ "Objeto: " + Item.class.getName());
		}
		return prod;
	}

	public List<Item> findAll() {
		return dao.findAll();
	}

	public List<ItemDto> findByCategoria(String cnpjEmpresa, Integer categoria) {
		UsuarioSS user = UserSecurityService.authenticated();
		Systema sys = sysDao.findByUserReq(user.getUsername());

		String codEmpresa = "ZZ";
		Item produto = null;
		Empresa empresa = null;
		
		if (cnpjEmpresa == null || cnpjEmpresa.isEmpty()) {
		} else {
			empresa = empDao.findByCnpj(cnpjEmpresa);
			if (empresa != null) {
				codEmpresa = empresa.getEmpresa();				
			}			 
		}

		List<ItemDto> dto = dao.findByCategoria(
				sys.getId(), cnpjEmpresa, codEmpresa, categoria);
		
		for (ItemDto pDto : dto) {
			produto = dao.findByKey(pDto.getCodEmpresa(), pDto.getCodigo());			
			pDto.setCnpjEmpresa(empresa.getId());
			pDto.setCategoria(getCategoria(produto));
			pDto.setAgrupamento(getAgrupamento(produto));
			pDto.setTamanho(getTamanho(produto));
			pDto.setCor(getCor(produto));
			pDto.setEstoque(getEstoque(empresa.getId(), 
					empresa.getEmpresa(), produto.getId().getCodigo(), sys.getId()));
			pDto.setDescTecnica(getEspecTecnica(empresa.getEmpresa(), produto.getId().getCodigo()));		
			pDto.setPreco(getPreco(empresa, produto));
		}
		
		return dto;				

	}
	
	public Page<ItemDto> findPage(Integer pagina, Integer qtdLinha, String ordem, 
			String direcao, String cnpjEmpresa, String codigo, String descricao) {

		UsuarioSS user = UserSecurityService.authenticated();
		Systema sys = sysDao.findByUserReq(user.getUsername());

		if (qtdLinha == null || qtdLinha == 0) {
			qtdLinha = sys.getLinPage();
		}
		
		if (qtdLinha > sys.getMaxLinha()) {
			qtdLinha = sys.getMaxLinha();
		}
		
		PageRequest pageRequest = PageRequest.of(pagina, qtdLinha, 
				Direction.valueOf(direcao), ordem);

		String codEmpresa = "ZZ";
		Item produto = null;
		Empresa empresa = null;
		
		if (cnpjEmpresa == null || cnpjEmpresa.isEmpty()) {
		} else {
			empresa = empDao.findByCnpj(cnpjEmpresa);
			if (empresa != null) {
				codEmpresa = empresa.getEmpresa();				
			}			 
		}
			
		Page<ItemDto> dto = dao.findPage(cnpjEmpresa,
				codEmpresa, codigo, descricao, sys.getId(), pageRequest);
		
		for (ItemDto pDto : dto) {
			empresa = empDao.findByEmpresa(pDto.getCodEmpresa());
			produto = dao.findByKey(pDto.getCodEmpresa(), pDto.getCodigo());			
			pDto.setCnpjEmpresa(empresa.getId());
			pDto.setCategoria(getCategoria(produto));
			pDto.setAgrupamento(getAgrupamento(produto));
			pDto.setTamanho(getTamanho(produto));
			pDto.setCor(getCor(produto));
			pDto.setEstoque(getEstoque(empresa.getId(), 
					empresa.getEmpresa(), produto.getId().getCodigo(), sys.getId()));
			pDto.setDescTecnica(getEspecTecnica(empresa.getEmpresa(), produto.getId().getCodigo()));		
			pDto.setPreco(getPreco(empresa, produto));
		}
		
		return dto;				
	}

	public ItemDto findByProduct(String cnpjEmpresa, String codigo) { 
		UsuarioSS user = UserSecurityService.authenticated();
		Systema sys = sysDao.findByUserReq(user.getUsername());
		ItemDto dto = null;
		Item produto = null;
		Empresa empresa = empDao.findByCnpj(cnpjEmpresa);
		
		if (empresa != null) {
			dto = dao.findByProduct(cnpjEmpresa, empresa.getEmpresa(), codigo, sys.getId());
			if (dto != null) {
				produto = dao.findByKey(empresa.getEmpresa(), codigo);
				dto.setCnpjEmpresa(empresa.getId());
				dto.setCategoria(getCategoria(produto));
				dto.setAgrupamento(getAgrupamento(produto));
				dto.setTamanho(getTamanho(produto));
				dto.setCor(getCor(produto));
				dto.setEstoque(getEstoque(empresa.getId(), 
						empresa.getEmpresa(), produto.getId().getCodigo(), sys.getId()));
				dto.setDescTecnica(getEspecTecnica(empresa.getEmpresa(), codigo));		
				dto.setPreco(getPreco(empresa, produto));
			}
		}
		
		if (dto == null) {
			throw new ObjectNotFoundException (
				"Não encontrado! Codigo: " + codigo + ", "
						+ "Objeto: " + Item.class.getName());
		}
		return dto;
	}

	private Categoria getCategoria(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), 0, 0, 0);			
		Categoria cat = new Categoria();
		cat.setCodigo(obj.getCategoria());
		cat.setDescricao(lp.getDescricao());
		return cat;
	}
	
	private Agrupamento getAgrupamento(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), obj.getAgrupamento(), 0, 0);			
		Agrupamento agru = new Agrupamento();
		agru.setCodigo(obj.getAgrupamento());
		agru.setDescricao(lp.getDescricao());
		return agru;
	}

	private Tamanho getTamanho(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), 
				obj.getAgrupamento(), obj.getTamanho(), 0);			
		Tamanho tam = new Tamanho();
		tam.setCodigo(obj.getTamanho());
		tam.setDescricao(lp.getDescricao());
		return tam;
	}

	private Cor getCor(Item obj) {
		LinhaProd lp = linDao.findByKey(obj.getCategoria(), 
				obj.getAgrupamento(), obj.getTamanho(), obj.getCor());			
		Cor cor = new Cor();
		cor.setCodigo(obj.getCor());
		cor.setDescricao(lp.getDescricao());
		return cor;
	}

	private Saldo getEstoque(String cnpj, String empresa, String codigo, String sistema
) {
		EstoqueDto dto = eDao.findByProduct(cnpj, empresa, codigo, sistema);
		Saldo sdo = new Saldo();
		sdo.setQtdLiberada(dto.getQtdLiberada());
		sdo.setQtdReservada(dto.getQtdReservada());
		sdo.setQtdDisponivel(dto.getQtdLiberada() - dto.getQtdReservada());
		return sdo;
	}

	private String getEspecTecnica(String empresa, String item) {
		EspecTecnica et = etDao.findByKey(empresa, item);
		if (et == null) {
			return "";
		}
		return et.getDescTecnica();
	}
	
	private Double getPreco(Empresa empresa, Item item) {
		Parametro par = parDao.findByEmpresa(empresa.getId());
		ListaItem lst = lstDao.findByEmpresaAndNumeroAndItem(
				empresa.getEmpresa(), par.getLista(), item.getId().getCodigo());
		if (lst == null) {
			return 0.0;
		}
		return lst.getPreUnit();		
	}
}
