package com.ecommerce;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Assignstudent1 extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        if(Validate.checkUser(email, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("main.html");
            rs.forward(request, response);
        }
        else
        {
         
           RequestDispatcher rs = request.getRequestDispatcher("Assignstu2.jsp");
           rs.include(request, response);
        }
    }  
}