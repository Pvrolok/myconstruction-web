package com.myconstruction.web;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myconstruction_db", "root", "tu_contraseña");

            String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Credenciales válidas
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("home.jsp");
            } else {
                // Credenciales inválidas
                response.sendRedirect("login.jsp?error=1");
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=2");
        }
    }
}
