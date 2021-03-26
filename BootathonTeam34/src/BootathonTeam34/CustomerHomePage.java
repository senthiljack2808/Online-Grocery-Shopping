/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BootathonTeam34;

/**
 *
 * @author harshitha vasudevan
 */
 import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import javax.swing.table.TableCellRenderer;
import java.util.Scanner;
import javax.swing.plaf.basic.*;
    import javax.swing.*;  
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
//import sun.swing.table.DefaultTableCellHeaderRenderer;
public class CustomerHomePage extends GetFruits{  
JFrame f,j;
int items=0;
float totalcost=0;
Float netcost;
JScrollPane sp;
public String email_id;
JButton b0;
JLabel l1,l2,l3,l4;
JRadioButton r1,r2;
JTextField t1,t3,t4;
JTextArea t2;
JTextArea p8;
JButton b13;
String h,h1,p;
JTable t;
 int flag=1;
 int status=0;
 int count=0;
int i;
float total=0;
Product pbill=new Product();
ArrayList<Product> order1 = new ArrayList<>();
 ArrayList<Product> al3 = new ArrayList<>(); 
Billadding b1=new Billadding();



    public CustomerHomePage(String email_id){  
     this.email_id=email_id ;
    f=new JFrame();  
    f.setBounds(250, 0, 700, 650);
    
    Container c=f.getContentPane();
   c.setBackground(new Color(0,204,204));
  
   
                 
    JPanel p5=new JPanel(); 
   
   p5.setBackground(new Color(0,204,204));
   
  
   
    
    JPanel p1=new JPanel(); 
   // p1.setBackground(Color.white);
   
  
        
    
    
    
                 try
  		{
   			

   			 ArrayList<Product> al1 = new ArrayList<>();

                         al1 = new GetVegetables().fun();
                        
                             
                              p1.setLayout(new GridLayout(al1.size(),0));
                             
                        for(i=0;i<al1.size();i++)
                        {
                            Product p12=al1.get(i);
                             
                            JPanel p9=new JPanel();
                            p9.setBackground(new Color(0,204,204));
                            p9.setLayout(new GridLayout(8,0,10,10));
                            p9.setSize(500, 500);
                           
                            JLabel p_name=new JLabel();
                            p_name.setFont(new Font("Calibri",1,20));
                            p_name.setText("    Name:        "+p12.Pro_name);
                            p_name.setLocation(300,700);
                            
                             JLabel p_quantity=new  JLabel();
                            p_quantity.setText("    Quantity:    "+p12.Quantity);
                            p_quantity.setFont(new Font("Calibri",1,20));
                            p_quantity.setLocation(300,700);
                            JLabel p_price=new  JLabel();
                            p_price.setFont(new Font("Calibri",1,20));
                            p_price.setText("    Price:          "+p12.Price);
                            p_price.setLocation(300,700);
                            p9.add(p_name,BorderLayout.CENTER);
                            
                            p9.add(p_quantity,BorderLayout.CENTER);
                            p9.add(p_price,BorderLayout.CENTER);
                            JLabel re=new JLabel("    Required Quantity: ");
                            re.setFont(new Font("Calibri",1,20));
                            
                           re.setLocation(300,700);
                           p9.add(re);
                           SpinnerModel value =new SpinnerNumberModel(1,1,3,1);  
                            JSpinner spinner = new JSpinner(value);   
                             spinner.setBounds(100,100,50,30); 
                             spinner.addChangeListener(new ChangeListener() {
                                                                                @Override
                                                                                public void stateChanged(ChangeEvent e) {
                                                                                    Object q1 = ((JSpinner)e.getSource()).getValue();
                                                                                    String q12 = q1.toString();
                                                                                    p12.Quantity = q12;
                                                                                    
                                                                                    
                                                                                }
                                                                            });
                            
                             p9.add(spinner);
                          JButton addb=new  JButton("add to cart");
                          addb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    b1.add(p12);
                                    
                                    
                                    addb.setEnabled(false);
                                    b1.print();
                                   
                                }
                            });
                          JButton removeb = new JButton("Remove");
             removeb.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     b1.remove(p12);
                     //new Bill();
                     addb.setEnabled(true);
                 }
                 
             });
                          
                          p9.add(addb);
                          p9.add(removeb);
                          p1.add(p9);
                        }
                        
                        
   			
                        
                                                
  		}
  		catch(Exception e)
  		{
   			JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
  		}
                 
    
   
    
     JScrollPane scrollablep1 = new JScrollPane(p1);  
  
        scrollablep1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollablep1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);     
    
     
    JPanel p2=new JPanel();  
    p2.setBackground(new Color(0, 204, 204));
                try
  		{
   			

   			 ArrayList<Product> al11 = new ArrayList<>();

                         al11 = new GetFruits().fun();
                        
                             
                              p2.setLayout(new GridLayout(al11.size(),0));
                        for(i=0;i<al11.size();i++)
                        {
                            Product p123=al11.get(i);
                             
                            JPanel p91=new JPanel();
                            p91.setBackground(new Color(0,204,204));
                            p91.setLayout(new GridLayout(8,0,10,10));
                            p91.setSize(500, 500);
                           
                            JLabel p_name=new JLabel();
                            p_name.setFont(new Font("Calibri",1,20));
                            p_name.setText("    Name:        "+p123.Pro_name);
                            p_name.setLocation(300,700);
                            JLabel p_price=new  JLabel();
                            p_price.setFont(new Font("Calibri",1,20));
                            p_price.setText("    Price:          "+p123.Price);
                            p_price.setLocation(300,700);
                             JLabel p_quantity=new  JLabel();
                            p_quantity.setText("    Quantity:    "+p123.Quantity);
                            p_quantity.setFont(new Font("Calibri",1,20));
                            p_quantity.setLocation(300,700);
                            
                            p91.add(p_name,BorderLayout.CENTER);
                            
                            p91.add(p_quantity,BorderLayout.CENTER);
                            p91.add(p_price,BorderLayout.CENTER);
                            JLabel re=new JLabel("    Required Quantity: ");
                            re.setFont(new Font("Calibri",1,20));
                            
                           re.setLocation(300,700);
                           p91.add(re);
                           SpinnerModel value =new SpinnerNumberModel(1,1,3,1);  
                            JSpinner spinner = new JSpinner(value);   
                             spinner.setBounds(100,100,50,30); 
                             spinner.setToolTipText("Enter the required quantity"); 
                             spinner.addChangeListener(new ChangeListener() {
                 @Override
                 public void stateChanged(ChangeEvent e) {
                     Object q2 = ((JSpinner)e.getSource()).getValue();
                     String q121 = q2.toString();
                     p123.Quantity = q121;
                     
                 }
             });
                          p91.add(spinner);
                          JButton addb=new  JButton("add to cart");
                          addb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    b1.add(p123);
                                    
                                   addb.setEnabled(false);
                                    b1.print();
                                   
                                }
                            });
                           JButton removeb = new JButton("Remove");
             removeb.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     b1.remove(p123);
                     //new Bill();
                     addb.setEnabled(true);
                 }
                 
             });
                          
                          p91.add(addb);
                          p91.add(removeb);
                          p2.add(p91);
                        }
                        
                        
   			
                        
                                                
  		}
  		catch(Exception e)
  		{
   			JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
  		}
                JScrollPane scrollablep3 = new JScrollPane(p2);  
  
        scrollablep1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollablep1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
    JPanel p3=new JPanel(); 
    p3.setBackground(new Color(0, 204, 204));
    p3.setLayout(new GridLayout(2,0,10,10));
                try
  		{
   			

   			 ArrayList<Product> al12 = new ArrayList<>();

                         al12= new GetDairy().fun();
                        
                             
                              p3.setLayout(new GridLayout(al12.size(),0));
                        for(i=0;i<al12.size();i++)
                        {
                            Product p1234=al12.get(i);
                             
                            JPanel p912=new JPanel();
                            p912.setBackground(new Color(0,204,204));
                            p912.setLayout(new GridLayout(8,0,10,10));
                            p912.setSize(500, 500);
                            
                            JLabel p_name=new JLabel();
                            p_name.setFont(new Font("Calibri",1,20));
                            p_name.setText("    Name:        "+p1234.Pro_name);
                            p_name.setLocation(300,700);
                            JLabel p_price=new  JLabel();
                            p_price.setFont(new Font("Calibri",1,20));
                            p_price.setText("    Price:          "+p1234.Price);
                            p_price.setLocation(300,700);
                             JLabel p_quantity=new  JLabel();
                            p_quantity.setText("    Quantity:    "+p1234.Quantity);
                            p_quantity.setFont(new Font("Calibri",1,20));
                            p_quantity.setLocation(300,700);
                            
                            p912.add(p_name);
                            
                            p912.add(p_quantity);
                            p912.add(p_price);
                            JLabel re=new JLabel("    Required Quantity: ");
                            re.setFont(new Font("Calibri",1,20));
                            
                           re.setLocation(300,700);
                           p912.add(re);
                           SpinnerModel value =new SpinnerNumberModel(1,1,3,1);  
                            JSpinner spinner = new JSpinner(value);   
                             spinner.setBounds(100,100,50,30); 
                             spinner.setToolTipText("Enter the required quantity");  
                             spinner.addChangeListener(new ChangeListener() {
                 @Override
                 public void stateChanged(ChangeEvent e) {
                     Object q3 = ((JSpinner)e.getSource()).getValue();
                     String q123 = q3.toString();
                     p1234.Quantity = q123;
                     
                     
                 }
             });
                          p912.add(spinner);
                          JButton addb=new  JButton("add to cart");
                          addb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    b1.add(p1234);
                                    addb.setEnabled(false);
                                    b1.print();
                                    
                                    
                                   
                                }
                            });
                          JButton removeb = new JButton("Remove");
             removeb.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     b1.remove(p1234);
                     //new Bill();
                     addb.setEnabled(true);
                 }
                 
             });
                          
                          p912.add(addb);
                          p912.add(removeb);
                          p3.add(p912);
                          
                          
                        }
                        
                        
   			
                        
                                                
  		}
  		catch(Exception e)
  		{
   			JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
  		}
                
                JScrollPane scrollablep4= new JScrollPane(p3);  
  
        scrollablep4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollablep4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    JPanel p4=new JPanel();
    p4.setBackground(new Color(0, 204, 204));
    p4.setLayout(new GridLayout(2,0,10,10));
                try
  		{
   			

   			 ArrayList<Product> al13 = new ArrayList<>();

                         al13= new GetGroceries().fun();
                        
                             
                              p4.setLayout(new GridLayout(al13.size(),0));
                        for(i=0;i<al13.size();i++)
                        {
                            Product p12345=al13.get(i);
                             
                            JPanel p9123=new JPanel();
                            p9123.setBackground(new Color(0,204,204));
                            p9123.setLayout(new GridLayout(8,0,10,10));
                            p9123.setSize(500, 500);
                            
                            JLabel p_name=new JLabel();
                            p_name.setFont(new Font("Calibri",1,20));
                            p_name.setText("    Name:        "+p12345.Pro_name);
                            p_name.setLocation(300,700);
                            JLabel p_price=new  JLabel();
                            p_price.setFont(new Font("Calibri",1,20));
                            p_price.setText("    Price:          "+p12345.Price);
                            p_price.setLocation(300,700);
                             JLabel p_quantity=new  JLabel();
                            p_quantity.setText("    Quantity:    "+p12345.Quantity);
                            p_quantity.setFont(new Font("Calibri",1,20));
                            p_quantity.setLocation(300,700);
                            
                            p9123.add(p_name);
                            
                            p9123.add(p_quantity);
                            p9123.add(p_price);
                            JLabel re=new JLabel("    Required Quantity: ");
                            re.setFont(new Font("Calibri",1,20));
                            
                           re.setLocation(300,700);
                           p9123.add(re);
                           SpinnerModel value =new SpinnerNumberModel(1,1,3,1);  
                            JSpinner spinner = new JSpinner(value);   
                             spinner.setBounds(100,100,50,30); 
                             spinner.setToolTipText("Enter the required quantity");  
                             spinner.addChangeListener(new ChangeListener() {
                 @Override
                 public void stateChanged(ChangeEvent e) {
                     Object q3 = ((JSpinner)e.getSource()).getValue();
                     String q123 = q3.toString();
                     p12345.Quantity = q123;
                     
                     
                 }
             });
                          p9123.add(spinner);
                          JButton addb=new  JButton("add to cart");
                          addb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    b1.add(p12345);
                                    addb.setEnabled(false);
                                    b1.print();
                                    
                                    
                                   
                                }
                            });
                          JButton removeb = new JButton("Remove");
             removeb.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     b1.remove(p12345);
                     //new Bill();
                     addb.setEnabled(true);
                 }
                 
             });
                          
                          p9123.add(addb);
                          p9123.add(removeb);
                          p4.add(p9123);
                          
                          
                        }
                        
                        
   			
                        
                                                
  		}
  		catch(Exception e)
  		{
   			JOptionPane.showMessageDialog(null,"  Exception   -->"+e);
  		}
                
                JScrollPane scrollablep2= new JScrollPane(p4);  
  
        scrollablep2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollablep2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
   
            
    
           
                 
                       
               
                
               
                     
    
   
    JTabbedPane tp=new JTabbedPane(JTabbedPane.LEFT); 
    tp.setBounds(250,10,700,500);  
    tp.setForeground(new Color(77, 38, 0));
    
    
    tp.setFont(new Font("Calibri",1,30));
    
    tp.add("FRUITS",scrollablep3);  
    tp.add("VEGETABLES",scrollablep1);
    tp.add("GROCERIES",scrollablep2);  
    tp.add("DAIRY",scrollablep4);
    
    tp.add("MY CART",new Bill());
    c.add(tp);
    f.setResizable(false);
    f.setVisible(true);  
}  
 /*public class Bill extends JPanel
    {
        JTable t;
        JScrollPane sp;
        JButton b;
        
         Bill()
         {
        
           
            b = new JButton("Display bill");
            b.setBounds(50, 50, 100, 100);
            b.setVisible(true);
            if(b1.al2.size()==0)
            {
                b.setEnabled(false);
                
            }
            else
            {
                b.setEnabled(true);
            }
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                   if(b1.al2.size()==0)
                    {
                        order.setEnabled(false);
                        order.setVisible(false);
                        JOptionPane.showMessageDialog(null, "your cart is empty");
                    }
                    else
                    {
           
                  
                    
                    
                    JFrame j=new JFrame();
                    j.setBounds(490, 65, 790, 600);

                        Container c=j.getContentPane();
                       c.setBackground(new Color(0,204,204));
                       JPanel p5=new JPanel(); 

                       p5.setBackground(Color.WHITE);
                       p5.setLayout(new GridLayout(2,0,10,40));
            float totalcost=0;
            int i;
            b.setText("Update");
           
           
           
            
            
            Object billed[][] = new Object[b1.al2.size()+1][5];
            for( i=0;i<b1.al2.size();i++)
            {
                Product p = b1.al2.get(i);
                
                billed[i][0] = p.Pro_id;
                billed[i][1] = p.Pro_name;
                billed[i][2] = p.Quantity;
                billed[i][3] = p.Price;
                
                float Q = Float.parseFloat(p.Quantity);
                float netcost = Q*p.Price;
                
                billed[i][4] = netcost;
                totalcost = totalcost+netcost;
                
                
                
            }
            billed[i][4]= totalcost;
           
            Object col_name [] = {"PRODUCT ID","PRODUCT NAME","QUANTITY","PRICE","NETCOST"};

           
            
            t = new JTable(billed, col_name);
            t.setBounds(490,75,790,500);
           t.getTableHeader().setFont(new Font("Calibri",1,20));
           t.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
           t.getTableHeader().setBackground(Color.WHITE);
           t.getTableHeader().setForeground(Color.BLACK);
           t.setColumnSelectionAllowed(false);
           t.setRowSelectionAllowed(false);
            t.setFont(new Font("Calibri",1,20));
            
             t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             t.setShowGrid(true);
             t.setIntercellSpacing(new Dimension(20,10));
            t.setGridColor(Color.BLACK);
            t.setBackground(new Color(0,204,204));
            t.setRowHeight(50);
            
            
            sp = new JScrollPane(t);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);     
            t.setVisible(true);
            p5.add(sp,BorderLayout.CENTER);
            
        JButton order=new JButton("PLACE ORDER");
        
        order.setBounds(490,575,790,25);
        order.setFont(new Font("Calibri",1,40));
        order.setBackground(new Color(0,204,204));
        
        order.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.setVisible(false);
                            j.setVisible(false);
                           new customerreg(email_id);
                           
                        }
                    });
        
        p5.add(order);
            c.add(p5);
            
            setVisible(true);
            
            setVisible(true);
           j.setVisible(true);
           j.setDefaultCloseOperation(3);
           j.setResizable(false);
           
           
                    }
                    
                }
            });
            
            add(b,BorderLayout.WEST);
            
            
            setVisible(true);
        }
 }*/
    public class Bill extends JPanel
    {
        JTable t;
        JScrollPane sp;
        JButton b;
        
         Bill()
         {
        
           
            b = new JButton("Display bill");
            b.setBounds(50, 50, 100, 100);
            b.setVisible(true);
            /*if(b1.al2.size()==0)
            {
                b.setEnabled(false);
                
            }
            else
            {
                b.setEnabled(true);
            }*/
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                   if(b1.al2.size()==0)
                    {
                       /* order.setEnabled(false);
                        order.setVisible(false);*/
                        JOptionPane.showMessageDialog(null, "your cart is empty");
                    }
                    else
                    {
           
                  
                    
                    
                    JFrame j=new JFrame();
                    j.setBounds(250, 0, 700, 650);

                        Container c=j.getContentPane();
                       c.setBackground(new Color(0,204,204));
                       JPanel p5=new JPanel(); 

                       j.setLayout(null);
            float totalcost=0;
            int i;
            b.setText("Update");
           
           
           
            
            
            Object billed[][] = new Object[b1.al2.size()+1][5];
            for( i=0;i<b1.al2.size();i++)
            {
                Product p = b1.al2.get(i);
                
                billed[i][0] = p.Pro_id;
                billed[i][1] = p.Pro_name;
                billed[i][2] = p.Quantity;
                billed[i][3] = p.Price;
                
                float Q = Float.parseFloat(p.Quantity);
                float netcost = Q*p.Price;
                
                billed[i][4] = netcost;
                totalcost = totalcost+netcost;
                
                
                
            }
            billed[i][4]= totalcost;
           
            Object col_name [] = {"PRODUCT ID","NAME","QUANTITY","PRICE","NETCOST"};

           
            
            t = new JTable(billed, col_name);
            
           t.getTableHeader().setFont(new Font("Calibri",1,20));
           t.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
           t.getTableHeader().setBackground(Color.WHITE);
           t.getTableHeader().setForeground(Color.BLACK);
           t.setColumnSelectionAllowed(false);
           t.setRowSelectionAllowed(false);
            t.setFont(new Font("Calibri",1,20));
            
             t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             t.setShowGrid(true);
             t.setIntercellSpacing(new Dimension(20,10));
            t.setGridColor(Color.BLACK);
            t.setBackground(new Color(0,204,204));
            t.setRowHeight(50);
            
            
            sp = new JScrollPane(t);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        sp.setBounds(0, 0, 700,500);
            t.setVisible(true);
            
            
        JButton order=new JButton("PLACE ORDER");
        
        order.setBounds(50,550,300,40);
        order.setFont(new Font("Calibri",1,30));
        //order.setBackground(new Color(0,204,204));
        
        order.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	f.setVisible(false);
                            j.setVisible(false);
                            
                           new customerreg(email_id);
                           
                           
                        }
                    });
        
        
        JButton back=new JButton("Back");
        back.setBounds(400, 550, 260, 40);
        back.setFont(new Font("Calibri",1,30));
        //back.setBackground(new Color(0,204,204));
        
        back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            j.setVisible(false);
                           
                           
                        }
                    });
             c.add(sp);
             c.add(order);
            c.add(back);
            
            setVisible(true);
            
            setVisible(true);
           j.setVisible(true);
           j.setDefaultCloseOperation(3);
           j.setResizable(false);
           
           
                    }
                    
                }
            });
            
            add(b,BorderLayout.WEST);
            
            
            setVisible(true);
        }
 }
    
 public class customerreg extends JFrame {
	JLabel lbl_fname, lbl_phno,lbl_email,lbl_dadd,lbl_head,lb1_valid,lb1_valid1;
	JTextField txt_fname,txt_lname,txt_phno,txt_email,txt_d2,txt_d3,txt_d4,txt_d5;
	JTextArea txt_d1;
	JButton btn_nxt;
	boolean check1=true,check2=true,check3=true;
        JFrame customerpg;
         String fname,phno,email,caddress1;
         String cname,cphno,cemail,caddress;
     //    customerdetails ci;
	customerreg(String mail){
                 try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            String query1 = "select * from customerdetails";
            ResultSet r=st.executeQuery(query1);
            while(r.next())
            {
                if(r.getString(6).equals(mail))
                {
                cname=r.getString(2);
                cphno=r.getString(5);
                cemail=r.getString(6);
                caddress=r.getString(4);
                System.out.println(cname);
                System.out.println(cemail);
                System.out.println(cphno);
                System.out.println(caddress);
                }
            }
            
          
            
            JOptionPane.showMessageDialog(null,"Success!");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		Font f=new Font("Calibri",Font.BOLD,20);
                customerpg=new JFrame();
                customerpg.setDefaultCloseOperation(3);
                customerpg.setBounds(250, 0, 700, 650);
		Container customer=customerpg.getContentPane();
                customer.setBackground(new Color(0,204,204));
		customerpg.setLayout(null);
		lbl_head=new JLabel("CUSTOMER DETAILS");
		lbl_head.setFont(new Font("Calibri",Font.BOLD,25));
		lbl_fname=new JLabel("Full Name");
		lbl_phno=new JLabel("Phone Number");
		lbl_email=new JLabel("E-Mail");
		lbl_dadd=new JLabel("Delivery Address");
		lb1_valid=new JLabel();
		lb1_valid1=new JLabel();
		txt_fname=new JTextField();
                 txt_fname.setText(cname);
		txt_phno=new JTextField();
                 txt_phno.setText(cphno);
		txt_email=new JTextField();
                 txt_email.setText(cemail);
		txt_d1=new JTextArea();
		txt_d1.setText(caddress);
		btn_nxt=new JButton("Next");
		btn_nxt.setFont(f);
		btn_nxt.setBackground(Color.WHITE);
		btn_nxt.setBorder(new LineBorder(Color.black, 2));
		lb1_valid.setBounds(250, 125,190,20);
		lb1_valid.setFont(new Font("Arial", Font.BOLD, 11));
		lb1_valid1.setBounds(250, 175,290,20);
		
		txt_fname.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String regex =   "^[a-zA-Z\\s && [^0-9]&&[^!@#$^%&*+-]]{2,30}+$";
				String value=txt_fname.getText();
				boolean b=Pattern.matches(regex, value);
				System.out.println(b);
				
				if(b==false)
				{
					
					
					lb1_valid.setForeground(Color.white);
					lb1_valid.setText("*please enter the valid name");
					check1=false;
					
					
				}
				else
				{
				  lb1_valid.setForeground(Color.white);
				  lb1_valid.setText("*valid name");
				  check1=true;
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		txt_phno.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
				String regex1="(0/91)?[6-9][0-9]{9}";
				String value1=txt_phno.getText();
				 boolean b1=Pattern.matches(regex1, value1);
				  if((b1==true)&&value1.charAt(0)=='0' ||value1.charAt(0)=='1'||value1.charAt(0)=='2'||value1.charAt(0)=='3'||value1.charAt(0)=='4'||value1.charAt(0)=='5' )
				 {

						lb1_valid1.setForeground(Color.white);
						lb1_valid1.setText("*please enter the valid phone number");
						check2=false;
				 }
				  else
				  {
				 
				 
				 if(b1==true && value1.length()==10)
				 {
					// System.out.println("jo-true");
					 lb1_valid1.setForeground(Color.white);
					  lb1_valid1.setText("*valid phone number");
					  check2=true;
					  
				 }
/*				 else if(value1.charAt(0)=='0' ||value1.charAt(0)=='1'||value1.charAt(0)=='2'||value1.charAt(0)=='3'||value1.charAt(0)=='4'||value1.charAt(0)=='5' )
				 {

						lb1_valid1.setForeground(Color.white);
						lb1_valid1.setText("*please enter the valid phone number");
						check2=false;
				 }*/
				 
				 else
				 {
					
						
						lb1_valid1.setForeground(Color.white);
						lb1_valid1.setText("*please enter the valid phone number");
						check2=false;
						
				 }
				 
				  }
				}
				catch(Exception ee)
				{
					System.out.println("");
				}
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
				 
				
			}
		});
		
		
		
		txt_email.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String regex2="^[a-zA-Z0-9_+&*-]+(?:\\."+ 
		                "[a-zA-Z0-9_+&*-]+)*@" + 
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
		                "A-Z]{2,7}$";
				String value3=txt_email.getText();
				boolean b2=Pattern.matches(regex2,value3);
				if(b2==true)
				{
					check3=true;
				}
				else
				{
					check3=false;
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		btn_nxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=txt_fname.getText();
				String phn=txt_phno.getText();
				String mail=txt_email.getText();
				String address=txt_d1.getText();
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(txt_fname, "please enter the name");
				}
				else if(phn.isEmpty())
				{
					JOptionPane.showMessageDialog(txt_phno, "please enter the phone number");
				}
				else if(mail.isEmpty())
				{
					JOptionPane.showMessageDialog(txt_email, "please enter the email address");
				}
				else if(address.isEmpty())
				{
					JOptionPane.showMessageDialog(txt_d1, "please fill the  address");
				}
				else if(check1==false)
				{
					JOptionPane.showMessageDialog(txt_fname, "please enter  the  valid name");
				}
				else if(check2==false)
				{
					JOptionPane.showMessageDialog(txt_phno, "please enter the valid phone number");
				}
				else if(check3==false)
				{
					JOptionPane.showMessageDialog(txt_email, "please enter the valid email address");
				}
				else
				{
					//new Grocery();
					//you can add ur constructor over here
					btn_nxt.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        fname=txt_fname.getText();
	                        phno=txt_phno.getText();
	                         email=txt_email.getText();
	                         caddress1=txt_d1.getText();
	                        
	                        String Order_id= bill_id_generate();
	                        customertable_update(Order_id,fname,phno,email,caddress1);
	                        
	                        create_Billtable(Order_id);
	                        create_Billtable1(Order_id);
	                        update_ordertable(Order_id);
	                        try
	                        {
	                        order1=new GetOrderDetails().fun(Order_id);
	                        }
	                        catch(Exception ex)
	                        {
	                            System.out.println(ex);
	                        }
	                        customerpg.setVisible(false);
	                        new thankyou(Order_id);
	                        
	                        
	                        
	                    }
	                });
					
				}
				
				
				
				
			}
		});
		
		
		
		
		lbl_head.setBounds(100,40,300,25);
		lbl_fname.setBounds(100,100,100,25);
		lbl_phno.setBounds(100,150,100,25);
		lbl_email.setBounds(100,200,100,25);
		lbl_dadd.setBounds(100,250,150,25);
		txt_fname.setBounds(250,100,300,25);
		txt_fname.setBorder(new LineBorder(Color.black));
		
		txt_phno.setBounds(250,150,300,25);
		txt_phno.setBorder(new LineBorder(Color.black));
		txt_email.setBounds(250,200,300,25);
		txt_email.setBorder(new LineBorder(Color.black));
		txt_d1.setBounds(250,250,300,75);
		txt_d1.setBorder(new LineBorder(Color.black));
		btn_nxt.setBounds(220,460,200,40);
	/*	btn_nxt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fname=txt_fname.getText();
                        phno=txt_phno.getText();
                         email=txt_email.getText();
                         address=txt_d1.getText();
                        
                        String Order_id= bill_id_generate();
                        customertable_update(Order_id,fname,phno,email,address);
                        
                        create_Billtable(Order_id);
                        update_ordertable(Order_id);
                        try
                        {
                        order1=new getorderdetails().fun(Order_id);
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex);
                        }
                        customerpg.setVisible(false);
                        new thankyou(Order_id);
                        
                        
                        
                    }
                });*/
                
		
		customer.add(lb1_valid);
		customer.add(lb1_valid1);
		customer.add(lbl_head);
		customer.add(lbl_fname);
		customer.add(lbl_phno);
		customer.add(lbl_email);
		customer.add(lbl_dadd);
		customer.add(txt_fname);
		
		customer.add(txt_phno);
		customer.add(txt_email);
		customer.add(txt_d1);
		customer.add(btn_nxt);
		
		
      customerpg.setVisible(true);
      customerpg.setResizable(false);
	}
	
    public  String bill_id_generate()
    {
        String Bill_no= null;
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            
            ResultSet rs = st.executeQuery("SELECT * FROM `Orders` WHERE 1");
            int num=1;
            while(rs.next())
            {
                num++;
            }
           
            
            if(num>0 && num<=9)
            {
                Bill_no = "Bill00"+num;
            }
            else if(num>=10 && num<=99)
            {
                Bill_no = "Bill0"+num;
            }
            else
            {
                Bill_no = "Bill"+num;
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return Bill_no;
    }
    public void customertable_update(String Order_id,String fname,String phno,String email,String address)
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            //String query = "insert into customertable (Order_id"
            String query = "INSERT INTO customertable_update(Order_id, Name, Phonenumber, Email_id, Address) VALUES ('"+Order_id+"','"+fname+"','"+phno+"','"+email+"','"+address+"')";
            
            int result=st.executeUpdate(query);
            //JOptionPane.showMessageDialog(null,"Success!");
            System.out.println(result);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void create_Billtable(String Order_id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                Statement st = con.createStatement();
                try
                {
                String Query = "create table "+Order_id+" (Product_id varchar(20) , Product_name varchar(50), Quantity varchar(20), Price varchar(200), Primary Key (Product_id))";
                st.executeUpdate(Query);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println("creation error");
                }
                try
                {
                for(int i=0;i<b1.al2.size();i++)
                {
                    Product p = b1.al2.get(i);
                    String Query2 = "insert into "+Order_id+"(Product_id  , Product_name , Quantity , Price  ) values (?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(Query2);
                    pstmt.setString(1, p.Pro_id);
                    pstmt.setString(2, p.Pro_name);
                    pstmt.setString(3, p.Quantity);
                    String price = Float.toString(p.Price);
                    pstmt.setString(4, price);
                    pstmt.executeUpdate();
                    //ps.executeUpdate(Query2);
                    
                    
                }
                }
                catch(Exception ei)
                {
                    System.out.println(ei);
                    System.out.println("insertino error");
                }
                con.close();
                //}
                
                
            }
            
        
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("create billtable error");
        }
    }
    public  void update_ordertable(String Order_id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            String query1 = "INSERT INTO `Orders`(`Order_id`) VALUES ('"+Order_id+"')";
            
            st.executeUpdate(query1);
            
            JOptionPane.showMessageDialog(null,"order is placed successfully");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
	
/*	String bill_id_generate()
    {
        String Bill_no= null;
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            
            //ResultSet rs = st.executeQuery("select count(ID) from order");
            ResultSet rs = st.executeQuery("SELECT COUNT(ID) FROM `order`");
            int num =0;
            while(rs.next())
            {
                 num = rs.getInt(1);
            }
            num = num+1;
            if(num>0 && num<=9)
            {
                Bill_no = "Bill00"+num;
            }
            else if(num>=10 && num<=99)
            {
                Bill_no = "Bill0"+num;
            }
            else
            {
                Bill_no = "Bill"+num;
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Create Bill num error");
            System.out.println(e);
        }
        return Bill_no;
    }
    void customertable_update(String Order_id)
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/humprojects","root","");
            
            Statement st = con.createStatement();
            
            //String query = "insert into customertable (Order_id"
            String query = "INSERT INTO customertable(Order_id, Name, Phonenumber, Email_id, Address) VALUES (?,?,?,?,?)";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,Order_id );
            //pstmt.setString(1, Order_id);
            pstmt.setString(2, c1.Cust_Name);
            pstmt.setString(3, c1.Phone_number);
            pstmt.setString(4, c1.Email);
            pstmt.setString(5, c1.Address);
            
            pstmt.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("customer table update error");
        }
    }
     void create_Billtable(String Order_id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/humprojects","root","");
                Statement st = con.createStatement();
                try
                {
                String Query = "create table "+Order_id+" (Product_id varchar(20) , Product_name varchar(50), Quantity varchar(20), Price varchar(200), Primary Key (Product_id))";
                st.executeUpdate(Query);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println("creation error");
                }
                for(int i=0;i<b1.al2.size();i++)
                {
                    Product p = b1.al2.get(i);
                    String Query2 = "insert into "+Order_id+"(Product_id  , Product_name , Quantity , Price  ) values (?,?,?,?)";
                    PreparedStatement pstmt = con.prepareStatement(Query2);
                    pstmt.setString(1, p.Pro_id);
                    pstmt.setString(2, p.Pro_name);
                    pstmt.setString(3, p.Quantity);
                    String price = Float.toString(p.Price);
                    pstmt.setString(4, price);
                    pstmt.executeUpdate();
                    //ps.executeUpdate(Query2);
                    
                    
                }
                con.close();
                //}
                
                
            }
            
        
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("create billtable error");
        }
    }*/
    void create_Billtable1(String Order_id)
    {
        System.out.println("In create Bioll");
        String str= "";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                Statement st = con.createStatement();
                
                for(int i=0;i<b1.al2.size();i++)
                {
                    
                    Product p = b1.al2.get(i);
                    String price = Float.toString(p.Price);
                    str= str+p.Pro_id+"space"+p.Pro_name+"space"+p.Quantity+"space"+price+"new";
                    System.out.println(str);
                }
                    
                    
                    
                String query = "INSERT INTO bill(Order_id, Bill_details) VALUES (?,?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, Order_id);
                pstmt.setString(2, str);
                System.out.println(str);
                pstmt.executeUpdate();
                con.close();
                //}
                
                
            }
            
        
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("create billtable error");
        }
    }
    /* void update_ordertable(String Order_id)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            //String query = "insert into order values(?)";
            String query = "INSERT INTO `order`(`ID`) VALUES (?)";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, Order_id);
            pstmt.executeUpdate();
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("update order table error");
        }
    }*/

	
    public class thankyou 
    {
        JFrame thankyouframe;
         
         int i,items=0;
         float totalcost=0;
         JTable t;
        JScrollPane sp;
        JButton b;
        
         thankyou(String Order_id)
         {
        thankyouframe=new JFrame();
        thankyouframe.setBounds(250, 0, 700, 650);
    
           Container c=thankyouframe.getContentPane();
           c.setBackground(new Color(0,204,204));
           JPanel mainpanel=new JPanel();
           mainpanel.setBounds(250, 0, 700, 650);
           mainpanel.setBackground(new Color(0,204,204));
           mainpanel.setLayout(null);
           JLabel header=new JLabel("THANKYOU FOR SHOPPING");
           header.setFont(new Font("Calibri",1,30));
                            header.setForeground(Color.BLACK);
                           header.setBounds(150, 20, 500, 30);
          // mainpanel.add(header);
          JButton next=new JButton("Next");
          next.setBounds(400,20,200,30);
          next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	thankyouframe.setVisible(false);
            	f.setVisible(false);
                new Thanks();
                
            }
        });
          
          mainpanel.add(next);
            JLabel header2=new JLabel("ORDER DETAILS");
           header2.setFont(new Font("Calibri",1,30));
                            header2.setForeground(Color.BLACK);
                           header2.setBounds(0,20 , 500, 30);
           mainpanel.add(header2);
           /*JButton bill=new JButton("display bill");
           bill.setBounds(250,100,100,40);
           bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {*/
                float totalcost=0;
            int i;
            
           
            
            
            Object billed[][] = new Object[order1.size()+1][5];
            for( i=0;i<order1.size();i++)
            {
                Product p = order1.get(i);
                
                billed[i][0] = p.Pro_id;
                billed[i][1] = p.Pro_name;
                billed[i][2] = p.Quantity;
                billed[i][3] = p.Price;
                
                float Q = Float.parseFloat(p.Quantity);
                float netcost = Q*p.Price;
                
                billed[i][4] = netcost;
                totalcost = totalcost+netcost;
                
                
                
            }
            billed[i][4]= totalcost;
            
            Object col_name [] = {"Product id","Product Name","Quantity","Price","NETCOST"};
            
            t = new JTable(billed, col_name);
            t.getTableHeader().setFont(new Font("Calibri",1,20));
           t.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
           t.getTableHeader().setBackground(Color.WHITE);
           t.getTableHeader().setForeground(Color.BLACK);
           t.setColumnSelectionAllowed(false);
           t.setRowSelectionAllowed(false);
            t.setFont(new Font("Calibri",1,20));
            
             t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             t.setShowGrid(true);
             t.setIntercellSpacing(new Dimension(20,10));
            t.setGridColor(Color.BLACK);
            t.setBackground(new Color(0,204,204));
            t.setRowHeight(50);
            sp = new JScrollPane(t);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
                                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            t.setVisible(true);
            sp.setBounds(0,60,700,300);
            sp.setVisible(true);
            mainpanel.add(sp,BorderLayout.CENTER);
               
           // }
       // });
          // mainpanel.add(bill);
           
           
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("1");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            //System.out.println("2");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM `customertable_update` WHERE Order_id='"+Order_id+"'");
            while(rs.next())
            {
            System.out.println(rs.getString(2));
            JLabel head=new JLabel("CUSTOMER DETAILS");
            
            head.setBounds(0, 390, 700, 40);
            head.setFont(new Font("Calibri",Font.BOLD,30));
            head.setForeground(Color.BLACK);
            mainpanel.add(head);
            JLabel name=new JLabel();
            
            name.setText("Name:      "+rs.getString(2));
            name.setBounds(0, 430, 700, 40);
            name.setFont(new Font("Calibri",Font.BOLD,20));
            name.setForeground(Color.BLACK);
            mainpanel.add(name);
            JLabel address=new JLabel("Address: ");
           // address.setText(rs.getString(2));
            address.setBounds(0, 470, 100,30);
            address.setFont(new Font("Calibri",Font.BOLD,20));
            address.setForeground(Color.BLACK);
            mainpanel.add(address);
            JTextArea address2=new JTextArea();
            address2.setText(rs.getString(5));
            address2.setBackground(new Color(0,204,204));
            address2.setFont(new Font("Calibri",Font.BOLD,20));
            address2.setForeground(Color.BLACK);
             JScrollPane address1 = new JScrollPane(address2);
            address1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        address1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        address1.setBounds(110, 470, 550,70);
            mainpanel.add(address1);
            JLabel email=new JLabel("Email_id:   "+rs.getString(4));
            //email.setText(rs.getString(2));
            email.setBounds(0, 540, 700, 40);
            email.setFont(new Font("Calibri",Font.BOLD,20));
            email.setForeground(Color.BLACK);
            mainpanel.add(email);
            JLabel phno=new JLabel("Contact:    "+rs.getString(3));
           // phno.setText(rs.getString(2));
            phno.setBounds(0, 580, 700, 40);
            phno.setFont(new Font("Calibri",Font.BOLD,20));
            phno.setForeground(Color.BLACK);
            mainpanel.add(phno);
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
           
           c.add(mainpanel);
           thankyouframe.setVisible(true);
           thankyouframe.setResizable(false);
    }
    public class Bill2 extends JPanel
    {
        public Bill2() {
            
                
            
        
        
            float totalcost=0;
            int i;
            
           
            
            
            Object billed[][] = new Object[order1.size()+1][5];
            for( i=0;i<order1.size();i++)
            {
                Product p = order1.get(i);
                
                billed[i][0] = p.Pro_id;
                billed[i][1] = p.Pro_name;
                billed[i][2] = p.Quantity;
                billed[i][3] = p.Price;
                
                float Q = Float.parseFloat(p.Quantity);
                float netcost = Q*p.Price;
                
                billed[i][4] = netcost;
                totalcost = totalcost+netcost;
                
                
                
            }
            billed[i][4]= totalcost;
            
            Object col_name [] = {"Product id","Product Name","Quantity","Price","NETCOST"};
            
            t = new JTable(billed, col_name);
            t.getTableHeader().setFont(new Font("Calibri",1,20));
           t.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
           t.getTableHeader().setBackground(Color.WHITE);
           t.getTableHeader().setForeground(Color.BLACK);
           t.setColumnSelectionAllowed(false);
           t.setRowSelectionAllowed(false);
            t.setFont(new Font("Calibri",1,20));
            
             t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             t.setShowGrid(true);
             t.setIntercellSpacing(new Dimension(20,10));
            t.setGridColor(Color.BLACK);
            t.setBackground(new Color(0,204,204));
            t.setRowHeight(50);
            sp = new JScrollPane(t);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
                                sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            t.setVisible(true);
            
            add(sp,BorderLayout.CENTER);
            setVisible(true);
            
            setVisible(true);
            setVisible(true);
           
            //sp.setVisible(false);
            
        //}
        
    }
        
    
        
         
            
            
           
            
    }   
            
        
    }
/*    public class Thanks {
     JLabel thank,visit;
     Container con;
     JButton home,feedback;
	Thanks()
	{
		JFrame f=new JFrame();
     f.setLayout(null);
     f.getContentPane().setBackground(new Color(0,204,204));
     
     thank=new JLabel("Thanks for Shopping");
     visit=new JLabel("Visit Again");
    thank.setBounds(190, 150, 500, 50);
    thank.setFont(new Font("Calibri", 1, 40));
     f.add(thank);
     visit.setBounds(275, 200, 500, 50);
     visit.setFont(new Font("Calibri", 1, 30));
     f.add(visit);
     home=new JButton("HOME");
     home.setBounds(250,300,100,30);
     home.setBackground(Color.white);
     
     f.add(home);
     home.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			f.setVisible(false);
			new Grocery();
		}
	});
     
     feedback=new JButton("feedback");
     feedback.setBounds(370,300,100,30);
     feedback.setBackground(Color.white);
     
     f.add(feedback);
     feedback.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			f.setVisible(false);
			new feedback();
		}
	});
     
     f.setBounds(250, 20, 700, 650);
     f.setVisible(true);
	}
	
	
}*/

	
}
    
    
    public static void main(String[] args) {  
        new CustomerHomePage("hfhjyj@.");  
    }
} 
