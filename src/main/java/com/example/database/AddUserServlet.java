package com.example.database;

import com.example.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try(Connection connection = DatabaseUtil.getConnection()){
            String sql = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();

            PrintWriter out = res.getWriter();
            if(rowsInserted > 0){
                out.println("User inserted successfully!");
            }
            else {
                out.println("Failed to add user.");
            }
        }
        catch (SQLException e){
            throw new ServletException("Database error, " + e);
        }
    }
}
