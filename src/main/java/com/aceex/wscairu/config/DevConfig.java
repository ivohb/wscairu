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
import com.aceex.wscairu.service.DBService;
import com.aceex.wscairu.service.ExportaService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
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
		
		dbService.insereDados();
		return true;
	}

	private void checaProces() {
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
				tpDao.save(tp);
			}
		}
	}
	
	private void exporta() {
		int minuto = 5;
		
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
