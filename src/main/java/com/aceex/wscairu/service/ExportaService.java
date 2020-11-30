package com.aceex.wscairu.service;

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

import com.aceex.wscairu.dao.CategoriaDao;
import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.EnvioEstoqueDao;
import com.aceex.wscairu.dao.EstoqTransDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dao.TransProcesDao;
import com.aceex.wscairu.model.Aen;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EnvioEstoque;
import com.aceex.wscairu.model.EstoqTrans;
import com.aceex.wscairu.model.Estoque;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.model.TransProces;

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
	
	private static final Logger log = LoggerFactory.getLogger(ExportaService.class);
	
	public void exporta() {
		System.out.println("ExportaService "+new java.util.Date());
		log.info("Expotando estoque para o ecommerce.");

		List<Empresa> empresas = eDao.findAll();
		for (Empresa empresa : empresas) {
			if ("AE".contains(empresa.getEnviar())) {
				expEstoque(empresa);
			}
		}
		log.info("Exportação de estoque comcluída.");
	}
	
	@Transactional
	private void expEstoque(Empresa empresa) {
		eeDao.deleteByEmpresa(empresa.getEmpresa());
		int transac = 0;
		TransProces tp = tpDao.findByEmpresa(empresa.getEmpresa());
		List<EstoqTrans> movtos = etDao.findMovimentos(empresa.getEmpresa(), tp.getId());
		
		for (EstoqTrans et : movtos) {
			if (et.getId() > transac) {
				transac = et.getId();
			}
			Item item = itemDao.findByKey(empresa.getEmpresa(), et.getItem());			
			List<Aen> cats = catDao.findSistemas(empresa.getId(), item.getCategoria());
			
			for (Aen cat : cats) {
				Systema sys = sysDao.findByKey(cat.getId().getSistema());
				if (sys != null) {
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
		
		if (transac == 0) {
			return;
		}
		
		List<EnvioEstoque> lstEstoq = eeDao.findSistema();
		
		for (EnvioEstoque ee : lstEstoq) {
			List<EnvioEstoque> lista = eeDao.findBySistema(ee.getSistema());
			Systema sys = sysDao.findByKey(ee.getSistema());
			log.info("Exportando item: "+ee.getItem());
			log.info("Disponivel: "+ee.getQtdDisponivel());
	        RestTemplate restTemplate = new RestTemplate();
	        String uri = sys.getUriAltEstoq().trim();
	        uri=uri+"?cnpj="+empresa.getId();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("User", "tray");      
	        headers.set("Password", "Tray@123");      
	        HttpEntity<List<EnvioEstoque>> request = new HttpEntity<>(lista, headers);
	      
	        try {
		        ResponseEntity<String> response = 
		        		restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
		        System.out.println(response.getStatusCode());
		        
		        String codHttp = ""+response.getStatusCode();
		        if (codHttp.contains("204")) {
					tpDao.update(transac, empresa.getEmpresa());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
