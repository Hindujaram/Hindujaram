package com.ecommerce;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.ecommerce.DBstaff;
/**
 * Servlet implementation class Fetchstudent1
 */

public class Fetchstudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetchstudent1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();        
     
		try 
		{
			Connection con = DBstaff.initializeDatabase();
			PreparedStatement ps = con.prepareStatement("select * from student_class");
			
			
			out.print("<table width=25% border=1>");
            out.print("<center><h1>Result:</h1></center>");
            ResultSet rs=ps.executeQuery(); 
            ResultSetMetaData rsmd=rs.getMetaData();
            while(rs.next())
               {

            out.print("<tr>");
               out.print("<td>"+rs.getString(1)+"</td>");
               out.print("<td>"+rs.getString(2)+"</td></tr>");                 
            }

            out.print("</table>");
			con.close();
		    }catch (Exception e) {
	            e.printStackTrace();
		}
	}

   

    
    	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
