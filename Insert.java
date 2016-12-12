package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String name="Alok";
		int roll=003;
				  final String JDBC_DRIVER="com.mysql.jdbc.Driver";
			  final String DB_URL="jdbc:mysql://localhost:3306/prj1";
			  System.out.println("Loading driver");
			  try {
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to database..........without including scroll");
			  Connection con=DriverManager.getConnection(DB_URL,"root","root");
			  Statement stmt=con.createStatement();
			  String sql="insert into student values ("+roll+",'"+name+"');";
			 // int result=stmt.executeUpdate("insert into student values (002,'Devyant');");
			  int result=stmt.executeUpdate(sql);
			  System.out.println(result +" rows afftected");
			  }
			  catch(Exception e)
			  {
				  System.out.print(e);
				  e.printStackTrace();
			  }
			  
	}

}
