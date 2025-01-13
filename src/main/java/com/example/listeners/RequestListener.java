package com.example.listeners;

import jakarta.servlet.*;

public class RequestListener implements ServletRequestListener{
    @Override
    public void requestInitialized(ServletRequestEvent sre){
        System.out.println("Servlet request Initialized!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        System.out.println("Servlet request destroyed!");
    }
}
