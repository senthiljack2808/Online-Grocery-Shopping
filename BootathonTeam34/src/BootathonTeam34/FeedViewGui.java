package BootathonTeam34;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class FeedViewGui extends JFrame{
	
public FeedViewGui(String feed) {
	// TODO Auto-generated constructor stub
	JButton back;
	setLayout(null);
	setTitle("Feedback");
   // setDefaultCloseOperation(3);
	JTextArea textArea = new JTextArea();
	setDefaultCloseOperation(3);
	textArea.setBorder(new LineBorder(Color.black));
	textArea.setBounds(100, 100, 450, 200);
	textArea.setEditable(false);
	textArea.setText(feed);
     add(textArea);
    back=new JButton("BACK");
    back.setBounds(300, 345, 80, 30);
    back.setBorder(new LineBorder(Color.black));
    back.setBackground(Color.white);
    add(back);
    
    back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			//new AdminFeedView();
			
		}
	});
     
     setBounds(250, 80, 700, 450);
     getContentPane().setBackground(new Color(230,255,0));
	setVisible(true);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new FeedViewGui("");
	}

}
