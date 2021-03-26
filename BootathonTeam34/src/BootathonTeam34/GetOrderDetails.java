package BootathonTeam34;

/*public class getorderdetails {

}*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package grocery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author harshitha vasudevan
 */
public class GetOrderDetails {
     ArrayList<Product> order = new ArrayList<>();
     public  ArrayList<Product> fun(String Order_id) throws Exception
    {
        ArrayList<Product> order = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("1");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            //System.out.println("2");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM "+Order_id+"");
            while(rs.next())
            {
               
                Product p = new Product();
                p.Pro_id = rs.getString(1);
                p.Pro_name = rs.getString(2);
                
                p.Quantity = rs.getString(3);
                p.Price = rs.getFloat(4);
                order.add(p);
                System.out.println(p.Pro_id);
                System.out.println(p.Quantity);
                System.out.println(p.Pro_name);
                System.out.println(p.Price);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return order;
    
    }
     public static void main(String ss[])
     {
         try
         {
         new GetOrderDetails().fun("bill009");
         }
         catch(Exception ex)
         {
             System.out.println(ex);
         }
     }
}
