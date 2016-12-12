package module1;
import java.util.*;
import java.sql.*;
import java.sql.DriverManager;


public class BatchProcess {

	public static void main(String[] args)  throws Exception{

		Scanner scanner=new Scanner(System.in);
		char ch='Y';
		int roll;
		String name;
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/prj1";
		System.out.println("Loading driver................");
		Class.forName(JDBC_DRIVER);
		System.out.println("Coneecting to database................");
		Connection con=DriverManager.getConnection(DB_URL,"root","root");
		PreparedStatement stmt=con.prepareStatement("Insert into student values (?,?);");
		while (ch=='y'||ch=='Y')
		{
			System.out.println("Enter the roll :");
			roll=Integer.parseInt(scanner.nextLine());
			System.out.println("Enter the name :");
			name=scanner.nextLine();
			stmt.setInt(1, roll);
			stmt.setString(2, name);
			stmt.addBatch();
			System.out.println("Do you want to enter more ?Enter y if yes else n:");
			ch=scanner.nextLine().trim().charAt(0);
		}
stmt.executeBatch();
System.out.println("queries submitted...............");
con.close();
	}

}
