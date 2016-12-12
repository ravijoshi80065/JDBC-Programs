package module1;

import java.sql.*;

public class Prepstate {

	public static void main(String[] args) {
  final String JDBC_DRIVER="com.mysql.jdbc.Driver";
  final String DB_URL="jdbc:mysql://localhost:3306/prj1";
  System.out.println("Loading driver");
  try {
  Class.forName(JDBC_DRIVER);
  System.out.println("Connecting to database..........without including scroll");
  Connection con=DriverManager.getConnection(DB_URL,"root","root");
 /* Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		  ResultSet.CONCUR_UPDATABLE); */
  Statement stmt=con.createStatement();
  ResultSet rs=stmt.executeQuery("select * from student");
  while(rs.next())
  {
	  System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|");
  }
  System.out.println("Now printing in rev order ");
  while(rs.previous())
  {
	  System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|");  
  }
  System.out.println("Now printing the third index ");
  rs.absolute(1);
  System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|");
  
	}
	catch(Exception e)
	{
		System.out.println("Exception caught :"+e );
		e.printStackTrace();
	}

}
}