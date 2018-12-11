package com.csii.lipei.springbootProject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns="/test/lipei/filter",filterName="BootFilter")
public class BootFilter implements Filter {
	
	/**
	 * 容器销毁时候调用
	 */
	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	/**
	 * 容器加载时候调用
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("BootFilter");
	}

	/**
	 * 请求被拦截时候调用
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		String username = req.getParameter("username");
		if ("".equals(username)) {
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
			return;
		}
	}
	
}
