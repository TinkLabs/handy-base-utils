package com.tinklabs.handy.base.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description: 全局过滤器
 * @author: lyon.cao
 * @date: 2019年4月12日
 * @version: v.0.0.1
 * @copyright: hi inc
 */
@Component
@WebFilter(urlPatterns = "/*")
@Order(1)
public class SessionFilter implements Filter {

    public static ThreadLocal<Map<String, Object>> COOKIES = new ThreadLocal<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        List<Cookie> cookies = Arrays.asList(req.getCookies());
        if (cookies.size() > 0) {
            Map<String, Object> tmp = new HashMap<>();
            cookies.forEach(cookie -> {
                tmp.put(cookie.getName(), cookie.getValue());
            });
            COOKIES.set(tmp);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
