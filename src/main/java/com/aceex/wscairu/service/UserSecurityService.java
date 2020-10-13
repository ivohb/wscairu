package com.aceex.wscairu.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.aceex.wscairu.security.UsuarioSS;

public class UserSecurityService {
	
	/*Método stático pode ser chamado sem necessidade de criar uma instancia da classe
	 * Retorna o usuário logado convertido para Usuario Spring Securiry (id, codigo, 
	 * senha e perfil*/
	
	public static UsuarioSS authenticated() {
		try {
			return (UsuarioSS) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
