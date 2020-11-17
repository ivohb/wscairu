package com.aceex.wscairu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WscairuApplication {

	private static final Logger log = LoggerFactory.getLogger(WscairuApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WscairuApplication.class, args);
		log.info("APP iniciado");
		
	}
}
