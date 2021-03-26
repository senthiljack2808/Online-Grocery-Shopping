package BootathonTeam34 ;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package grocery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author harshitha vasudevan
 */
public class Grocery {

    public  Grocery()
    {
        
        JFrame f=new JFrame();
        f.setBounds(250, 0, 700, 650);
        f.setDefaultCloseOperation(3);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\harshitha vasudevan\\Pictures\\bootcamp project\\icon.jpg");
        f.setIconImage(icon);
        f.setTitle("farm fresh");
        f.setContentPane(new JLabel(new ImageIcon("C:\\\\\\\\Users\\\\\\\\Senthilkumar\\\\\\\\Documents\\\\\\\\boot camp--- java\\\\\\\\photos\\\\\\\\image67.jpg")));
        Container c=f.getContentPane();
        FlowLayout fl=new FlowLayout();
   
        c.setLayout(fl);
        JLabel l1=new JLabel("Farm Fresh");
        l1.setForeground(new Color(91, 60, 8 ));
        l1.setBounds(600, 20, 50, 50);
        l1.setFont(new Font("Calibri",1,50));
       c.add(l1);
       JLabel l2=new JLabel("                                        -a one-step grocery store ");
        l2.setForeground(new Color(91, 60, 8 ));
        l2.setBounds(510, 35, 50, 50);
        l2.setFont(new Font("Ink Free",1,25));
       c.add(l2);
        JButton b1=new JButton("shop now");
        b1.setBounds(450,500,50,50);
        b1.setBackground(new Color(29, 178, 170));
        b1.setForeground(new Color(91, 60, 8 ));
        b1.setFont(new Font("Calibri",0,20));
        c.add(b1);
        JButton b2=new JButton("Admin Login");
        b2.setBounds(450,500,50,50);
        b2.setBackground(new Color(29, 178, 170));
        b2.setForeground(new Color(91, 60, 8 ));
        b2.setFont(new Font("Calibri",0,20));
        c.add(b2);
        f.setResizable(false);
        f.setVisible(true);
        
        
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new CustomerLogin();
			}
		});
        
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 f.setVisible(false);
				new Login();
				
				
			}
		});
        
    }
    public static void main(String[] args) {
       new Grocery();
        
    }
    
}
