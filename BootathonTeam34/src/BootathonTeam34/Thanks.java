package BootathonTeam34;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Thanks {
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
			new Feedback();
		}
	});
     
     f.setBounds(250, 20, 700, 650);
     f.setVisible(true);
	}
	
	public static void main(String a[])
	{
		new Thanks();
	}
}
