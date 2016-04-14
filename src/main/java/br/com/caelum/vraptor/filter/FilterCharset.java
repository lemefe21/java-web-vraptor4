package br.com.caelum.vraptor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterCharset implements Filter{
	
	private static final String UTF_8 = "UTF-8";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Before Encoding Request: " + request.getCharacterEncoding());
		request.setCharacterEncoding(UTF_8);
		
		System.out.println("Before Encoding Response: " + response.getCharacterEncoding());
		//ISO-8859-1
		response.setCharacterEncoding(UTF_8);
		System.out.println("Before Set Encoding Response: " + response.getCharacterEncoding());
		
		chain.doFilter(request, response);
		
		request.setCharacterEncoding(UTF_8);
		System.out.println("After Encoding Request: " + request.getCharacterEncoding());
		
		response.setCharacterEncoding(UTF_8);
		System.out.println("After Encoding Response: " + response.getCharacterEncoding());
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
