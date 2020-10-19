package com.aceex.wscairu.security;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aceex.wscairu.dao.ParametroDao;
import com.aceex.wscairu.model.Parametro;
import com.aceex.wscairu.util.Criptografia;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	@Autowired
	private ParametroDao pDao;

	public String generateToken(String codigo) {
		return Jwts.builder()
				.setSubject(codigo)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public boolean UserRequestExist(String codigo, String senha) {
		senha = Criptografia.criptografar(senha);
		Parametro p = pDao.findByUserAndPassword(codigo, senha);
		if (p == null) {
			return false;
		}
		return true;		
	}

}
