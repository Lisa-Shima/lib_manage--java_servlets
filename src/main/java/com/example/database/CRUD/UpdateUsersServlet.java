package com.example.database.CRUD;

import com.example.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUsersServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String sql = "SELECT * FROM users";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
        ){
            out.println("<html><body>");
            out.println("<h2>Update Users</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Username</th><th>Email</th><th>Actions</th></tr>");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + username + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td><a href='edit-user?id=" + id + "'>Edit</a></td>");
            }

            out.println("</body>");
            out.println("</table>");
        }
        catch (SQLException e){
            out.println("<h3>Error fetching users: " + e.getMessage() + "</h3>");
        }
    }
}
