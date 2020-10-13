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
import com.aceex.wscairu.model.Cliente;
import com.aceex.wscairu.util.Biblioteca;

public class ClienteValidator implements ConstraintValidator<ClienteValidation, ClienteDto> {

	@Autowired
	private HttpServletRequest request;	

	@Autowired
	private ClienteDao dao;

	@Override
	public void initialize(ClienteValidation ann) {
		//função executada na inicialização da classe
	}

	@Override
	public boolean isValid(ClienteDto dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<String, String> map =  
			(Map<String, String>) request.getAttribute(
					HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		String uriId = null;
		
		try {
			uriId = map.get("id");
		} catch (Exception e) {
			uriId = null; 
		}

		if (dto.getCpfCnpj() == null || dto.getCpfCnpj().isEmpty() ) {
		} else {
			List<Cliente> lista  = dao.findByCnpj(dto.getCpfCnpj());
			if (uriId == null) {
				if (lista.size() > 0) {
					list.add(new FieldMessage("cpfCnpj", "cliente_ja_existe"));
				} else {
					Biblioteca bib = new Biblioteca();
					String cnpj = null;
					boolean result = false;
					if (dto.getTipo().equalsIgnoreCase("J")) {
						cnpj = dto.getCpfCnpj().substring(1);
						result = bib.isCnpj(cnpj);
					} else {
						cnpj = dto.getCpfCnpj().substring(0,11);
						cnpj = cnpj+dto.getCpfCnpj().substring(16);
						result = bib.isCpf(cnpj);
					}
					if (!result) {
						list.add(new FieldMessage("cpfCnpj", "cpf_ou_cnpj_invalido"));
					}
				}
			} else {
				if (lista.size() == 0) {
					list.add(new FieldMessage("cpfCnpj", "cliente_nao_existe"));
				}
			}
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
