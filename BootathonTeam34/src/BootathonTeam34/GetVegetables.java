package BootathonTeam34;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package grocery;

/**
 *
 * @author harshitha vasudevan
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
public class GetVegetables {
    public  ArrayList<Product> fun() throws Exception
    {
        ArrayList<Product> al8 = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("1");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            //System.out.println("2");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from vegetable");
            while(rs.next())
            {
               
                Product p = new Product();
                p.Pro_id = rs.getString(1);
                p.Pro_name = rs.getString(2);
                p.Price = rs.getFloat(3);
                p.Quantity = rs.getString(4);
                
                al8.add(p);
                
            }
            /*if(al==null)
            {
                System.out.println("null");
            }*/
            /*for(Product p : al)
            {
                p.print();
                
                System.out.println("");
            }*/
            con.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return al8;
        
}
    
}
