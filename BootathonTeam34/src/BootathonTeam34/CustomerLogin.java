package BootathonTeam34;


/**
 *
 * @author harshitha vasudevan
 */

    import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package grocery;
import javax.swing.*;

public class CustomerLogin extends JFrame {
	Button b1,b2,b3,b4;
	Container c=getContentPane();
        public String email_id;
	
	CustomerLogin()
	{
	 
		c.setFont(new Font("Arial",Font.BOLD,18));
		setTitle("Login page");
		
		//icon setting
		 //Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Senthilkumar\\Documents\\boot camp--- java\\photos\\lock.jpg");
		 //setIconImage(icon);
		 
		//setContentPane(new JLabel(new ImageIcon("C:\\\\Users\\\\Senthilkumar\\\\Documents\\\\boot camp--- java\\\\photos\\\\strawberries-528791__340.jpg")));
		 //ImageIcon iconss = new ImageIcon("C:\\\\Users\\\\Senthilkumar\\\\Documents\\\\boot camp--- java\\\\photos\\\\logo2.jpg");
	     /* JLabel labels = new JLabel(iconss);
	      labels.setBounds(400,0,500,500);
	      c.add(labels);*/
	      
//	      ImageIcon icons1 = new ImageIcon("C:\\\\Users\\\\Senthilkumar\\\\Documents\\\\boot camp--- java\\\\photos\\\\lock.jpg");
//	      JLabel label = new JLabel(icons1);
//	      label.setBounds(200,0,500,500);
//	      c.add(label);
		 
		 //closing
		setDefaultCloseOperation(3);
		TextField t1;
		 JPasswordField t2,t3;
		Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
		JCheckBox c1;
		c1=new JCheckBox("show password");
		 c1.setBounds(230, 300, 180, 30);
		 c1.setBackground(Color.WHITE);
		 c1.setFont(new Font("Arial", Font.BOLD, 20));
		 c.add(c1);
		 
		//text,password field
		 
		t1=new TextField();
		t2=new JPasswordField();
		
		t1.setBounds(230, 150, 170, 30);
		t2.setBounds(230, 200, 170, 30);
		t2.setEchoChar('*');
		
		c.add(t1);
		c.add(t2);
		
		l1=new Label("Email_id:");
		l2=new Label("password:");
		
/*		l4=new Label("Incorrect password..Check ur password");
		l5=new Label("Do include:");
		l6=new Label("atleast one Lowercase  letter a-z");
		l7=new Label("atleast one Uppercase  letter A-Z");
		l8=new Label("atleast one digit  letter 0-9");
		l9=new Label("atleast one special character like \"@&!#*\"");
		l10=new Label("Length of the password atleast 8 characters");*/
		
		
		l1.setFont(new Font("Arial",Font.BOLD,20));
		l2.setFont(new Font("Arial",Font.BOLD,20));
		
		
		
		
		
		l1.setBounds(107, 150, 100, 30);
		l2.setBounds(107, 200, 100, 30);
		
		/*l4.setBounds(330, 150, 320, 30);
		l5.setBounds(330, 175, 320, 30);
		l6.setBounds(330, 198, 320, 30);
		l7.setBounds(330, 221, 320, 30);
		l8.setBounds(330, 244, 320, 30);
		l9.setBounds(330, 267, 320, 30);
		l10.setBounds(330, 290, 320, 30);*/
		add(l1);
		add(l2);
		
		
		/*
		l4.setBackground(Color.WHITE);
		l5.setBackground(Color.WHITE);
		l6.setBackground(Color.WHITE);
		l7.setBackground(Color.WHITE);
		l8.setBackground(Color.WHITE);
		l9.setBackground(Color.WHITE);
		l10.setBackground(Color.WHITE);
		*/
		
		//tooltip
		//tooltip s = new tooltip();
	     

	     // set tooltip text 
	     /*t2.setToolTipText(s1);
	     
	     t2.addMouseListener(new MouseListener() {
	 		
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
	 			 String s = t2.getToolTipText(); 

	 		     t2.setToolTipText(s); 

	 			
	 		}
	 		
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			// TODO Auto-generated method stub
	 			
	 		}
	 	});*/
	     
	     
	     
	     
		
		b1=new Button("login");
		b1.setBounds(150, 400, 100, 30);
		b1.setFont(new Font("Arial",Font.BOLD,20));
		c.add(b1);
		
		b2=new Button("new user");
		b2.setBounds(70, 400, 100, 30);
		b2.setBounds(150, 520,100,30);
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new CustomerRegisteration();
                    }
                });
                
		c.add(b2);
		
		b3=new Button("Home");
		b3.setBounds(150,460,100,30);
		b3.setFont(new Font("Arial",Font.BOLD,20));
		c.add(b3);
		
		/*b4=new Button("Forget password");
		b4.setBounds(110, 520, 200, 30);
		b4.setFont(new Font("Arial",Font.BOLD,20));
		c.add(b4);*/
		

		

		
		//previous page
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Grocery();
				
			}
		});
		
		
		/*
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//setVisible(false);
				//new customer();
				
			}
		});*/
		
		
		//password validation and fetch from database
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ur=t1.getText();
				String a=t2.getText();
				//String b=t3.getText();
				if(ur.isEmpty())
				{
					JOptionPane.showMessageDialog(t1, "Please enter the username");
				}
				else if(a.isEmpty())
				{
					JOptionPane.showMessageDialog(t2,"Please enter the Password");
				}
                                else if(!a.isEmpty()&&!ur.isEmpty())
					{
						
						setVisible(false);
						check(ur,a);
						
					}
                        }
                                });
				/*else if(b.isEmpty())
				{
					JOptionPane.showMessageDialog(t3,"Please enter the confirm password");
				}
				
				else if(!a.equals(b))
				{

					
//					
//					c.add(l4);
//					c.add(l5);
//					c.add(l6);
//					c.add(l7);
//					c.add(l8);
//					c.add(l9);
//					c.add(l10);	
					JOptionPane.showMessageDialog(t2,"Incorrect password..Check ur password\nDo include:\natleast one Lowercase  letter a-z\natleast one Uppercase  letter A-Z\natleast one digit  letter 0-9\natleast one special character like \"@&!#*\"\nLength of the password atleast 8 characters");
					
					
				}
				else if(a.equals(b)) 
				{
					String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$!%*^&+=])"+"(?=\\S+$).{8,20}$";
			      
			                
					boolean p=Pattern.matches(regex, a);
					if(p==false)
					{
//						add(l4);
//						add(l5);
//						add(l6);
//						add(l7);
//						add(l8);
//						add(l9);
//						add(l10);
						
						JOptionPane.showMessageDialog(t2,"Incorrect password..Check ur password\nDo include:\natleast one Lowercase  letter a-z\natleast one Uppercase  letter A-Z\natleast one digit  letter 0-9\natleast one special character like \"@&!#*\"\nLength of the password atleast 8 characters");
						
					}
					
				}
				
			}
		});
		*/
		
/*t2.addMouseListener(new MouseListener() {
			
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
				c.remove(l4);
				c.remove(l5);
				c.remove(l6);
				c.remove(l7);
				c.remove(l8);
				c.remove(l9);
				c.remove(l10);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
			}
		});*/
		
		
     //show password checkbox
		t2.setFont(new Font("Arial", Font.BOLD, 18));
		
		 c1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(c1.isSelected())
				{
					t2.setEchoChar((char)0);
					
					
					
				}
				else
				{
					t2.setEchoChar('*');
					
					
				}
				
			}
		});
		
		setLayout(null);
		c.setBackground(new Color(0,204,204));
		setBounds(250, 20, 900, 720);
		setResizable(false);
		setVisible(true);
		
	}
        public void check(String uname,String password)
        {
            try
            {
                int flag=0;
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            String query1 = "SELECT * FROM `customerdetails";
            ResultSet rs=st.executeQuery(query1);
            while(rs.next())
            {
                if(rs.getString(6).equals(uname))
                {
                    
                    flag=1;
                    if(rs.getString(3).equals(password))
                    {
                        email_id=uname;
                        setVisible(false);
                        new CustomerHomePage(email_id);
                        //JOptionPane.showMessageDialog(null,"quantity is given in Kg");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect password");
                        new CustomerLogin();
                    }
                }
                
            }
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"Incorrect Email_id");
                new CustomerLogin();
            }
            
            
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerLogin();

	}

}


