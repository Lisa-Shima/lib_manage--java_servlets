package com.example.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppLifecycleListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("Application started!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("Application shutting down!");
    }
}
