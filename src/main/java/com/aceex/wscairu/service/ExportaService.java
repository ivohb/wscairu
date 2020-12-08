package com.aceex.wscairu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.aceex.wscairu.dao.AuditItemDao;
import com.aceex.wscairu.dao.CategoriaDao;
import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.EnvioEstoqueDao;
import com.aceex.wscairu.dao.EstoqTransDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.ItemEnviadoDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dao.TransProcesDao;
import com.aceex.wscairu.dto.ItemDto;
import com.aceex.wscairu.key.ItemEnviadoKey;
import com.aceex.wscairu.model.Aen;
import com.aceex.wscairu.model.AuditItem;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EnvioEstoque;
import com.aceex.wscairu.model.EstoqTrans;
import com.aceex.wscairu.model.Estoque;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.ItemEnviado;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.model.TransProces;
import com.aceex.wscairu.util.Biblioteca;

@Service
public class ExportaService {

	@Autowired
	private EstoqueDao estDao;
	@Autowired
	private TransProcesDao tpDao;
	@Autowired
	private EmpresaDao eDao;
	@Autowired
	private EstoqTransDao etDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private CategoriaDao catDao;
	@Autowired
	private SystemaDao sysDao;
	@Autowired
	private EnvioEstoqueDao eeDao;
	@Autowired
	private AuditItemDao aiDao;
	@Autowired
	private ItemEnviadoDao ieDao;

	@Autowired
	private ItemComplService icService;

	private String codStatus;
	
	private static final Logger log = LoggerFactory.getLogger(ExportaService.class);
	
	public void exporta() {
		System.out.println("ExportaService "+new java.util.Date());

		List<Empresa> empresas = eDao.findAll();

		log.info("Expotando estoque para o ecommerce.");
		for (Empresa empresa : empresas) {
			//expEstoque(empresa);
		}
		log.info("Exportação de estoque comcluída.");

		log.info("Expotando produtos para o ecommerce.");
		for (Empresa empresa : empresas) {
			expProduto(empresa);
		}
		log.info("Exportação de produtos comcluída.");
	}
	
	/**
	 * A usuária da Cairu disse que vai reservar uma certa quantidade para comercializar
	 * por SC e vai implantar estoque dessa quantidade em SC. Porém, se não fizer nada
	 * na empresa de SP o estoque vai ficar errado pois o mesmo material estará em SP e
	 * SC. Então, é preciso que em SP seja criado um pedido de vendas para SC. Esse pedido
	 * deve estar com o campo Local estoque preenchido e a quantidade do item do pedido
	 * deve ser transferida para esse local do pedido. Isso deve ser feito para cada
	 * item comercializado por SC.
	 */
	@Transactional
	private void expEstoque(Empresa empresa) {
		//limpa a tabela temporária
		//eeDao.deleteByEmpresa(empresa.getEmpresa());
		eeDao.deleteAll();
		int transac = 0;
		TransProces tp = tpDao.findByEmpresa(empresa.getEmpresa());
		//busca últimos movimentos
		List<EstoqTrans> movtos = etDao.findMovimentos(empresa.getEmpresa(), tp.getId());
		
		for (EstoqTrans et : movtos) { //percorre os movomentos de estoque
			if (et.getId() > transac) {
				transac = et.getId();
			}
			
			//obtem a categoria do produto movimentado
			Item item = itemDao.findByKey(empresa.getEmpresa(), et.getItem());	
			//busca sistemas que comercializam tal categoria
			List<Aen> cats = catDao.findSistemas(empresa.getId(), item.getCategoria());
			
			for (Aen cat : cats) {
				//verifica se o sistema está cadastrado como um ecommerce
				Systema sys = sysDao.findByKey(cat.getId().getSistema());
				if (sys != null) {
					//busca estoque e adicina na tabela temporária
					Estoque est = estDao.findByKey(empresa.getEmpresa(), item.getId().getCodigo());
					if (est != null) {
						EnvioEstoque ee = new EnvioEstoque();
						ee.setCnpj(empresa.getId());
						ee.setEmpresa(empresa.getEmpresa());
						ee.setId(null);
						ee.setItem(est.getId().getCodigo());
						ee.setQtdLiberada(est.getQtdLiberada());
						ee.setQtdReservada(est.getQtdReservada());
						ee.setQtdDisponivel(est.getQtdLiberada() - est.getQtdReservada());
						ee.setSistema(sys.getId());
						eeDao.save(ee);
					}
				}
			}
		}
		
		if (transac == 0) { //se não tem movimentos, retorna
			return;
		}
		
		//le os sistemas da tabela temporária
		List<EnvioEstoque> lstEstoq = eeDao.findSistema();
		String codHttp = "204";
		
		for (EnvioEstoque ee : lstEstoq) {
			//busca os movimentos por sistema
			List<EnvioEstoque> lista = eeDao.findBySistema(ee.getSistema());
			
			Systema sys = sysDao.findByKey(ee.getSistema());
	        RestTemplate restTemplate = new RestTemplate();
	        String uri = sys.getUriAltEstoq().trim();
	        uri=uri+"?cnpj="+empresa.getId();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("User", sys.getUserEnvio());      
	        headers.set("Password", sys.getSenhaEnvio());      
	        HttpEntity<List<EnvioEstoque>> request = new HttpEntity<>(lista, headers);
	      
	        try {
		        ResponseEntity<String> response = 
		        		restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
		        System.out.println(response.getStatusCode());
		        
		        String http = ""+response.getStatusCode();	
		        
		        if (http.contains("204")) {		        	
		        } else {
		        	codHttp = ""+response.getStatusCode();	
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
        if (codHttp.contains("20")) {
			tpDao.update(transac, empresa.getEmpresa());
		}
	}

	@Transactional
	private void expProduto(Empresa empresa) {
		Biblioteca bib = new Biblioteca();
		this.codStatus = "204";
		//busca data do último envio de produto
		TransProces tp = tpDao.findByEmpresa(empresa.getEmpresa());
		//busca categorias comercializadas pela empresa
		List<Aen> cats = catDao.findByCnpj(empresa.getId());
		
		for (Aen cat : cats) {
			List<ItemDto> lista = new ArrayList<ItemDto>();
			List<AuditItem> itens = aiDao.findItens(empresa.getEmpresa(), 
					empresa.getId(), tp.getDatAtualiz(), cat.getId().getSistema()); 
					
			for (AuditItem ai : itens) {			
				Item item = itemDao.findByKey(empresa.getEmpresa(), ai.getItem());
				ItemDto dto = itemDao.findByEmpresaAndCodigo(empresa.getEmpresa(), ai.getItem());				
				dto.setCnpjEmpresa(empresa.getId());
				dto.setRevisao(ai.getRevisao());
				dto.setAgrupamento(icService.getAgrupamento(item));
				dto.setCategoria(icService.getCategoria(item));
				dto.setCor(icService.getCor(item));
				dto.setTamanho(icService.getTamanho(item));
				dto.setEstoque(icService.getEstoque(empresa.getEmpresa(), ai.getItem()));
				dto.setDescTecnica(icService.getEspecTecnica(empresa.getEmpresa(), ai.getItem()));
				dto.setPreco(icService.getPreco(empresa, ai.getItem()));
				lista.add(dto);
			}
			
			enviaProduto(cat.getId().getSistema(), empresa.getId(), lista, "PUT");

			if (this.codStatus.contains("20")) {
				for (ItemDto dto : lista) {
					ItemEnviado ie = new ItemEnviado();
					ItemEnviadoKey key = new ItemEnviadoKey();
					key.setEmpresa(empresa.getEmpresa());
					key.setCodigo(dto.getCodigo());
					ie.setId(key);
					ie.setRevisao(dto.getRevisao());
					ieDao.save(ie);
				}
			}
		}

		if (this.codStatus.contains("20")) {
			try {
				String datAtual = bib.dateToStr(new java.util.Date(), "yyyy-MM-dd");
				Date datAtualiz = bib.ansiToDate(datAtual, "dd/MM/yyyy");
				String horAtualiz = bib.horaAtual("hh:mm:ss");
				tpDao.update(empresa.getEmpresa(), datAtualiz, horAtualiz);				
			} catch (Exception e) {
				System.out.println(e.getMessage()+" - "+e.getCause());
				e.printStackTrace();
			}
		}
	}

	private void enviaProduto(String sistema, String cnpj, List<ItemDto> lista, String verbo) {
		Systema sys = sysDao.findByKey(sistema);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("User", sys.getUserEnvio());      
        headers.set("Password", sys.getSenhaEnvio());      
        HttpEntity<List<ItemDto>> request = new HttpEntity<>(lista, headers);
      
        try {
            String uri = null; 
        	ResponseEntity<String> response = null;
        	if (verbo.contains("PUT")) {
                uri = sys.getUriAltProd().trim();
                uri=uri+"?cnpj="+cnpj;
    	        response = restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
			} else {
		        uri = sys.getUriIncProd().trim();
		        uri=uri+"?cnpj="+cnpj;
				response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);			}
	        
	        String http = ""+response.getStatusCode();	
	        
	        if (http.contains("20")) {		        	
	        } else {
	        	this.codStatus = ""+response.getStatusCode();	
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
