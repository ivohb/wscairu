package com.aceex.wscairu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.EnvioEstoqueDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dto.EstoqueDto;
import com.aceex.wscairu.exception.ObjectNotFoundException;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EnvioEstoque;
import com.aceex.wscairu.model.Estoque;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.security.UsuarioSS;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueDao dao;
	@Autowired
	private EnvioEstoqueDao eeDao;
	@Autowired
	private EmpresaDao empDao;
	@Autowired
	private SystemaDao parDao;

	public Estoque findByCodigo(String cnpjEmpresa, String codigo) {
		Estoque obj = null;
		Empresa empresa = empDao.findByCnpj(cnpjEmpresa);
		if (empresa != null) {
			obj = dao.findByKey(empresa.getEmpresa(), codigo);
			
		}
		
		if (obj == null) {
			throw new ObjectNotFoundException (
				"Não encontrado! Codigo: " + codigo + ", "
						+ "Objeto: " + Estoque.class.getName());
		}
		return obj;
	}

	public List<Estoque> findAll() {
		return dao.findAll();
	}

	public List<EnvioEstoque> findEstoq() {
		return eeDao.findAll();
	}

	public Page<EstoqueDto> findPage(Integer pagina, Integer qtdLinha, String ordem, 
			String direcao, String cnpjEmpresa, String codigo, String descricao) {

		UsuarioSS user = UserSecurityService.authenticated();
		Systema par = parDao.findByUserReq(user.getUsername());

		if (qtdLinha == null || qtdLinha == 0) {
			qtdLinha = par.getLinPage();
		}
		
		if (qtdLinha > par.getMaxLinha()) {
			qtdLinha = par.getMaxLinha();
		}
		
		PageRequest pageRequest = PageRequest.of(pagina, qtdLinha, 
				Direction.valueOf(direcao), ordem);

		String codEmpresa = "ZZ";
		Empresa empresa = null;
		
		if (cnpjEmpresa == null || cnpjEmpresa.isEmpty()) {
		} else {
			empresa = empDao.findByCnpj(cnpjEmpresa);
			if (empresa != null) {
				codEmpresa = empresa.getEmpresa();				
			} else {
				cnpjEmpresa = null;
			}
		}
			
		Page<EstoqueDto> dto = dao.findPage(cnpjEmpresa, 
				codEmpresa, codigo, descricao, par.getId(), pageRequest);
		
		for (EstoqueDto eDto : dto) {
			eDto.setCnpjEmpresa(cnpjEmpresa);
			eDto.setQtdDisponivel(eDto.getQtdLiberada() - eDto.getQtdReservada());
		}
		
		return dto;				
	}

	public EstoqueDto findByProduct(String cnpjEmpresa, String codigo) {
		UsuarioSS user = UserSecurityService.authenticated();
		Systema par = parDao.findByUserReq(user.getUsername());

		EstoqueDto dto = null;
		Empresa empresa = empDao.findByCnpj(cnpjEmpresa);
		
		if (empresa != null) {
			dto = dao.findByProduct(cnpjEmpresa, empresa.getEmpresa(), codigo, par.getId());
			if (dto != null) {
				dto.setCnpjEmpresa(cnpjEmpresa);
			}
		}
		
		if (dto == null) {
			throw new ObjectNotFoundException (
				"Não encontrado! Codigo: " + codigo + ", "
						+ "Objeto: " + Estoque.class.getName());
		} else {
			dto.setQtdDisponivel(dto.getQtdLiberada() - dto.getQtdReservada());
		}
		
		return dto;
	}

	public String PosicaoEstoq(List<EnvioEstoque> lista, String cnpj) {
		System.out.println(cnpj);
		for (EnvioEstoque ee : lista) {
			System.out.println(ee.getSistema());
			System.out.println(ee.getEmpresa());	
			System.out.println(ee.getItem());	
			System.out.println(ee.getQtdLiberada());	
			System.out.println(ee.getQtdReservada());	
			System.out.println(ee.getQtdDisponivel());	
		}
		return "OK";
	}
}
