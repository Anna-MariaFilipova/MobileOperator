package mobileOperator;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class AdminOperations {
	
	public static void showServiceByUserName() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter name:");
		 String searchedname=scanner.nextLine();
		 try {
			String query = "SELECT users.name,users.email,services.typeService,services.end FROM users JOIN services ON users.id=services.user_id";
			 Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			 ResultSet rs = st.executeQuery(query);
			  while (rs.next())
			  {
			    String name = rs.getString("name");
			    String typeService = rs.getString("typeService");
			    Date end = rs.getDate("end");
			    if(name.equals(searchedname)) 
			    {
			    System.out.format("%s, %s, %s\n", name, typeService, end);
			  }
			    }
			  st.close();
			 }
			 catch (Exception e)
			 {
			  System.err.println("Got an exception! ");
			  System.err.println(e.getMessage());
			 }
		 scanner.close();
			 }

	public static void showUserNameByTypeOfService() {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter service:");
		 String searchedTypeService=scanner.nextLine();
		  try {
			     
			  String query = "SELECT users.name,users.email,services.typeService,services.end FROM users JOIN services ON users.id=services.user_id";
			  Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			  ResultSet rs = st.executeQuery(query);
			  while (rs.next())
			  {
			    String name = rs.getString("name");
			    String typeService = rs.getString("typeService");
			    Date end = rs.getDate("end");
			    if(typeService.equals(searchedTypeService)) {
			  
			    System.out.format("%s, %s, %s\n", name, typeService, end);
			  }
			    }
			  st.close();
			 }
			 catch (Exception e)
			 {
			  System.err.println("Got an exception! ");
			  System.err.println(e.getMessage());
			 }
		  scanner.close();
			 }


            public static void unpaidServices() {
             try {
            String query = "SELECT users.name,services.typeService,services.end FROM services JOIN users\r\n" + 
 		  "ON users.id=services.user_id\r\n" + 
 		  "WHERE services.end<now();";
           Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
           ResultSet rs = st.executeQuery(query);
           while (rs.next())
               {
           String name = rs.getString("name");
           String typeService = rs.getString("typeService");
           Date end = rs.getDate("end");
           System.out.format("%s, %s, %s\n", name, typeService, end);
           }
           st.close();      
     }
     catch (Exception e)
      {
     System.err.println("Got an exception! ");
     System.err.println(e.getMessage());
     }
   }

           

}
