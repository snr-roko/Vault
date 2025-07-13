package com.rokoinc.Vault;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Order(1)
public class LoggingFilter implements Filter {

    private final AtomicInteger requestCounter = new AtomicInteger(0);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        // convert servlet request to httpservlet
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // for each header name, print the header name and content
        request.getHeaderNames().asIterator().forEachRemaining(
                headerName -> System.out.println(headerName + ":" + request.getHeader(headerName))
        );

        // print request count
        System.out.println("Request Traffic Count: " + requestCounter.incrementAndGet());

        // continue chain of middlewares
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
