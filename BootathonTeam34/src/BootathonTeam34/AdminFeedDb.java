package BootathonTeam34;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminFeedDb {
AdminFeedDb(String q)
{
	try
	{
String query="select * from feedback where feed_id='"+q+"'";
	//	String query="select * from feedback ";
Class.forName("com.mysql.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost/team34","team34","P@ssword34");
Statement  st=con.createStatement();
ResultSet rs = st.executeQuery(query);
while(rs.next()){
System.out.println(rs.getString("feedback"));
String feed=rs.getString("feedback");

new FeedViewGui(feed);

}
con.close();
	}
	catch(Exception ee)
	{
		System.out.println(ee);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
