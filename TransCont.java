package module1;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class TransCont {
	public static Scanner scanner =new Scanner(System.in);
	
	public static void validate(Connection con)
	{
		int roll;
		String name;
		char ch;
	String sql="Select * from student";
	try{
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	System.out.println("Roll   Name");
	while(rs.next())
	{
		roll=rs.getInt(1);
		name=rs.getString(2);
		System.out.println(roll+" | "+name);
	}
	System.out.println("Do you want to commit or rollback");
	ch=scanner.nextLine().trim().charAt(0);
	if(ch=='r'|| ch=='R')
	{
		System.out.println("Rolling back the changes");
	stmt.executeQuery("rollback");
	}
	else
	{
		System.out.println("Commiting the changes");
		stmt.executeQuery("commit");	
	}
	}
	catch(Exception e)
	{
		System.out.println("Exception caught:"+e);
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/prj1";
		System.out.println("Loading driver.............");
		
		System.out.println("creating a connection...............");
		int result,roll;
		String name;
		char ch='Y';
		try
		{   
			Class.forName(JDBC_DRIVER);
			Connection con=DriverManager.getConnection(DB_URL,"root","root");
			Statement st_auto_com=con.createStatement();
			st_auto_com.executeQuery("set autocommit=0;");
			PreparedStatement stmt=con.prepareStatement("insert into student values (?,?)");
			//PreparedStatement stmt=con.prepareStatement("insert into student values (?,?)");
			while(ch=='Y'||ch=='y')
			{
			System.out.println("Enter the roll no:");
			roll=Integer.parseInt(scanner.nextLine());
			System.out.println("Enter the name :");
			name=scanner.nextLine();
			System.out.println("Inserting roll:"+roll+" and name:"+name);
			stmt.setInt(1, roll);
			stmt.setString(2,name);
			result=stmt.executeUpdate();
			System.out.println(result+" rows affected");
			validate(con);
			System.out.println("Do you want to insert more rows?press 'y' if yes :");
			ch=scanner.nextLine().trim().charAt(0);						
		}
		
	}
		catch (Exception e)
		{
			System.out.println("Exception caught:"+e);
			e.printStackTrace();			
		}
		finally
		{
			System.out.println("the program has ended");
		}
	}		
}