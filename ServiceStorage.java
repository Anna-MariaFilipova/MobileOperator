package mobileOperator;

import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServiceStorage {

	public static Service createService(String typeService, String endServiceStr, String lastPaymentDateStr,
			int countMinutes, int countSMS, int countMegabytes, double price, int userId, boolean isActivated) {

		java.util.Date lastPaymentDateUtil = null;
		java.util.Date endServiceUtil = null;
		java.sql.Date endService = null;
		java.sql.Date lastPaymentDate = null;
		try {
			lastPaymentDateUtil = new SimpleDateFormat("yyyy-MM-dd").parse(lastPaymentDateStr);
			endServiceUtil = new SimpleDateFormat("yyyy-MM-dd").parse(endServiceStr);
			lastPaymentDate = new java.sql.Date(lastPaymentDateUtil.getTime());
			endService = new java.sql.Date(endServiceUtil.getTime());
			;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		Service service = new Service(typeService, endService, lastPaymentDate, countMinutes, countSMS, countMegabytes,
				price, userId, isActivated);

		return service;
	}

	public static void setServiceInDatabase(Service service) {
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		String query = " insert into services (typeService,price,startService,endService,lastPaymentDate,countMinutes,countSMS,countMegabytes,user_id,isActivated)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
			preparedStmt.setString(1, service.getTypeService());
			preparedStmt.setDouble(2, service.getPrice());
			preparedStmt.setDate(3, startDate);
			preparedStmt.setDate(4, service.getEndService());
			preparedStmt.setDate(5, service.getLastPaymentDate());
			preparedStmt.setInt(6, service.getCountMinutes());
			preparedStmt.setInt(7, service.getCountSMS());
			preparedStmt.setInt(8, service.getCountMegabytes());
			preparedStmt.setInt(9, service.getUserId());
			preparedStmt.setBoolean(10, service.getIsActivated());
			preparedStmt.execute();
			System.out.println("Record is inserted in the table successfully");
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
}
