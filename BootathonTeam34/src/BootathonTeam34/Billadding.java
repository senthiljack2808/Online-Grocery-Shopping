package BootathonTeam34;


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
public class Billadding {
     ArrayList<Product> al2 = new ArrayList<>();
     
     void add (Product p1)
     {
         al2.add(p1);
     }
     void print()
     {
         System.out.println(" "+ "Pro_id" + " "+ "Pro_name" + " "+ "Quantity" + " "+ "p.Price");
         for(int i=0;i<al2.size();i++)
         {
             Product p = al2.get(i);
             System.out.println(" "+ p.Pro_id + " "+ p.Pro_name + " "+ p.Quantity + " "+ p.Price);
             System.out.println();
         }
     }
     void remove(Product p)
     {
         al2.remove(p);
     }
     
     public static void main(String ss[])
     {
        
     }
}
