package mobileOperator;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.Date;

public class AdminOperations {

	public static void searchServiceByEmail(String searchedEmail) {
		try {
			String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate,services.endService FROM services JOIN users\r\n"
					+ "ON users.id=services.user_id\r\n";

			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String typeService = rs.getString("typeService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				Date lastPaymentDate = rs.getDate("lastPaymentDate");
				Date endOfService = rs.getDate("endService");
				if (email.equals(searchedEmail)) {
					System.out.format("%s, %s, %s\n", name, email, typeService);
					System.out.println("Minutes:");
					System.out.println(minutesCount);
					System.out.println("SMS:");
					System.out.println(smsCount);
					System.out.println("megabytes:");
					System.out.println(megabytesCount);
					System.out.println("last payment date:");
					System.out.println(lastPaymentDate);
					System.out.println("end of service:");
					System.out.println(endOfService);

				} else
					System.out.println("Not found user");

			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public static void searchUserByService(String searchedTypeService) {

		try {
			String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate FROM services JOIN users\r\n"
					+ "ON users.id=services.user_id\r\n";

			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String typeService = rs.getString("typeService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				if (typeService.equals(searchedTypeService)) {
					System.out.format("%s, %s, %s\n", name, email, typeService);
					System.out.println("Minutes:");
					System.out.println(minutesCount);
					System.out.println("SMS:");
					System.out.println(smsCount);
					System.out.println("megabytes:");
					System.out.println(megabytesCount);
				} else
					System.out.println("Not found service");

			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	public static void showUnpaidServices() {
		try {
			String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate FROM services JOIN users\r\n"
					+ "ON users.id=services.user_id\r\n" + "WHERE services.lastPaymentDate<now();";
			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String typeService = rs.getString("typeService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				System.out.format("%s, %s, %s\n", name, email, typeService);
				System.out.println("Minutes:");
				System.out.println(minutesCount);
				System.out.println("SMS:");
				System.out.println(smsCount);
				System.out.println("megabytes:");
				System.out.println(megabytesCount);

			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public static void isActive() {
		Calendar calendar = Calendar.getInstance();
		java.sql.Date datenow = new java.sql.Date(calendar.getTime().getTime());
		try {
			String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate,services.isActivated,services.endService FROM services JOIN users\r\n"
					+ "ON users.id=services.user_id\r\n";

			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				String typeService = rs.getString("typeService");
				Date lastPaymentDate = rs.getDate("lastPaymentDate");
				Date endService = rs.getDate("endService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				boolean isActive = rs.getBoolean("isActivated");
				Service service = new Service(typeService, lastPaymentDate, endService, smsCount, minutesCount,
						megabytesCount, isActive);
				if (datenow.compareTo(lastPaymentDate) > 0 || datenow.compareTo(endService) > 0) {
					service.setIsActivated(false);
				}
				if (smsCount == 0 && minutesCount == 0 && megabytesCount == 0) {
					service.setIsActivated(false);
				}

			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
