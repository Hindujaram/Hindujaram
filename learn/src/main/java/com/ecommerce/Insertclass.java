
package com.ecommerce;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.ecommerce.DBstaff;

public class Insertclass extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String[] subjectid = request.getParameterValues("subject1");
        String classid     = request.getParameter("class1");
        String newsubject = subjectid[0];  
        int j;
        int a = subjectid.length;
		if (a > 0)
		{		
        try 
		{
			Connection con = DBstaff.initializeDatabase();
			
			
			
			PreparedStatement ps = con.prepareStatement("insert into class_subject values(?,?)");
			PreparedStatement ds = con.prepareStatement("delete from class_subject where class_name = ?");
			ds.setString(1, classid);
			ds.executeUpdate();
			
			
			for (j=0;j<subjectid.length;j++) {
				newsubject = subjectid[j]; 
				ps.setString(1,classid);  
	            ps.setString(2,newsubject); 
				ps.executeUpdate();             
			}	
			             
            con.close();
		    }catch (Exception e) {
	            e.printStackTrace();
		}
        
        out.println("Subjects assigned to class succesfully");
        RequestDispatcher rs = request.getRequestDispatcher("main.html");
        rs.forward(request, response);
        
		}
    }  
}

