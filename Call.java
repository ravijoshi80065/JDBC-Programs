package module1;
public class Call {

/*	static String url="jdbc:mysql://localhost:3306/sakila";
	static String us="root";
	static String pass="root";
	static String st="select * from actor;";
	*/
	 String url="jdbc:mysql://localhost:3306/sakila";
     String us="root";
	 String pass="root";
	 String st="select * from actor;";
	public static void main(String[] args) {
		Call c1=new Call();
		
	Process ob1=new Process();
	ob1.func(c1.url,c1.us,c1.pass,c1.st);

	}

}
