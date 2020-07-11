package mobileOperator;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Scanner;

public class Register {

	public static User createUser() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter name, email and password:");
	    String name = scanner.nextLine();
	    String email = scanner.nextLine();
	    String password = scanner.nextLine();
	    User user=new User(name,email,password);
	    scanner.close();
	    return user;
	}
	
	
	public static Admin createAdmin() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter name, email and password:");
	    String name = scanner.nextLine();
	    String email = scanner.nextLine();
	    String password = scanner.nextLine();
	    Admin admin=new Admin(name,email,password);
	    scanner.close();
	    return admin;
	}
	
	public static  void setUserInDatabase(User user) {
		
     Calendar calendar = Calendar.getInstance();
	 java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	 String query = " insert into users (name,email,date_created,password)"+ " values (?, ?, ?,?)";   
	 try {
	 PreparedStatement preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
	 preparedStmt.setString (1, user.getName());
	 preparedStmt.setString (2, user.getEmail());
	 preparedStmt.setDate   (3, startDate);
	 preparedStmt.setString(4,  user.getPassword());
	 preparedStmt.execute();
	 System.out.println("Record is inserted in the table successfully");
	 }
	 catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	  }


 
public static  void setAdminInDatabase(Admin admin) {
	
   Calendar calendar = Calendar.getInstance();
   java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
   String query = " insert into admins (name,email,password,datecreated)" + " values (?, ?, ?,?)";
   try {
 PreparedStatement preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
 preparedStmt.setString (1, admin.getName());
 preparedStmt.setString (2, admin.getEmail());
 preparedStmt.setString(3,  admin.getPassword());
 preparedStmt.setDate  (4, startDate);
 preparedStmt.execute();
 System.out.println("Record is inserted in the table successfully");
 }
   
 catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }

}
