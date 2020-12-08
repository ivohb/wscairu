package com.aceex.wscairu.config;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.EstoqTransDao;
import com.aceex.wscairu.dao.TransProcesDao;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.EstoqTrans;
import com.aceex.wscairu.model.TransProces;
import com.aceex.wscairu.service.ExportaService;
import com.aceex.wscairu.util.Biblioteca;

@Configuration
@Profile("sql")
public class SqlConfig {

	@Autowired
	private ExportaService exportaService;
	@Autowired
	private TransProcesDao tpDao;
	@Autowired
	private EmpresaDao eDao;
	@Autowired
	private EstoqTransDao etDao;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {

		checaProces();
		exporta();

		if (!"create".equals(strategy)) {
			return false;
		}
		
		return true;
	}	
	
	private void checaProces() {
		Biblioteca bib = new Biblioteca();
		List<Empresa> empresas = eDao.findAll();
		for (Empresa empresa : empresas) {
			TransProces tp = tpDao.findByEmpresa(empresa.getEmpresa());
			if (tp == null || tp.getId() == null) {
				EstoqTrans et = etDao.findByEmpresa(empresa.getEmpresa());				
				tp = new TransProces();
				if (et != null) {
					tp.setId(et.getId());
				} else {
					tp.setId(0);
				}
				tp.setEmpresa(empresa.getEmpresa());
				String emissao = bib.dateToStr(new java.util.Date(), "yyyy-MM-dd");
				tp.setDatAtualiz(bib.ansiToDate(emissao, "dd/MM/yyyy"));
				tp.setHorAtualiz(bib.horaAtual("hh:mm:ss"));
				tpDao.save(tp);
			}
		}
	}
	
	private void exporta() {
		int minuto = 2;
		
		final long TEMPO = ((1000 * minuto ) * 60);
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() { 
				System.out.println("Executou em "+new Date());
				exportaService.exporta();
			}
		};

		timer.scheduleAtFixedRate(timerTask, TEMPO, TEMPO);
	}

}
