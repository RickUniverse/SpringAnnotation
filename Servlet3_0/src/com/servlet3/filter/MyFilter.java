package com.servlet3.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/11/30 - 19:41
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter【init】method...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter【doFilter】method...");
        filterChain.doFilter(servletRequest,servletResponse);//继续执行后面的Filter
    }

    @Override
    public void destroy() {
        System.out.println("filter【destroy】method...");
    }
}
