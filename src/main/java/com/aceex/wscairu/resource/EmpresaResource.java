package com.aceex.wscairu.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaResource {

	@Autowired
	private EmpresaService service;

	//ex: http://localhost:8081/empresa
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Empresa>> findAll() {
					
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
