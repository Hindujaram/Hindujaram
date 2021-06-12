package com.ecommerce;

import java.sql.*;

public class Validate {
    public static boolean checkUser(String email,String pass) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","12345");
            PreparedStatement ps = con.prepareStatement("select * from userreg where name=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}