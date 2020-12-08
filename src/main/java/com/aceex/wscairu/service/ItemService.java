package com.aceex.wscairu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dto.ItemDto;
import com.aceex.wscairu.exception.ObjectNotFoundException;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EnvioEstoque;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.security.UsuarioSS;

@Service
public class ItemService {

	@Autowired
	private ItemDao dao;
	@Autowired
	private EmpresaDao empDao;
	@Autowired
	private SystemaDao sysDao;

	@Autowired
	private ItemComplService icService;

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
			pDto.setCategoria(icService.getCategoria(produto));
			pDto.setAgrupamento(icService.getAgrupamento(produto));
			pDto.setTamanho(icService.getTamanho(produto));
			pDto.setCor(icService.getCor(produto));
			pDto.setEstoque(icService.getEstoque(
					empresa.getEmpresa(), produto.getId().getCodigo()));
			pDto.setDescTecnica(icService.getEspecTecnica(
					empresa.getEmpresa(),  produto.getId().getCodigo()));	
			pDto.setPreco(icService.getPreco(empresa, produto.getId().getCodigo()));
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
		
		PageRequest pageRequest = PageRequest.of(pagina, qtdLinha);//, Direction.valueOf(direcao), ordem);

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
			produto = dao.findByKey(pDto.getCodEmpresa(), pDto.getCodigo());			
			pDto.setCnpjEmpresa(empresa.getId());

			pDto.setCategoria(icService.getCategoria(produto));
			pDto.setAgrupamento(icService.getAgrupamento(produto));
			pDto.setTamanho(icService.getTamanho(produto));
			pDto.setCor(icService.getCor(produto));
			pDto.setEstoque(icService.getEstoque(
					empresa.getEmpresa(), produto.getId().getCodigo()));
			pDto.setDescTecnica(icService.getEspecTecnica(
					empresa.getEmpresa(),  produto.getId().getCodigo()));	
			pDto.setPreco(icService.getPreco(empresa, produto.getId().getCodigo()));

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

				dto.setCategoria(icService.getCategoria(produto));
				dto.setAgrupamento(icService.getAgrupamento(produto));
				dto.setTamanho(icService.getTamanho(produto));
				dto.setCor(icService.getCor(produto));
				dto.setEstoque(icService.getEstoque(
						empresa.getEmpresa(), produto.getId().getCodigo()));
				dto.setDescTecnica(icService.getEspecTecnica(
						empresa.getEmpresa(),  produto.getId().getCodigo()));	
				dto.setPreco(icService.getPreco(empresa, produto.getId().getCodigo()));
			}
		}
		
		if (dto == null) {
			throw new ObjectNotFoundException (
				"Não encontrado! Codigo: " + codigo + ", "
						+ "Objeto: " + Item.class.getName());
		}
		return dto;
	}
	
	public String update(List<ItemDto> lista, String cnpj) {
		System.out.println(cnpj);
		for (ItemDto dto : lista) {
			System.out.println(dto.getCnpjEmpresa());
			System.out.println(dto. getCodigo());	
			System.out.println(dto.getRevisao());	
			System.out.println(dto.getDescricao());	
			System.out.println(dto.getCor().getDescricao());	
		}
		return "OK";
	}

}
