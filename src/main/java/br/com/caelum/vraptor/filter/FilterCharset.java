package br.com.caelum.vraptor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterCharset implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Before Request: " + request.getCharacterEncoding());
		System.out.println("Before Response: " + response.getCharacterEncoding()); //ISO-8859-1
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Before Set Response: " + response.getCharacterEncoding());
		
		chain.doFilter(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("After Request: " + request.getCharacterEncoding());
		System.out.println("After Response: " + response.getCharacterEncoding());
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
