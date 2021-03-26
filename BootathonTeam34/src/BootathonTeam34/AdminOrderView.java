
package BootathonTeam34;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class AdminOrderView extends JFrame{
    //JFrame fra;
    JTable t;
    JScrollPane sp;
    ArrayList<String> order_id = new ArrayList<>();
    String Data;

    public AdminOrderView()  {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("1");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            //System.out.println("2");
            Statement st = con.createStatement();
            //String 
            //st.execute()
            //ResultSet rs = st.executeQuery("SELECT * FROM `order`");
            ResultSet rs = st.executeQuery("SELECT * FROM `Orders` ORDER BY `Orders`.`Order_id` DESC");
            while(rs.next())
            {
               String id = rs.getString(1);
               order_id.add(id);
               
            }
            System.out.println(order_id.size());
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        Object id [] = {"Id"};
        Object cols[][]= new Object[order_id.size()][1];
        //System.out.println(order_id.size());
        for(int i=0;i<order_id.size();i++)
        {
            String s = order_id.get(i);
            cols[i][0] = s;
        }
        t = new JTable(cols, id);
        t.setCellSelectionEnabled(true);
        t.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                //t.rowAtPoint(evt.getPoint());
                //t.columnAtPoint(evt.getPoint());
                String q = t.getValueAt(t.getSelectedRow(),0).toString();
                new display(q);
                
            }
});
        /*ListSelectionModel select = t.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Data = null;
                int [] row = t.getSelectedRows();
                int [] columns = t.getSelectedColumns();
                for(int i=0;i<row.length;i++)
                {
                    for(int j=0;j<columns.length;j++)
                    {
                        
                        Data = (String)t.getValueAt(row[i], columns[j]);
                        //new display(Data);
                    }
                }
                if(Data != null)
                {
                    new display(Data);
                    setVisible(false);
                }

                //System.out.println(Data);
                
                //new display(Data);
                //setVisible(false);
            }
        });*/
        
        
        
        
        sp = new JScrollPane(t);
        add(sp,BorderLayout.CENTER);
        setSize(600,600);
        setVisible(true);
        
        
        //t = new JTable(order_id, id);
        
    }
    public static void main(String args[])
    {
        new AdminOrderView();
    }
    
    
}
class display extends JFrame
{
    JFrame fr;
    JScrollPane sp;
    JButton b;
    JTable t;
    JLabel na,em,ph,ad;
    Object cols[][];
    Object rows[] = {"Product id","Product Name","Quantity","Price"};
    String name,phone,email,address;

    public display(String s) {
        //int num=0;
        String Bill_id =s;
        int num;
        num = count(Bill_id);
        Billstore(s, num);
        customerprint(s);
        fr = new JFrame();
        fr.setBounds(250, 0, 700, 700);
        Container c = fr.getContentPane();
        JPanel main = new JPanel();
        main.setBounds(250, 0, 700, 700);
        main.setLayout(null);
        JLabel header = new JLabel("Order details");
        header.setBounds(150, 20, 500, 30);
        main.add(header);
        
        t = new JTable(cols, rows);
        t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t.setShowGrid(true);
        t.setIntercellSpacing(new Dimension(20, 10));
        t.setGridColor(Color.black);
        t.setRowHeight(50);
        
        sp = new JScrollPane(t);
        
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        t.setVisible(true);
        sp.setBounds(0, 60, 700, 300);
        sp.setVisible(true);
        main.add(sp,BorderLayout.CENTER);
        
        //setLayout(new GridLayout(0,1));
        JLabel head = new JLabel("Customer Details");
        head.setBounds(0, 390, 700, 40);
        main.add(head);
        
        na = new JLabel(" Name:");
        na.setBounds(0, 430, 700, 40);
        main.add(na);
        JLabel name1 = new JLabel(name);
        name1.setBounds(110,430, 700, 40);
        main.add(name1);
        ad = new JLabel(" Address:");
        //ad.setText(address);
        ad.setBounds(0, 470, 700, 30);
        main.add(ad);
        JTextArea ad2 = new JTextArea(address);
        JScrollPane paneaddress = new JScrollPane(ad2);
       // paneaddress.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        paneaddress.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneaddress.setBounds(110, 470, 585, 70);
        ad2.setEditable(false);
        ad2.setBorder(new LineBorder(Color.black));
        main.add(paneaddress);
        ph = new JLabel(" Phone Number:");
        
        ph.setBounds(0,540,700 ,40 );
        main.add(ph);
        
        JLabel phone1 = new JLabel(phone);
        phone1.setBounds(110, 540, 700, 40);
        main.add(phone1);
        
        em = new JLabel(" Email:");
        em.setBounds(0, 580, 700, 40);
        main.add(em);
        
        JLabel emai1 = new JLabel(email);
        emai1.setBounds(110, 580, 700, 40);
        main.add(emai1);
        b = new JButton("Back");
        b.setBounds(310, 580, 100, 50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.setVisible(false);
                new AdminOrderView();
            }
        });
        main.add(b);
        
        
        
        
        
        c.add(main);
        fr.setVisible(true);
        fr.setResizable(false);
        
    }
    int count(String s)
    {
        int num=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            Statement st = con.createStatement();
            String str1 = "Select count(Product_id) from "+s;
            ResultSet rs = st.executeQuery(str1);
            while(rs.next())
            {
                 num = rs.getInt(1);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return num;
    }
    void Billstore(String s, int num)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            Statement st = con.createStatement();
            String str = "Select * from "+s;
            ResultSet rs1 = st.executeQuery(str);
            
            cols = new Object[num+1][4];
            
            int i=0;
            float net_price=0;
            while(rs1.next())
            {
                 cols[i][0] = rs1.getString(1);
                 cols[i][1] = rs1.getString(2);
                 cols[i][2] = rs1.getString(3);
                 cols[i][3] = rs1.getString(4);
                 float Price = Float.parseFloat(rs1.getString(4));
                 net_price = net_price+Price;
                 
                 i++;
                
            }
            cols[i][3]=net_price;
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            
            
    }
    void customerprint(String s)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
            
            Statement st = con.createStatement();
            
            
            String str2 = "Select * from customertable_update where Order_id = '"+s+"'";
            
            ResultSet rs2 = st.executeQuery(str2);
            
            while(rs2.next())
            {
                name = rs2.getString(2);
                phone = rs2.getString(3);
                email = rs2.getString(4);
                address = rs2.getString(5);
                
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
