package com.example.filters;

import jakarta.servlet.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class LoggingFilter implements Filter{
    private List<String> blockedIPS;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        blockedIPS = Arrays.asList("192.168.1.1, 123.45.67.89");
        System.out.println("LoggingFilter initialized...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException{
        long startTime = System.currentTimeMillis();
        String clientIP = req.getRemoteAddr();
        System.out.println("Request received from: " + clientIP);

        if(blockedIPS.contains(clientIP)){
            System.out.println("Blocked IP tried to access: " + clientIP);
            res.getWriter().write("Access Denied! Your IP is blocked.");
            return;
        }

        System.out.println("Processing request...");

        chain.doFilter(req, res);

        System.out.println("Response sent to: " + clientIP);
        long endTime = System.currentTimeMillis();
        System.out.println("Request processed in: " + (endTime - startTime));
    }

    @Override
    public void destroy(){
        System.out.println("LoggingFilter destroyed!");
    }
}
