package com.aceex.wscairu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aceex.wscairu.dao.UsuarioDao;
import com.aceex.wscairu.model.Usuario;
import com.aceex.wscairu.security.UsuarioSS;

@Service
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		Usuario obj = dao.findByCodigo(codigo);
		if (obj == null) {
			throw new UsernameNotFoundException(codigo);
		}
		return new UsuarioSS(obj.getId(), 
				obj.getCodigo(), obj.getSenha(),obj.getPerfil(), obj.getCpfCnpj());
	}
	
}
