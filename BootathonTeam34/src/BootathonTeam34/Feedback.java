


package BootathonTeam34;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Feedback extends JFrame {

	public Feedback() {
		// TODO Auto-generated constructor stub
		//System.out.println(a);
		
		setTitle("customer feedback");
		   JButton send,back;
		   JTextField text1;
		setLayout(null);

		JTextArea textArea = new JTextArea();
		setDefaultCloseOperation(3);
		textArea.setBorder(new LineBorder(Color.black));
		textArea.setBounds(100, 50, 400, 200);
         add(textArea);
         
        back=new JButton("Back");
        back.setBounds(300, 300, 80, 30);
        back.setBackground(Color.white);
        add(back);
       
         
       send=new JButton("send");
       send.setBounds(180, 300, 80, 30);
       send.setBackground(Color.white);
       add(send);
       send.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a=textArea.getText();
			if(a.isEmpty())
			{
				JOptionPane.showMessageDialog(send,"Please give some feedback\n  to improve our site");
			}
			else
			{
             db(a);
         	setVisible(false);
			new Thanks();
			}
			
		}
	});
       
       back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new Thanks();
			
		}
	});
       
       
         
         setBounds(800,100,600,500);
         getContentPane().setBackground(new Color(0,204,204));
         setVisible(true);
	}
	void db(String a)
	{
		  try
		  {
	      Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");


		   Statement st=con.createStatement();

		   st.executeUpdate("insert into feedback(feedback) values('"+a+"')");

		   con.close();
		   System.out.println("Success!");
		  }
		  catch(Exception ee)
		  {
		   System.out.println("     "+ee);
		  }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new Feedback();

	}

}
