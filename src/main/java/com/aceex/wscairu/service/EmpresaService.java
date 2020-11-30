package com.aceex.wscairu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.model.Empresa;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaDao dao;	

	public List<Empresa> findAll() {
		return dao.findAll();
	}

}
