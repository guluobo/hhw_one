package com.hwhongdb.file.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//控制动态资源不要缓存过滤器
public class NoCacheFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
//		HttpServletRequest request = (HttpServletRequest)req;
//		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		try{
			request  = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("not-http request or response");
		}
		
		
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
