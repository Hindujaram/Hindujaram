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


       String class1=(String)request.getAttribute("class1");
       String Teaname=(String)request.getAttribute("Teaname");
       
       
       Statement statement = connection.createStatement() ;
       resultset =statement.executeQuery("select distinct subjects_Assigned from class_subject") ;
    ;
       
%>


<form method="post" action="Fteacher">

<h1>Add teachers to Class </h1>

    <h5> Staff Name Entered : <%=Teaname%> 	
     
     Class Entered      : <%=class1%> 	
      </h5>

        <p> Select subjects from list 
        <select name="Test" size="4">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(1)%></option>
        <% } %>
        </select></p>
        
        <input type = "submit" name ="OK" value = "Enter" />
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