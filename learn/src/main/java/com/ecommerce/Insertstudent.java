
package com.ecommerce;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.ecommerce.DBstaff;

public class Insertstudent extends HttpServlet {
 
    protected void dopost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String student = request.getParameter("Stuname");
        String classid     = request.getParameter("class1");
        
        		
        try 
		{
			Connection con = DBstaff.initializeDatabase();
			
			
			
			PreparedStatement ps = con.prepareStatement("insert into student_class values(?,?)");
			PreparedStatement ds = con.prepareStatement("delete from student_class where student_name=? and class_name = ?");
			ds.setString(1, student);
			ds.setString(2, classid);
			ds.executeUpdate();
			
			ps.setString(1,student);  
	        ps.setString(2,classid); 
			ps.executeUpdate();             
				
			             
            con.close();
		    }catch (Exception e) {
	            e.printStackTrace();
		}
        
        out.println("Subjects assigned to class succesfully");
        out.println(student);
        out.println(classid);
        
        
        
        RequestDispatcher rs = request.getRequestDispatcher("main.html");
        rs.forward(request, response);
        
		}
    }  

