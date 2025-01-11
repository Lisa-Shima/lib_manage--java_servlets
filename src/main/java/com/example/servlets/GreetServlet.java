package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
public class GreetServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession(false);

        if(session != null){
            String name = (String) session.getAttribute("name");
            if (name == null) return;
            res.setContentType("text/html");
            res.getWriter().println("<h1>Welcome, " + name + "</h1>");
        }
        else {
            res.getWriter().println("<p>No session Found.</p1>");
        }
    }
}
