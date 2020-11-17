 package com.aceex.wscairu.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aceex.wscairu.dto.ItemDto;
import com.aceex.wscairu.dto.ProdutoDto;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.service.ItemService;

@RestController
@RequestMapping(value = "/produto")
public class ItemResource {

	@Autowired
	private ItemService service;

	//ex: http://localhost:8080/produto/codigo?cnpjEmpresa=cnpjEmpresa&codigo=10-100-00039
	
	@RequestMapping(value="/codigo", method=RequestMethod.GET)
	public ResponseEntity<ItemDto> findByProduct(
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="codigo", defaultValue="") String codigo) {
		
		ItemDto dto = service.findByProduct(cnpjEmpresa, codigo);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Item>> findAll() {
		List<Item> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	//ex: http://localhost:8080/produto/page?pagina=2
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ItemDto>> findPage(
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="linhas", defaultValue="0") Integer qtdLinha, 
			@RequestParam(value="ordem", defaultValue="id.codigo") String ordem, 
			@RequestParam(value="direcao", defaultValue="ASC") String direcao,
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="codigo", defaultValue="") String codigo,
			@RequestParam(value="descricao", defaultValue="") String descricao) {
		
		Page<ItemDto> dto = service.findPage(
				pagina, qtdLinha, ordem, direcao, cnpjEmpresa, codigo, descricao);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(value="/pag", method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDto>> findProduto(
			@RequestParam(value="pagina", defaultValue="0") Integer pagina, 
			@RequestParam(value="linhas", defaultValue="0") Integer qtdLinha, 
			@RequestParam(value="ordem", defaultValue="id.codigo") String ordem, 
			@RequestParam(value="direcao", defaultValue="ASC") String direcao,
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="codigo", defaultValue="") String codigo,
			@RequestParam(value="descricao", defaultValue="") String descricao) {
		
		Page<ProdutoDto> dto = service.findProduto(
				pagina, qtdLinha, ordem, direcao, cnpjEmpresa, codigo, descricao);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(value="/categoria", method=RequestMethod.GET)
	public ResponseEntity<List<ItemDto>> findBySistemaAndCnpj(
			@RequestParam(value="cnpjEmpresa", defaultValue="") String cnpjEmpresa,
			@RequestParam(value="categoria", defaultValue="") Integer categoria) {
		List<ItemDto> list = service.findByCategoria(cnpjEmpresa, categoria);
		return ResponseEntity.ok().body(list);

	}

}
