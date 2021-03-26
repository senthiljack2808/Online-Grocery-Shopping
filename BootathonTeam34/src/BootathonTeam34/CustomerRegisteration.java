package BootathonTeam34;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package grocery;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author harshitha vasudevan
 */

    import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class CustomerRegisteration extends JFrame {
	JLabel lbl_fname, lbl_phno,lbl_email,lbl_dadd,lbl_head,lb1_valid,lb1_valid1;
	JTextField txt_fname,txt_lname,txt_phno,txt_email,txt_d2,txt_d3,txt_d4,txt_d5;
	JTextArea txt_d1;
	JButton btn_nxt;
	JPasswordField txt_password;
	boolean check1,check2,check3,check4;
        JFrame customerpg;
         String fname,phno,email,address;
         Billadding b;
         //customerdetails ci;
         JLabel lbl_valid2;
	CustomerRegisteration(){
                
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
                JLabel lbl_password=new JLabel("Password");
                
		lbl_phno=new JLabel("Phone Number");
		lbl_email=new JLabel("E-Mail");
		lbl_dadd=new JLabel("Delivery Address");
		lb1_valid=new JLabel();
		lb1_valid1=new JLabel();
		txt_fname=new JTextField();
                 
		txt_phno=new JTextField();
       txt_password=new JPasswordField();
       //txt_password.setEchoChar(char(0));
       txt_password.setEchoChar((char)0);
		txt_email=new JTextField();
                 
		txt_d1=new JTextArea();
		
		btn_nxt=new JButton("Register");
		btn_nxt.setFont(f);
		btn_nxt.setBackground(Color.WHITE);
		btn_nxt.setBorder(new LineBorder(Color.black, 2));
		lb1_valid.setBounds(250, 125,300,20);
		lb1_valid.setFont(new Font("Arial", Font.BOLD, 14));
		lb1_valid1.setBounds(250, 225,350,20);
		lb1_valid1.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valid2=new JLabel();
         lbl_valid2.setBounds(250, 177, 290, 20);
     	lbl_valid2.setFont(new Font("Arial", Font.BOLD, 14));
          //      Label l4=new Label("Incorrect password..Check ur password");
/*		Label l5=new Label("Do include:");
		Label l6=new Label("atleast one Lowercase  letter a-z");
		Label l7=new Label("atleast one Uppercase  letter A-Z");
		Label l8=new Label("atleast one digit  letter 0-9");
		Label l9=new Label("atleast one special character like \"@&!#*\"");
		Label l10=new Label("Length of the password atleast 8 characters");*/
		txt_fname.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				String regex =   "^[a-zA-Z\\s && [^0-9]&&[^!@#$^%&*+-]]{2,90}+$";
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
                 String s1 = "Use passwords like Hhrrsteam34@";
                 txt_password.setToolTipText(s1);
                 
                 
		txt_password.addMouseListener(new MouseListener() {
	 		
	 		@Override
	 		public void mouseReleased(MouseEvent e) {
	 			// TODO Auto-generated method stub
	 			
	 		}
	 		
	 		@Override
	 		public void mousePressed(MouseEvent e) {
	 			// TODO Auto-generated method stub
	 			
	 		}
	 		
	 		@Override
	 		public void mouseExited(MouseEvent e) {
	 			// TODO Auto-generated method stub
	 			
	 		}
	 		
	 		@Override
	 		public void mouseEntered(MouseEvent e) {
	 			// TODO Auto-generated method stub
	 			 String s = txt_password.getToolTipText(); 

	 		     txt_password.setToolTipText(s); 

	 			
	 		}
	 		
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			// TODO Auto-generated method stub
	 			
	 		}
	 	});
		txt_password.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                       
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        String s = txt_password.getToolTipText(); 

	 		     txt_password.setToolTipText(s); 

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       
                    }
                });
                txt_password.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String regex1 ="^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$!%*^&+=])"+"(?=\\S+$).{8,20}$";
				String value1=txt_password.getText();
				 boolean b1=Pattern.matches(regex1, value1);
				 
				 
				 
				 if(b1==false)
				 {
                                              lbl_valid2.setText("*please enter a valid password");  
                                              lbl_valid2.setForeground(Color.white);
                                              check4=false;
				 }
				 
				 else
				 {
					
						lbl_valid2.setForeground(Color.white);
                                                lbl_valid2.setText("*valid password");
                                                 check4=true;
						
						
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
				 if((b1==true) &&value1.charAt(0)=='0' || value1.charAt(0)=='1' || value1.charAt(0)=='2' || value1.charAt(0)=='3'||value1.charAt(0)=='4'||value1.charAt(0)=='5' )
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
/*				 else if(value1.charAt(0)=='0' || value1.charAt(0)=='1' || value1.charAt(0)=='2' || value1.charAt(0)=='3'||value1.charAt(0)=='4'||value1.charAt(0)=='5' )
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
		
		
		//ArrayList
		//ArrayList<String> al=new ArrayList<String>(); 
		
		btn_nxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=txt_fname.getText();
				String phn=txt_phno.getText();
				String mail=txt_email.getText();
				String address=txt_d1.getText();
                                String password=txt_password.getText();
                    
                                
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(txt_fname, "please enter the name");
				}
                                else if(password.isEmpty())
                                {
                                    JOptionPane.showMessageDialog(txt_fname, "please enter the password");
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
                                else if(check4==false)
                                {
                                              //  add(l4);
//						add(l5);
//						add(l6);
//						add(l7);
//						add(l8);
//						add(l9);
//						add(l10);
						
						JOptionPane.showMessageDialog(txt_password,"Incorrect password..Check ur password\nDo include:\natleast one Lowercase  letter a-z\natleast one Uppercase  letter A-Z\natleast one digit  letter 0-9\natleast one special character like \"@&!#*\"\nLength of the password atleast 8 characters");
						
                                    
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
					customertable_update(password,name, phn,mail,address);
                                        customerpg.setVisible(false);
                                        new CustomerLogin();
				}
				
				
				
				
			}
		});
		
		/*JCheckBox c1;
		c1=new JCheckBox("show password");
		 c1.setBounds(250, 180, 180, 30);
		 c1.setBackground(Color.WHITE);
		 c1.setFont(new Font("Arial", Font.BOLD, 20));
		c1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(c1.isSelected())
				{
					txt_password.setEchoChar((char)0);
					
					
					
				}
				else
				{
					txt_password.setEchoChar('*');
					
					
				}
				
			}
		});*/
		
		
		lbl_head.setBounds(100,40,300,25);
		lbl_fname.setBounds(100,100,100,25);
                lbl_password.setBounds(100,150,100,25);
		lbl_phno.setBounds(100,200,100,25);
                
		lbl_email.setBounds(100,250,100,25);
		lbl_dadd.setBounds(100,300,150,25);
		txt_fname.setBounds(250,100,300,25);
		txt_fname.setBorder(new LineBorder(Color.black));
		txt_password.setBounds(250, 150, 300, 25);
		txt_password.setBorder(new LineBorder(Color.black));
		txt_phno.setBounds(250,200,300,25);
		txt_phno.setBorder(new LineBorder(Color.black));
		txt_email.setBounds(250,250,300,25);
		txt_email.setBorder(new LineBorder(Color.black));
		txt_d1.setBounds(250,300,300,75);
		txt_d1.setBorder(new LineBorder(Color.black));
		btn_nxt.setBounds(220,520,200,40);
		
                
		
		customer.add(lb1_valid);
		customer.add(lb1_valid1);
		customer.add(lbl_valid2);
		customer.add(lbl_head);
		customer.add(lbl_fname);
                customer.add(lbl_password);
		customer.add(lbl_phno);
		customer.add(lbl_email);
		customer.add(lbl_dadd);
		customer.add(txt_fname);
		customer.add(txt_password);
              //  customer.add(c1);
		customer.add(txt_phno);
		customer.add(txt_email);
		customer.add(txt_d1);
		customer.add(btn_nxt);
		
		
      customerpg.setVisible(true);
      customerpg.setResizable(false);
	}
        public void customertable_update(String password,String fname,String phno,String email,String address)
    {
        try
        {
            int num=1;
            String customerid;
             Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            String query1 = "SELECT * FROM `customerdetails";
            ResultSet rs=st.executeQuery(query1);
            while(rs.next())
            {
                num++;
            }
            if(num>0 && num<=9)
            {
                customerid = "Customer00"+num;
            }
            else if(num>=10 && num<=99)
            {
                customerid= "Customer0"+num;
            }
            else
            {
                customerid = "Customer"+num;
            }
            
            try
            {
            String query = "INSERT INTO customerdetails VALUES ('"+customerid+"','"+fname+"','"+password+"','"+address+"','"+phno+"','"+email+"')";
            int result=st.executeUpdate(query);}
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"existing mail id");
            }
            
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("");
        }
    }
        public static void main(String ss[])
        {
            new CustomerRegisteration();
        }
}

