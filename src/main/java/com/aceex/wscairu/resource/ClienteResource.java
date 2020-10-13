 package com.aceex.wscairu.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aceex.wscairu.dto.ClienteDto;
import com.aceex.wscairu.model.Cliente;
import com.aceex.wscairu.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable String id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//ex: http://localhost:8080/cliente/codigo?codigo=001674098000008
	@RequestMapping(value="/codigo", method=RequestMethod.GET)
	public ResponseEntity<Cliente> findByCodigo(
			@RequestParam(value="codigo", defaultValue="") String codigo) {
		
		Cliente obj = service.findByCodigo(codigo);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/cnpj", method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findByCnpj(
			@RequestParam(value="cnpj", defaultValue="") String cnpj) {
				
		List<Cliente> list = service.findByCnpj(cnpj);
		return ResponseEntity.ok().body(list);
		
	}

	//retorna todos os clientes com todos os campos
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDto dto) {		
		Cliente obj = service.insert(dto);				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(
			@Valid @RequestBody ClienteDto dto, @PathVariable String id) {
		
		service.update(dto, id);
		return ResponseEntity.noContent().build();
	}


}
