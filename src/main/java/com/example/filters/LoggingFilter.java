package com.example.filters;

import jakarta.servlet.*;
import java.io.*;

public class LoggingFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException{
        System.out.println("Request received from: " + req.getRemoteAddr());
        System.out.println("Processing request...");

        chain.doFilter(req, res);

        System.out.println("Response sent to: " + req.getRemoteAddr());
    }

    @Override
    public void destroy(){
        System.out.println("LoggingFilter destroyed!");
    }
}
