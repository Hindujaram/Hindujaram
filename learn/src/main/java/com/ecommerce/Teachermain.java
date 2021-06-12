package com.ecommerce;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Teachermain extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        String Teaname = request.getParameter("Teaname");
        String class1 = request.getParameter("class1");
        

        out.println(Teaname);
        out.println(class1);

        request.setAttribute("Teaname", Teaname);
        request.setAttribute("class1", class1);
        
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/Insertstaff.jsp");
        rd.forward(request,response);
        
          
}
}
