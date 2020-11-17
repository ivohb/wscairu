package com.aceex.wscairu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class HeaderExposureFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/** Expondo o header location nas respostas
	 * Esse método irá interceptar todas as requisições
	 */
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//criando HttpServletResponse a partir do ServletResponse
		HttpServletResponse res = (HttpServletResponse) response;
		//expondo o hearder location
		res.addHeader("access-control-expose-headers", "location");
		//continua com a requisição
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}

