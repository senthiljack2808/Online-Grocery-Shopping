package BootathonTeam34;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class AdminControl extends JFrame{
public AdminControl() {
	// TODO Auto-generated constructor stub
	Container c=getContentPane();
	JButton billdetails,stocks,feedback,home,previous;
	setTitle("AdminControl");
	setLayout(null);
	
	 ImageIcon iconss = new ImageIcon("C:\\\\Users\\\\Senthilkumar\\\\Documents\\\\boot camp--- java\\\\photos\\\\oie_EJ40mKvO0Eg2 (1).jpg");
     JLabel labels = new JLabel(iconss);
     labels.setBounds(350,0,500,500);
     //c.add(labels);
	 billdetails=new JButton("orders");
     billdetails.setBounds(290, 100, 100, 30);
     billdetails.setBorder(new LineBorder(Color.black));
     billdetails.setBackground(Color.white);
    add(billdetails);
     billdetails.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AdminOrderView();
		}
	});
	
     
     stocks =new JButton("Stocks");
     stocks.setBounds(290, 180, 100, 30);
     stocks.setBorder(new LineBorder(Color.black));
     stocks.setBackground(Color.white);
    add(stocks);
    
    stocks.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new Adminll();
		}
	});
    
    feedback =new JButton("Customer feedback");
    feedback.setBounds(265, 260, 150, 35);
    feedback.setBorder(new LineBorder(Color.black));
    feedback.setBackground(Color.white);
    add(feedback);
     
    feedback.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AdminFeedView();
		}
	});
	
    home=new JButton("HOME");
    home.setBounds(300,400,90,20);
    home.setBorder(new LineBorder(Color.black));
    home.setBackground(Color.white);
    add(home);
    
    previous=new JButton("PREVIOUS");
    previous.setBounds(200,400,90,20);
    previous.setBorder(new LineBorder(Color.black));
    previous.setBackground(Color.white);
    //add(previous);
    
    home.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new Grocery();
		}
	});
    
	setBounds(250, 20, 700, 650);
	getContentPane().setBackground(new Color(235,235,235));
	setVisible(true);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new AdminControl();
	}

}
