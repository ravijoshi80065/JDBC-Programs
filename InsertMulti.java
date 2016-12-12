package module1;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMulti {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String name;
		int roll;
		char ch='y';
				  final String JDBC_DRIVER="com.mysql.jdbc.Driver";
			  final String DB_URL="jdbc:mysql://localhost:3306/prj1";
			  System.out.println("Loading driver");
			  try {
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to database..........without including scroll");
			  Connection con=DriverManager.getConnection(DB_URL,"root","root");
			  Statement stmt=con.createStatement();
			  while(ch=='y'||ch=='Y')
			  {
				  System.out.println("Enter the roll no:");
				  roll=scanner.nextInt();
				  System.out.println("Enter the name:");
				  name=scanner.next();
				  System.out.println("Inserting "+roll+" "+name);
			  String sql="insert into student values ("+roll+",'"+name+"');";
			 // int result=stmt.executeUpdate("insert into student values (002,'Devyant');");
			  int result=stmt.executeUpdate(sql);
			  System.out.println(result +" rows afftected");
			  System.out.println("Do you want to enter more??press y if no press n");
			  ch = scanner.next().trim().charAt(0);
			  }
			  }
			  catch(Exception e)
			  {
				  System.out.print(e);
				  e.printStackTrace();
			  }
			  
			  System.out.println("The program has ended");
	}


}
