package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException{
        System.out.println("Servlet initialized...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        res.getWriter().write("<h1>Hello again, This is Lisa...</h1>");
        System.out.println("doGet method called,...");
    }

    @Override
    public void destroy(){
        System.out.println("Servlet destroyed!");
    }
}
