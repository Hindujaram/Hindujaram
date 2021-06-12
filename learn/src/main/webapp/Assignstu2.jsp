<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>Select element drop down box</TITLE>
</HEAD>
<BODY  >

<%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/admin","root","12345");

       Statement statement = connection.createStatement() ;
       resultset =statement.executeQuery("select * from classes") ;

        
    ;
       
%>
<form method="post" action="istudent">
<center>
<h2>Add students to Class </h2>
</center>
    <p> Enter Student Name 
        <input type ="text" name="Stuname">
        </p>

   
       <p> Select subjects from list 
        <select name="class1" size="4">>
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
        </select></p>
    
       
        <input type = "submit" name ="OK" value = "Add" />
        </form>
<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>

</BODY>
</HTML>