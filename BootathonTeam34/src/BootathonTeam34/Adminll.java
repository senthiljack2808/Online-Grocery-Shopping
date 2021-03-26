package BootathonTeam34;

/*public class Adminll {

}*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package admin_upgrade;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/*import fruits.F;
import vegetables.V;
import dairy.D;
import groceries.G;
*/
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Mohan
 */
public class Adminll {
        Adminll()
        {
        JFrame f=new JFrame();  
        f.setBounds(250, 0, 500,500);
    
        Container c=f.getContentPane();
        c.setBackground(new Color(0,100,204));
        
        
        
        JTabbedPane jp = new JTabbedPane(JTabbedPane.LEFT);
        //jp.setBounds(250,10,700,500);  
        jp.setSize(600, 600);
        
        
        jp.addTab("Fruits", new Fr());
        jp.addTab("Vegetables", new Ve());
        jp.addTab("Groceries", new Gr());
        jp.addTab("Dairy",new Da());
        
        
        
        //jp.addTab("Confirm Order", jp);
        c.add(jp);
        f.setResizable(true);
        f.setVisible(true);
        }
        public static void main(String[] args) {
        new Adminll();
    }
}

class  Fr extends JPanel
{
    
   JButton b1,b2,b3,b4,b5;
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JFrame Frame=new JFrame();
    
    Fr()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        
        b5=new JButton("back");
        c.weighty=0.5;
        c.gridx=2;
        c.gridy=7;
        add(b5,c);
        
        b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminControl();
			}
		});
        
        l1=new JLabel("Product_Id");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=2;
        add(l1,c);
        
        l2=new JLabel("Product_Name");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=3;
        add(l2,c);
        
        l3=new JLabel("Price");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=4;
        add(l3,c);
        
        l4=new JLabel("Quantity");
        
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=5;
        //add(l4,c);
        
       
        
        t1=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=2;
        add(t1,c);
        
        t2=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=3;
        add(t2,c);
        
        t3=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=4;
        add(t3,c);
        
        t4=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
       // t4.setBounds(0, 0, 100, 30);
        c.gridx=2;
        c.gridwidth = 1;
        c.gridy=5;
        //add(t4,c);
        
        b2=new JButton("update");
        //c.fill=GridBagConstraints.VERTICAL;
        c.insets = new Insets(150,0,0,0);
        c.weightx=1;
      //  c.weighty=0;
        c.gridx=1;
        c.gridy=6;
        add(b2,c);
        
        
        b3=new JButton("delete");
        c.weightx=1;
        c.gridx=2;
        c.gridy=6;
        add(b3,c);
        
        b4=new JButton("edit");
        c.weightx=1;
        c.gridx=3;
        c.gridy=6;
        add(b4,c);
        
        b1=new JButton("Veiw");
       c.insets = new Insets(0,0,100,0);
//        c.gridwidth = 1;
     //   c.weighty=0;
        c.gridx=2;
        c.gridy=0;
        add(b1,c);
        
       
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Veiwfruits();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	  String id=t1.getText();
                      String name=t2.getText();
                      String p=t3.getText();
                      Float price=Float.parseFloat(p);
                      String quantity="1";
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("insert into fruits values('"+id+"','"+name+"','"+price+"','"+quantity+"')");
                    JOptionPane.showMessageDialog(Frame,"updation succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	 JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                
                
                try
                {
                	String id=t1.getText();
                	if(id.isEmpty())
                	{
                		JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                	}
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from fruits");
                    while(rs.next())
                    {
                        if(id.equals(rs.getString("Product_id")))
                        {
                            String query_d="DELETE FROM fruits WHERE Product_id='"+id+"'";
                            st.executeUpdate(query_d);
                            JOptionPane.showMessageDialog(Frame,"deletion succesful");
                        }
                    }
                    con.close();
                    
                }
                catch(Exception exp)
                {
                	//JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("");
                }
            }
        });
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	String id=t1.getText();
                    String p=t3.getText();
                   Float price=Float.parseFloat(p);
                   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("update fruits set Price="+price+"where Product_id='"+id+"'");
                    JOptionPane.showMessageDialog(Frame,"edited succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
    }

    
}
class Veiwfruits extends JFrame{
	Container c=getContentPane();
	JTable tab;
	JFrame Frame;
	JScrollPane scroll; 
       
    public Veiwfruits()
    {
     
        try
        {
        	   scroll=new JScrollPane();
               c.add(scroll);
               tab= new JTable();
               scroll.setViewportView(tab);
               tab.setFont(new Font("Arial", Font.BOLD, 16));

	
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            String query1="select * from fruits";
            PreparedStatement state=(PreparedStatement) con.prepareStatement(query1);
            ResultSet rs=state.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }
        catch(Exception exp)
        {
        	JOptionPane.showMessageDialog(Frame,"empty");
            System.out.println("to err is human");
        }
        setTitle("View form");	
	setBounds(250, 20, 600, 600);
	setVisible(true);
    }
    
}

class  Ve extends JPanel
{
    JButton b1,b2,b3,b4,b5;
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JFrame Frame=new JFrame();
    
    Ve()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        
        b5=new JButton("back");
        c.weighty=0.5;
        c.gridx=2;
        c.gridy=7;
        add(b5,c);
        
        b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminControl();
			}
		});
        
        
        l1=new JLabel("Product_Id");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=2;
        add(l1,c);
        
        l2=new JLabel("Product_Name");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=3;
        add(l2,c);
        
        l3=new JLabel("Price");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=4;
        add(l3,c);
        
        l4=new JLabel("Quantity");
        
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=5;
       // add(l4,c);
        
        t1=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=2;
        add(t1,c);
        
        t2=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=3;
        add(t2,c);
        
        t3=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=4;
        add(t3,c);
        
        t4=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
       // t4.setBounds(0, 0, 100, 30);
        c.gridx=2;
        c.gridwidth = 1;
        c.gridy=5;
        //add(t4,c);
        
        b2=new JButton("update");
        //c.fill=GridBagConstraints.VERTICAL;
        c.insets = new Insets(150,0,0,0);
        c.weightx=1;
      //  c.weighty=0;
        c.gridx=1;
        c.gridy=6;
        add(b2,c);
        
        
        b3=new JButton("delete");
        c.weightx=1;
        c.gridx=2;
        c.gridy=6;
        add(b3,c);
        
        b4=new JButton("edit");
        c.weightx=1;
        c.gridx=3;
        c.gridy=6;
        add(b4,c);
        
        b1=new JButton("Veiw");
       c.insets = new Insets(0,0,100,0);
//        c.gridwidth = 1;
     //   c.weighty=0;
        c.gridx=2;
        c.gridy=0;
        add(b1,c);
        
       
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Veiwvegetables();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	String id=t1.getText();
                    String name=t2.getText();
                    String p=t3.getText();
                    Float price=Float.parseFloat(p);
                    String quantity="1";
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("insert into vegetable values('"+id+"','"+name+"','"+price+"','"+quantity+"')");
                    JOptionPane.showMessageDialog(Frame,"updation succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                
                
                try
                {
                	String id=t1.getText();
                	if(id.isEmpty())
                	{
                		JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                	}
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from vegetable");
                    while(rs.next())
                    {
                        if(id.equals(rs.getString("Product_id")))
                        {
                            String query_d="DELETE FROM vegetable WHERE Product_id='"+id+"'";
                            st.executeUpdate(query_d);
                            JOptionPane.showMessageDialog(Frame,"deletion succesful");
                        }
                    }
                    con.close();
                    
                }
                catch(Exception exp)
                {
                	//JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("");
                }
            }
        });
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                
                {
                	 String id=t1.getText();
                     String p=t3.getText();
                    Float price=Float.parseFloat(p);
                   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("update vegetable set Price="+price+"where Product_id='"+id+"'");
                    JOptionPane.showMessageDialog(Frame,"edited succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
    }

    
}

    

class Veiwvegetables extends JFrame{
	Container c=getContentPane();
	JTable tab;
	JScrollPane scroll; 
	JFrame Frame;
       
    public Veiwvegetables()
    {
        
        try
        {
        	scroll=new JScrollPane();
            c.add(scroll);
            tab= new JTable();
            scroll.setViewportView(tab);
            tab.setFont(new Font("Arial", Font.BOLD, 16));

	
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            String query1="select * from vegetable";
            PreparedStatement state=(PreparedStatement) con.prepareStatement(query1);
            ResultSet rs=state.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }
        catch(Exception exp)
        {
        	JOptionPane.showMessageDialog(Frame,"empty");
            System.out.println("to err is human");
        }
        setTitle("View form");	
	setBounds(250, 20, 600, 600);
	setVisible(true);
    }
    
}

class  Gr extends JPanel
{
    JButton b1,b2,b3,b4,b5;
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JFrame Frame=new JFrame();
    
    Gr()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        
        b5=new JButton("back");
        c.weighty=0.5;
        c.gridx=2;
        c.gridy=7;
        add(b5,c);
        
        b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminControl();
			}
		});
        
        l1=new JLabel("Product_Id");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=2;
        add(l1,c);
        
        l2=new JLabel("Product_Name");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=3;
        add(l2,c);
        
        l3=new JLabel("Price");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=4;
        add(l3,c);
        
        l4=new JLabel("Quantity");
        
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=5;
       // add(l4,c);
        
        t1=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=2;
        add(t1,c);
        
        t2=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=3;
        add(t2,c);
        
        t3=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=4;
        add(t3,c);
        
        t4=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
       // t4.setBounds(0, 0, 100, 30);
        c.gridx=2;
        c.gridwidth = 1;
        c.gridy=5;
        //add(t4,c);
        
        b2=new JButton("update");
        //c.fill=GridBagConstraints.VERTICAL;
        c.insets = new Insets(150,0,0,0);
        c.weightx=1;
      //  c.weighty=0;
        c.gridx=1;
        c.gridy=6;
        add(b2,c);
        
        
        b3=new JButton("delete");
        c.weightx=1;
        c.gridx=2;
        c.gridy=6;
        add(b3,c);
        
        b4=new JButton("edit");
        c.weightx=1;
        c.gridx=3;
        c.gridy=6;
        add(b4,c);
        
        b1=new JButton("Veiw");
       c.insets = new Insets(0,0,100,0);
//        c.gridwidth = 1;
     //   c.weighty=0;
        c.gridx=2;
        c.gridy=0;
        add(b1,c);
        
       
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Veiwgroceries();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	String id=t1.getText();
                    String name=t2.getText();
                    String p=t3.getText();
                    Float price=Float.parseFloat(p);
                    String quantity="1";
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("insert into groceries values('"+id+"','"+name+"','"+price+"','"+quantity+"')");
                    JOptionPane.showMessageDialog(Frame,"updation succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             
                
                
                try
                {
                	   String id=t1.getText();
                	   if(id.isEmpty())
                   	{
                   		JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                   	}
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from groceries");
                    while(rs.next())
                    {
                        if(id.equals(rs.getString("Product_id")))
                        {
                            String query_d="DELETE FROM groceries WHERE Product_id='"+id+"'";
                            st.executeUpdate(query_d);
                            JOptionPane.showMessageDialog(Frame,"deletion succesful");
                        }
                    }
                    con.close();
                    
                }
                catch(Exception exp)
                {
                	//JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("");
                }
            }
        });
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	String id=t1.getText();
                    String p=t3.getText();
                   Float price=Float.parseFloat(p);
                   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("update groceries set Price="+price+"where Product_id='"+id+"'");
                    JOptionPane.showMessageDialog(Frame,"edited succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
    }

    
}

    

class Veiwgroceries extends JFrame{
	Container c=getContentPane();
	JTable tab;
	JScrollPane scroll; 
	JFrame Frame;
       
    public Veiwgroceries()
    {
        
        try
        {
        	scroll=new JScrollPane();
            c.add(scroll);
            tab= new JTable();
            scroll.setViewportView(tab);
            tab.setFont(new Font("Arial", Font.BOLD, 16));

	
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            String query1="select * from groceries";
            PreparedStatement state=(PreparedStatement) con.prepareStatement(query1);
            ResultSet rs=state.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }
        catch(Exception exp)
        {
        	JOptionPane.showMessageDialog(Frame,"empty");
            System.out.println("to err is human");
        }
        setTitle("View form");	
	setBounds(250, 20, 600, 600);
	setVisible(true);
    }
    
}
class  Da extends JPanel
{
    JButton b1,b2,b3,b4,b5;
    JTextField t1,t2,t3,t4;
    JLabel l1,l2,l3,l4;
    JFrame Frame=new JFrame();
    
    Da()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        
        b5=new JButton("back");
        c.weighty=0.5;
        c.gridx=2;
        c.gridy=7;
        add(b5,c);
        
        b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminControl();
			}
		});
        
        l1=new JLabel("Product_Id");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=2;
        add(l1,c);
        
        l2=new JLabel("Product_Name");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=3;
        add(l2,c);
        
        l3=new JLabel("Price");
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=4;
        add(l3,c);
        
        l4=new JLabel("Quantity");
        
        c.weightx=0.5;
        c.gridx=1;
        c.gridy=5;
        //add(l4,c);
        
        t1=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=2;
        add(t1,c);
        
        t2=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=3;
        add(t2,c);
        
        t3=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=4;
        add(t3,c);
        
        t4=new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
       // t4.setBounds(0, 0, 100, 30);
        c.gridx=2;
        c.gridwidth = 1;
        c.gridy=5;
        //add(t4,c);
        
        b2=new JButton("update");
        //c.fill=GridBagConstraints.VERTICAL;
        c.insets = new Insets(150,0,0,0);
        c.weightx=1;
      //  c.weighty=0;
        c.gridx=1;
        c.gridy=6;
        add(b2,c);
        
        
        b3=new JButton("delete");
        c.weightx=1;
        c.gridx=2;
        c.gridy=6;
        add(b3,c);
        
        b4=new JButton("edit");
        c.weightx=1;
        c.gridx=3;
        c.gridy=6;
        add(b4,c);
        
        b1=new JButton("Veiw");
       c.insets = new Insets(0,0,100,0);
//        c.gridwidth = 1;
     //   c.weighty=0;
        c.gridx=2;
        c.gridy=0;
        add(b1,c);
        
       
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Veiwdairy();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	 String id=t1.getText();
                     String name=t2.getText();
                     String p=t3.getText();
                     Float price=Float.parseFloat(p);
                     String quantity="1";
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("insert into dairy values('"+id+"','"+name+"','"+price+"','"+quantity+"')");
                    JOptionPane.showMessageDialog(Frame,"updation succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                
                
                try
                {
                	String id=t1.getText();
                	if(id.isEmpty())
                	{
                		JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                	}
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from dairy");
                    while(rs.next())
                    {
                        if(id.equals(rs.getString("Product_id")))
                        {
                            String query_d="DELETE FROM dairy WHERE Product_id='"+id+"'";
                            st.executeUpdate(query_d);
                            JOptionPane.showMessageDialog(Frame,"deletion succesful");
                        }
                    }
                    con.close();
                    
                }
                catch(Exception exp)
                {
                	//JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("");
                }
            }
        });
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                try
                {
                	String id=t1.getText();
                    String p=t3.getText();
                   Float price=Float.parseFloat(p);
                   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
                    Statement st=con.createStatement();
                    st.executeUpdate("update dairy set Price="+price+"where Product_id='"+id+"'");
                    JOptionPane.showMessageDialog(Frame,"edited succesful");
                    con.close();
                }
                catch(Exception exp)
                {
                	JOptionPane.showMessageDialog(Frame,"empty or invalid data");
                    System.out.println("error in update ");
                }
            }
        });
    }

    
}

    

class Veiwdairy extends JFrame{
	Container c=getContentPane();
	JTable tab;
	JScrollPane scroll; 
	JFrame Frame;
       
    public Veiwdairy()
    {
       
        try
        {
        	 scroll=new JScrollPane();
             c.add(scroll);
             tab= new JTable();
             scroll.setViewportView(tab);
             tab.setFont(new Font("Arial", Font.BOLD, 16));

	
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            String query1="select * from dairy";
            PreparedStatement state=(PreparedStatement) con.prepareStatement(query1);
            ResultSet rs=state.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        }
        catch(Exception exp)
        {
        	JOptionPane.showMessageDialog(Frame,"empty");
            System.out.println("to err is human");
        }
        setTitle("View form");	
	setBounds(250, 20, 600, 600);
	setVisible(true);
    }
   
}