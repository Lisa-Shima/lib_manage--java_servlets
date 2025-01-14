package com.example.database;

import com.example.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try(Connection connection = DatabaseUtil.getConnection()){
            String sql = "SELECT FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            if(result.next()){
                res.getWriter().write("Login successfully! Welcome back " + username);
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                res.sendRedirect("welcome");
            }
            else {
                res.getWriter().write("Login failed! Invalid username or password");
            }
        }
        catch (Exception e){
            throw new ServletException("Database error, " + e.getMessage());
        }

    }
}
