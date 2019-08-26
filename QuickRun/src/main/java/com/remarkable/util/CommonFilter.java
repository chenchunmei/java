package com.remarkable.util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器
 * @author 向林俊
 */
public class CommonFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// 转成HttpServletrequest
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 设置编码
		request.setCharacterEncoding(ConfigUtils.getValue("code"));
		response.setCharacterEncoding(ConfigUtils.getValue("code"));

		// 设置跨域问题
		response.setHeader("Access-Control-Allow-Origin", "*");

		// 设置返回的格式，以json格式进行交流
		response.setContentType("text/json");

		// 继续往下传递请求
		chain.doFilter(request, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
