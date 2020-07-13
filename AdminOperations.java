package mobileOperator;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class AdminOperations {

	public static void showServiceByUserName(String searchedname) {

		try {
			String query = "SELECT users.name,users.email,services.typeService,services.end FROM users JOIN services ON users.id=services.user_id";
			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String typeService = rs.getString("typeService");
				Date end = rs.getDate("end");
				if (name.equals(searchedname)) {
					System.out.format("%s, %s, %s\n", name, typeService, end);
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	public static void showUserNameByTypeOfService(String searchedTypeService) {

		try {

			String query = "SELECT users.name,users.email,services.typeService,services.end FROM users JOIN services ON users.id=services.user_id";
			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String typeService = rs.getString("typeService");
				Date end = rs.getDate("end");
				if (typeService.equals(searchedTypeService)) {

					System.out.format("%s, %s, %s\n", name, typeService, end);
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	public static void unpaidServices() {
		try {
			String query = "SELECT users.name,services.typeService,services.lastPaymentDate FROM services JOIN users\r\n"
					+ "ON users.id=services.user_id\r\n" + "WHERE services.lastPaymentDate<now();";
			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				String typeService = rs.getString("typeService");
				Date end = rs.getDate("end");
				System.out.format("%s, %s, %s\n", name, typeService, end);
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
