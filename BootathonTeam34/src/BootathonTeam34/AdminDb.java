package BootathonTeam34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminDb extends JFrame {
	
	AdminDb(String ur,String p)
	{
		JTextField t1=new JTextField();
	
		System.out.println(ur);
		System.out.println(p);
		try
		{
			int flag=0;
			String query="select * from admin_details";
			 Class.forName("com.mysql.jdbc.Driver");

			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");

			   Statement st=con.createStatement();
			   ResultSet rs=st.executeQuery(query);
			   while(rs.next())
			   {
				   if(ur.equals(rs.getString("admin_name")))
				   {
					   if(p.equals(rs.getString("password")))
					   {
						
						
						   new AdminControl();
						   flag=1;
						   break;
					   }
				   }
			   }
			   if(flag==0)
			   {
				   JOptionPane.showMessageDialog(t1,"Incorrect user name or Password");
				   new Login();
			   }
            con.close();
            System.out.println("Success!");
			
		}
		catch(Exception ee)
		{
		System.out.println("to err is human");	
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
        