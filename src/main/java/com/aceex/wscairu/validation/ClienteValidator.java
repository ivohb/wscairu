package com.aceex.wscairu.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.aceex.wscairu.dao.ClienteDao;
import com.aceex.wscairu.dto.ClienteDto;
import com.aceex.wscairu.exception.FieldMessage;
import com.aceex.wscairu.service.ClienteService;

public class ClienteValidator implements ConstraintValidator<ClienteValidation, ClienteDto> {

	@Autowired
	private HttpServletRequest request;	

	@Autowired
	private ClienteDao dao;
	@Autowired
	private ClienteService service;

	@Override
	public void initialize(ClienteValidation ann) {
		//função executada na inicialização da clasee
	}

	@Override
	public boolean isValid(ClienteDto value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<String, String> map =  
			(Map<String, String>) request.getAttribute(
					HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		Integer uriId = null;
		
		try {
			uriId = Integer.parseInt(map.get("id"));
		} catch (Exception e) {
			uriId = 0; 
		}

		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();

	}

}
