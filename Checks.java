package mobileOperator;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Checks {

	public static  void checkForAdmin() {
		
		System.out.println("Enter name,email and password:");
		Scanner scanner = new Scanner(System.in);
		String searchedName = scanner.nextLine();
	    String searchedEmail = scanner.nextLine();
	    String searchedPassword = scanner.nextLine();
	    
	 try {
	     
	 String query = "SELECT * FROM admins";
     Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
	 ResultSet rs = st.executeQuery(query);
	 boolean isFound=false;
	 
	 while (rs.next())
	 {
	   String name = rs.getString("name");
	   String email = rs.getString("email");
	   String password=rs.getString("password");
	if(name.equals(searchedName) && email.equals(searchedEmail) && password.equals(searchedPassword)) {
		isFound=true;
	}
	
	} 
	 if(isFound==true) {
		 Menu.menuForAdmin();
	 }
	 else 
		 System.out.println("Not found an admin!");
	  st.close();
	 }
	catch (Exception e)
	{
	 System.err.println("Got an exception! ");
	 System.err.println(e.getMessage());
	}
	
	scanner.close();
	}
	
	public static String checkForUser() {
		System.out.println("Enter name,email and password:");
		Scanner scanner = new Scanner(System.in);
		String searchedName = scanner.nextLine();
	    String searchedEmail = scanner.nextLine();
	    String searchedPassword = scanner.nextLine();
	    
	 try {
	 String query = "SELECT * FROM users JOIN services ON users.id=services.user_id";
     Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
	 ResultSet rs = st.executeQuery(query);
	 
	 boolean isFound=false;
	
	 while (rs.next())
	 {
	   String name = rs.getString("name");
	   String email = rs.getString("email");
	   String password=rs.getString("password");
	   String typeService = rs.getString("typeService");
	   Date end = rs.getDate("end");
	   System.out.println("Service:");
	   System.out.println(typeService);
	   System.out.println("UserName:");
	   System.out.println(name);
	   System.out.println("You can pay for the services at the latest by:");
	   System.out.println(end);
	  if(name.equals(searchedName) && email.equals(searchedEmail) && password.equals(searchedPassword)) {
		isFound=true;
	  }
	  } 
	 if(isFound==false) {
	
		 System.out.println("Not found a user!");
	 }
	  st.close();
	 }
	catch (Exception e)
	{
	 System.err.println("Got an exception! ");
	 System.err.println(e.getMessage());
	}

	scanner.close();
	return searchedEmail;
		}
}
