package mobileOperator;


import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Scanner;

public class ServiceStorage {

public static Service createService()
{
	 Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter typeService, price,end,userId and isActivated:");
	    String typeService = scanner.nextLine();
	    double price = scanner.nextDouble();
	    String end=scanner.next();
	    int userId=scanner.nextInt();
	    boolean isActivated=scanner.nextBoolean();
	    Service service=new Service(typeService,price,end,userId,isActivated);
	    scanner.close();
	    return service;
}

public static void setServiceInDatabase(Service service) {

     Calendar calendar = Calendar.getInstance();
	 java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
     String query = " insert into services (id,typeService,price,start,end,isActivated,user_id)" + " values (?, ?, ?,?,?,?,?)";
     try {
     PreparedStatement preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
	 preparedStmt.setInt (1, service.getId());
	 preparedStmt.setString (2, service.getTypeService());
	 preparedStmt.setDouble(3,  service.getPrice());
	 preparedStmt.setDate  (4, startDate);
	 preparedStmt.setString(5,  service.getEnd());
	 preparedStmt.setBoolean(7, service.getIsActivated());
	 preparedStmt.setInt (6, service.getUserId());
     preparedStmt.execute();
	 System.out.println("Record is inserted in the table successfully");
		}catch(Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	   }
	  }


}
