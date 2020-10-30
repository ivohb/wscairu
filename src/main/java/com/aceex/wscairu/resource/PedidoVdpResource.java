package com.aceex.wscairu.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aceex.wscairu.dto.PedidoVdpDto;
import com.aceex.wscairu.model.PedidoVdp;
import com.aceex.wscairu.service.PedidoVdpService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoVdpResource {

	@Autowired
	private PedidoVdpService service;

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PedidoVdpDto dto) {		
		PedidoVdp obj = service.insert(dto);				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
