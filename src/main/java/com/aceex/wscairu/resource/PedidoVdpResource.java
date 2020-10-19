package com.aceex.wscairu.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aceex.wscairu.dto.PedidoDto;
import com.aceex.wscairu.model.PedidoVdp;
import com.aceex.wscairu.service.PedidoVdpService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoVdpResource {

	@Autowired
	private PedidoVdpService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PedidoVdp>> findAll() {
		List<PedidoVdp> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PedidoDto dto) {		
		PedidoVdp obj = service.insert(dto);				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
