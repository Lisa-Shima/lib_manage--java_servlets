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

public class DeleteUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int userId = Integer.parseInt(req.getParameter("id"));
        String sql = "DELETE FROM users where id = ?";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, userId);
            int rowsDeleted = statement.executeUpdate();

            if(rowsDeleted > 0){
                res.sendRedirect("update-users");
            }
            else{
                res.getWriter().println("Error! User not found!");
            }
        }
        catch (SQLException e){
            res.getWriter().println("<h3>Error deleting user: " + e.getMessage() + "</h3>");
        }
    }
}
