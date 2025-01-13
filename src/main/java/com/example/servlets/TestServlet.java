package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
public class TestServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        throw new RuntimeException("Test 500 Error");
    }
}
