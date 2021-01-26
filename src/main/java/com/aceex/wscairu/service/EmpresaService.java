package com.aceex.wscairu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.model.Empresa;

@Service
public class EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);
	
	@Autowired
	private EmpresaDao dao;	

	public List<Empresa> findAll() {
		log.info("Consulta de empresas");
		return dao.findAll();
	}

}
