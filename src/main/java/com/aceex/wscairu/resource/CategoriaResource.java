package com.aceex.wscairu.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aceex.wscairu.dto.CategoriaDto;
import com.aceex.wscairu.model.Aen;
import com.aceex.wscairu.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value="/codigo", method=RequestMethod.GET)
	public ResponseEntity<CategoriaDto> findByKey(
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="codigo", defaultValue="") Integer codigo) {
		
		Aen obj = service.findByKey(cnpjEmpresa, codigo);
		CategoriaDto dto = service.fromOBJ(obj);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(value="/empresa", method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> findBySistemaAndCnpj(
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa) {
		List<Aen> list = service.findBySistemaAndCnpj(cnpjEmpresa);
		List<CategoriaDto> listDto = 
				list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);

	}

}
