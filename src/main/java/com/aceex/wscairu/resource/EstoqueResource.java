 package com.aceex.wscairu.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aceex.wscairu.dto.EstoqueDto;
import com.aceex.wscairu.model.EnvioEstoque;
import com.aceex.wscairu.model.Estoque;
import com.aceex.wscairu.service.EstoqueService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {

	@Autowired
	private EstoqueService service;

	//ex: http://localhost:8080/estoque/codigo?cnpjEmpresa=123&codigo=10-100-00039
	
	@RequestMapping(value="/codigo", method=RequestMethod.GET)
	public ResponseEntity<EstoqueDto> findByProduct(
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="codigo", defaultValue="") String codigo) {
		
		EstoqueDto dto = service.findByProduct(cnpjEmpresa, codigo);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Estoque>> findAll() {
		List<Estoque> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	//ex: http://localhost:8080/estoque/page?pagina=2
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EstoqueDto>> findPage(
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="linhas", defaultValue="0") Integer qtdLinha, 
			@RequestParam(value="ordem", defaultValue="id.codigo") String ordem, 
			@RequestParam(value="direcao", defaultValue="ASC") String direcao,
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="codigo", defaultValue="") String codigo,
			@RequestParam(value="descricao", defaultValue="") String descricao) {
		
		Page<EstoqueDto> dto = service.findPage(
				pagina, qtdLinha, ordem, direcao, cnpjEmpresa, codigo, descricao);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<String> PosicaoEstoq(
			@RequestBody List<EnvioEstoque> lista, 
			@RequestParam(value="cnpj", defaultValue="") String cnpj) {
		
		service.PosicaoEstoq(lista, cnpj);
		return ResponseEntity.noContent().build();
	}

}
