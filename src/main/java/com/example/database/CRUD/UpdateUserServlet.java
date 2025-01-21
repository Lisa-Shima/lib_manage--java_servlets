package com.example.database.CRUD;

import com.example.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int userId = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        String sql = "UPDATE users SET username = ?, email = ? WHERE id = ?";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setInt(3, userId);

            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0){
                res.sendRedirect("update-users");
            }
            else{
                res.getWriter().println("<h3>Error! User not updated!</h3>");
            }
        }
        catch (SQLException e){
            res.getWriter().println("<h3>Error in updating user: " + e.getMessage() + "</h3>");
        }
    }
}
