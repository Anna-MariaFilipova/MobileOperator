package mobileOperator;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Checks {

	public static void checkForAdmin(String searchedEmail, String searchedPassword) {

		try {

			String query = "SELECT * FROM admins";
			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			boolean isFound = false;

			while (rs.next()) {

				String email = rs.getString("email");
				String password = rs.getString("password");
				if (email.equals(searchedEmail) && password.equals(searchedPassword)) {
					isFound = true;
				}

			}
			if (isFound == true) {
				Menu.menuForAdmin();
			} else
				System.out.println("Not found an admin!");
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	public static String checkForUser(String searchedEmail, String searchedPassword) {

		try {

			String query = "SELECT * FROM users";
			Statement st = ConnectionWithDatabase.connectWithDatabase().createStatement();
			ResultSet rs = st.executeQuery(query);
			boolean isFound = false;

			while (rs.next()) {

				String email = rs.getString("email");
				String password = rs.getString("password");
				if (email.equals(searchedEmail) && password.equals(searchedPassword)) {
					isFound = true;
				}

			}
			if (isFound == true) {
				try {
					String queryForService = "SELECT * FROM users JOIN services ON users.id=services.user_id";
					Statement st1 = ConnectionWithDatabase.connectWithDatabase().createStatement();
					ResultSet rs1 = st1.executeQuery(queryForService);
					while (rs1.next()) {
						String typeService = rs1.getString("typeService");
						Date end = rs1.getDate("end");
						String email = rs1.getString("email");
						if (email.equals(searchedEmail)) {
							System.out.println("Service:");
							System.out.println(typeService);
							System.out.println("You can pay for the services at the latest by:");
							System.out.println(end);
						} else
							System.out.println("No service");
					}
				} catch (Exception e) {
					System.err.println("Got an exception! ");
					System.err.println(e.getMessage());
				}
			} else
				System.out.println("Not found!");
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		return searchedEmail;
	}
}
