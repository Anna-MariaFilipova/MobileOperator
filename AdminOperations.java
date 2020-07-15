package mobileOperator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AdminOperations {

	public void searchServiceByEmail(String searchedEmail) {

		String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate,services.endService FROM services JOIN users\r\n"
				+ "ON users.id=services.user_id\r\n";

		Statement st = null;
		try {
			st = ConnectionWithDatabase.connectWithDatabase().createStatement();
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database");
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("The query cannot be fulfilled");
		}
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String serviceType = rs.getString("typeService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				Date lastPaymentDate = rs.getDate("lastPaymentDate");
				Date endOfService = rs.getDate("endService");
				if (email.equals(searchedEmail)) {
					System.out.println("---------");
					System.out.format("%s, %s, %s\n", name, email, serviceType);
					System.out.println("Minutes:");
					System.out.println(minutesCount);
					System.out.println("SMS:");
					System.out.println(smsCount);
					System.out.println("Megabytes:");
					System.out.println(megabytesCount);
					System.out.println("Last payment date:");
					System.out.println(lastPaymentDate);
					System.out.println("End of service:");
					System.out.println(endOfService);
					System.out.println("---------");

				} else
					System.out.println("Not found user");

			}
		} catch (SQLException e) {
			System.out.println("Cannot get the data from the  database1");
		}

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Cannot stop the connection");
		}
	}

	public void searchUserByServiceName(String searchedTypeService) {

		String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate FROM services JOIN users\r\n"
				+ "ON users.id=services.user_id\r\n";

		Statement st = null;
		try {
			st = ConnectionWithDatabase.connectWithDatabase().createStatement();
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database");
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("The query cannot be fulfilled");
		}
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String typeService = rs.getString("typeService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				if (typeService.equals(searchedTypeService)) {
					System.out.format("%s, %s, %s\n", name, email, typeService);
					System.out.println("---------");
					System.out.println("Minutes:");
					System.out.println(minutesCount);
					System.out.println("SMS:");
					System.out.println(smsCount);
					System.out.println("megabytes:");
					System.out.println(megabytesCount);
					System.out.println("---------");
				} else
					System.out.println("Not found service");

			}
		} catch (SQLException e) {
			System.out.println("Cannot get the data from the  database2");
		}

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Cannot stop the connection");
		}

	}

	public void showUnpaidServices() {

		String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate FROM services JOIN users\r\n"
				+ "ON users.id=services.user_id\r\n" + "WHERE services.lastPaymentDate<now();";
		Statement st = null;
		try {
			st = ConnectionWithDatabase.connectWithDatabase().createStatement();
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database3");
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("The query cannot be fulfilled");
		}
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String typeService = rs.getString("typeService");
				int smsCount = rs.getInt("countSMS");
				int minutesCount = rs.getInt("countMinutes");
				int megabytesCount = rs.getInt("countMegabytes");
				System.out.println("---------");
				System.out.format("%s, %s, %s\n", name, email, typeService);
				System.out.println("Minutes:");
				System.out.println(minutesCount);
				System.out.println("SMS:");
				System.out.println(smsCount);
				System.out.println("megabytes:");
				System.out.println(megabytesCount);
				System.out.println("---------");
			}
		} catch (SQLException e) {
			System.out.println("Cannot get the data from the  database4");
		}
		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Cannot stop the connection");
		}

	}

	public void isActive() {
		Calendar calendar = Calendar.getInstance();
		java.sql.Date datenow = new java.sql.Date(calendar.getTime().getTime());

		String query = "SELECT users.name,users.email,services.countSMS,services.countMinutes,services.countMegabytes,services.typeService,services.lastPaymentDate,services.isActivated,services.endService FROM services JOIN users\r\n"
				+ "ON users.id=services.user_id\r\n";

		Statement st = null;
		try {
			st = ConnectionWithDatabase.connectWithDatabase().createStatement();
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database");
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("The query cannot be fulfilled");
		}

		String queryUpdate = " insert into services isActivated" + " value ?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(queryUpdate);
		} catch (SQLException e1) {
			System.out.println("Cannot connect to the database");
		}
		try {
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
					preparedStmt.setBoolean(1, service.getIsActivated());
					preparedStmt.execute();
				}
				if (smsCount == 0 && minutesCount == 0 && megabytesCount == 0) {
					service.setIsActivated(false);
					preparedStmt.setBoolean(1, service.getIsActivated());
					preparedStmt.execute();
				}

			}
		} catch (SQLException e) {
			// System.out.println("Cannot get the data from the database");
		}
		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Cannot stop the connection");
		}
	}

}
