package com.ray.educatesystem.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Package:com.ray.educatesystem.filter
 * *Author:ray
 * *version:...
 * *Created in 2020/2/17  12:55
 **/
@WebFilter(filterName = "myfilter",urlPatterns = "/*")
public class MyFilter implements Filter {
	private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.info("过滤器初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		LOG.info("过滤器过滤");
	}

	@Override
	public void destroy() {
		LOG.info("过滤器销毁");
	}
}
