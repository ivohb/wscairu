package com.aceex.wscairu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.CategoriaDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dto.CategoriaDto;
import com.aceex.wscairu.exception.ObjectNotFoundException;
import com.aceex.wscairu.model.Aen;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.security.UsuarioSS;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDao dao;	
	@Autowired
	private SystemaDao sysDao;	

	public Aen findByKey(String cnpj, Integer codigo) {
		UsuarioSS user = UserSecurityService.authenticated();
		Systema sys = sysDao.findByUserReq(user.getUsername());
		String chave = cnpj+codigo;
		Aen obj = dao.findByKey(sys.getId(), cnpj, codigo);		
		if (obj == null) {
			throw new ObjectNotFoundException(
				"Não encontrado! Chave: " + chave + ", "
						+ "Objeto: " + Aen.class.getName());
		}		
		return obj;
	}

	public List<Aen> findBySistemaAndCnpj(String cnpj) {
		UsuarioSS user = UserSecurityService.authenticated();
		Systema sys = sysDao.findByUserReq(user.getUsername());
		return dao.findBySistemaAndCnpj(sys.getId(), cnpj);
	}

	public CategoriaDto fromOBJ(Aen obj) {
		CategoriaDto dto = new CategoriaDto();
		dto.setCodigo(obj.getId().getLinhaProd());
		dto.setDescricao(obj.getDescricao());
		return dto;
		
	}
}
