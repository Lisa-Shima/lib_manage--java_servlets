package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class FormServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        res.setContentType("text/html");
        res.getWriter().println("<h1>Form Submitted successfully!</h1>");
        res.getWriter().println("<p>Name: " + name + "</p>");
        res.getWriter().println("<p>Email: " + email + "</p>");

        // Session management
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", email);

        res.sendRedirect("greet");
    }
}
