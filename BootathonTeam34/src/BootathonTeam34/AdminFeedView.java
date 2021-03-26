package BootathonTeam34;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

public class AdminFeedView extends JFrame{
	Container c=getContentPane();
	JTable tab;
	JScrollPane scroll; 
AdminFeedView()
{
	//JButton b
scroll=new JScrollPane();
scroll.setBounds(47, 71, 641, 262);
c.add(scroll);
tab= new JTable();
scroll.setViewportView(tab);
tab.setFont(new Font("Arial", Font.BOLD, 15));

try
{
	//Scanner sc=new Scanner(System.in);
	//String god="fruits";
	 Class.forName("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
String query1="select feed_id  from feedback order by feed_id desc";
PreparedStatement state=(PreparedStatement) con.prepareStatement(query1);
ResultSet rs=state.executeQuery();
tab.setModel(DbUtils.resultSetToTableModel(rs));
/*tab.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    public void valueChanged(ListSelectionEvent event) {
        // do some actions here, for example
        // print first column value from selected row
        System.out.println(tab.getValueAt(tab.getSelectedRow(), 0).toString());
        String q=tab.getValueAt(tab.getSelectedRow(), 0).toString();
        System.out.println("hello da");
       // new Adminfeed(q);
    }

	//@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hello da");
		
		new Adminfeed();
	//}
});*/

tab.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        //int row = tab.rowAtPoint(evt.getPoint());
        //int col = tab.columnAtPoint(evt.getPoint());
       // if (row >= 0 && col >= 0) {
            //......

        //}
    	System.out.println(tab.getValueAt(tab.getSelectedRow(), 0).toString());
    	 String q=tab.getValueAt(tab.getSelectedRow(), 0).toString();
    	 new AdminFeedDb(q);
    }
});
con.close();
}
catch(Exception exp)
{
//JOptionPane.showMessageDialog(load_btn,"Error Occured while connecting to database...");
	System.out.println("to err is human");
}



setTitle("View form");	
	setBounds(50, 20, 400, 650);
	setVisible(true);
}

public static void main(String a[])
{
 new AdminFeedView();	
}
}