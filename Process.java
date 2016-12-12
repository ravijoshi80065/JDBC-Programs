package module1;
import java.sql.*;
public class Process {
	public void setup()
	{
		
	}
public void func(String url,String us,String pass,String st)
{
try {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Conneting to the database ");
	Connection con=DriverManager.getConnection(url,us,pass);
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery(st);  
	while(rs.next())
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	con.close();
	
}
catch (Exception e)
{
	System.out.println(e);
}
}
}
