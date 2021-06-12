<%@ page import="java.sql.*" %>
<%ResultSet resultset =null, resultset2 = null, resultset3;%>

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

       Statement statement2 = connection.createStatement() ;
       resultset2 =statement2.executeQuery("select * from subjects") ;

       Statement statement3 = connection.createStatement() ;
       resultset3 =statement3.executeQuery("select * from subjects") ;
 
 
    ;
       
%>
<form method="post" action="iclass">
<center>
<h2>Assign subjects to Class </h2>
</center>
    <p> Select classes from drop down 
        <select name="class1">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
        </select></p>

   
       <p> Select subjects from list 
        <select name="subject1" multiple="true" size="2">>
        <%  while(resultset2.next()){ %>
            <option><%= resultset2.getString(1)%></option>
        <% } %>
        </select></p>
    
       
        <input type = "submit" name ="OK" value = "ASSIGN" />
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