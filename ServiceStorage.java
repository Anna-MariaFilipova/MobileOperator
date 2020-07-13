package mobileOperator;

import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Scanner;

public class ServiceStorage {

	public static Service createService() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter typeService,end of service,last payment date,count minutes,count sms,count megabytes, price,userId and isActivated:");
		String typeService = scanner.nextLine();
		String endService = scanner.nextLine();
		String lastPaymentDate = scanner.nextLine();
		int countMinutes = scanner.nextInt();
		int countSMS = scanner.nextInt();
		int countMegabytes = scanner.nextInt();
		double price = scanner.nextDouble();
		int userId = scanner.nextInt();
		boolean isActivated = scanner.nextBoolean();
		
		Service service = new Service(typeService, endService, lastPaymentDate, countMinutes, countSMS, countMegabytes,
				price, userId, isActivated);
		scanner.close();
		return service;
	}

	public static void setServiceInDatabase(Service service) {
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		String query = " insert into services (id,typeService,price,startService,endService,lastPymentDate,countMinutes,countSMS,countMegabytes,user_id,isActivated)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
			preparedStmt.setInt(1, service.getId());
			preparedStmt.setString(2, service.getTypeService());
			preparedStmt.setDouble(3, service.getPrice());
			preparedStmt.setDate(4, startDate);
			preparedStmt.setString(5, service.getEndService());
			preparedStmt.setString(6, service.getLastPaymentDate());
			preparedStmt.setInt(7, service.getCountMinutes());
			preparedStmt.setInt(8, service.getCountSMS());
			preparedStmt.setInt(9, service.getCountMegabytes());
		
			preparedStmt.setInt(10, service.getUserId());
			preparedStmt.setBoolean(11, service.getIsActivated());
			preparedStmt.execute();
			System.out.println("Record is inserted in the table successfully");
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

}
