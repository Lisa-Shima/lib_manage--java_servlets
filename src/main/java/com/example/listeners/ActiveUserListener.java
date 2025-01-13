package com.example.listeners;

import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.http.HttpSessionEvent;

public class ActiveUserListener implements HttpSessionListener {
    public static int activeUsers = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se){
        activeUsers++;
        System.out.println("Session created. Active users: " + activeUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        activeUsers--;
        System.out.println("Session destroyed. Active users: " + activeUsers);
    }
}
