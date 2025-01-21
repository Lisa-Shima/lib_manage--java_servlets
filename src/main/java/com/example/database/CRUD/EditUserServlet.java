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

public class EditUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String sql = "SELECT * FROM users WHERE id= ?";

        int userId = Integer.parseInt(req.getParameter("id"));

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                String username = rs.getString("username");
                String email = rs.getString("email");

                out.println("<html><body>");
                out.println("<form action='/update-user' method='POST'>");
                out.println("<input type='hidden' name='id' value='" + userId + "'>");
                out.println("Username: <input type='text' name='username' value='" + username + "'><br>");
                out.println("Email: <input type='text' name='email' value='" + email +"'><br>");
                out.println("<button type='submit'>Update</button>");
                out.println("</form>");
                out.println("</body></html>");
            }
            else{
                out.println("User not Found!");
            }
        }
        catch(SQLException e){
            out.println("<h3>Error editing user: " + e.getMessage() + "</h3>");
        }
    }
}
