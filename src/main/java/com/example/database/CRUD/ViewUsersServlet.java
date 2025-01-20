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

public class ViewUsersServlet extends HttpServlet {
    private String sql = "SELECT * FROM users";
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
        ){
            out.println("<html><body>");
            out.println("<h1>All Users</h1>");
            out.println("<table border='1'><tr><th>ID</th><th>Username</th><th>Email</th>");

            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");

                out.println("<tr><td>" + id + "</td><td>" + username + "</td><td>" + email + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
        }
        catch (SQLException e){
            out.println("<h3>Error fetching users, " + e.getMessage() + "</h3>");
        }
    }
}
