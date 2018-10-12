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
//���ƾ�̬��Դ�Ļ���ʱ��
public class StaticResourcesNeedCacheFilter implements Filter {
	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		try{
			request  = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("not-http request or response");
		}
		long time = 0;//�����ʱ��
		
		//�����û������uri��ַ�ĺ�׺��/day19_00_filter/1.html
		String uri  = request.getRequestURI();
		String exName = uri.substring(uri.lastIndexOf(".")+1);
		if("html".equals(exName)){
			String value = filterConfig.getInitParameter("html");//Сʱ
			time = Long.parseLong(value)*60*60*1000;
		}
		if("css".equals(exName)){
			String value = filterConfig.getInitParameter("css");//Сʱ
			time = Long.parseLong(value)*60*60*1000;
		}
		if("js".equals(exName)){
			String value = filterConfig.getInitParameter("js");//Сʱ
			time = Long.parseLong(value)*60*60*1000;
		}
		
		response.setDateHeader("Expires", System.currentTimeMillis()+time);
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
