package com.example.filters;

import jakarta.servlet.*;
import java.io.*;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("Authentication Filter started...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException{

    }

    @Override
    public void destroy(){
        System.out.println("Authentication Filter destroyed...");
    }
}
