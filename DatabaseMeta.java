package module1;

import java.sql.*;

public class DatabaseMeta {

	public static void main(String[] args) {
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3306/prj1";
		try
		{
			Class.forName(JDBC_DRIVER);
			Connection con=DriverManager.getConnection(URL,"root","root");
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("Driver Name:"+dbmd.getDriverName());
			System.out.println("Driver version:"+dbmd.getDriverVersion());
			System.out.println("UserName:"+dbmd.getUserName());
			System.out.println("Database product name:"+dbmd.getDatabaseProductName());
			System.out.println("Database product version:"+dbmd.getDatabaseProductVersion());
			con.close();
		}
catch(Exception e)
		{
	System.out.println("Exception caught "+e);
	e.printStackTrace();
		}
	}

}
