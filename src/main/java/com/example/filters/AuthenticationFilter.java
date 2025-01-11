package com.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.*;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("Authentication Filter started...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException{
        HttpServletRequest httprequest = (HttpServletRequest) req;
        HttpSession session = httprequest.getSession(false);

        if(session == null || session.getAttribute("name") == null){
            System.out.println("Unauthorised user tried to access: " + httprequest.getRequestURI());
            res.setContentType("text/html");
            res.getWriter().write("<h1>Please log in to access this resource.</h1>");
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy(){
        System.out.println("Authentication Filter destroyed...");
    }
}
