package module1;

import java.sql.*;
import java.sql.ResultSetMetaData;

public class ResultMeta {

	public static void main(String[] args) {
		try{
	
		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/prj1";
		System.out.println("Loading driver.............");
		Class.forName(JDBC_DRIVER);
		System.out.println("connecting to database.....................");
		Connection con=DriverManager.getConnection(DB_URL,"root","root");
		Statement stmt=con.createStatement();
		String sql="select * from student";
		ResultSet rs=stmt.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("Total column:"+rsmd.getColumnCount());
		System.out.println("Column name of 1st column:"+rsmd.getColumnName(1));
		System.out.println("Column type name of 1st column:"+rsmd.getColumnTypeName(1));
		System.out.println("second column details");
		System.out.println("Column name of 2nd column:"+rsmd.getColumnName(2));
		System.out.println("Column type name of 2nd column:"+rsmd.getColumnTypeName(2));
			
	}
		catch(Exception e)
		{
			System.out.println("Exception caught:"+e);
			e.printStackTrace();
		}
	}
}
