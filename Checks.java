package mobileOperator;

import java.sql.ResultSet;
import java.sql.Statement;

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
			Menu.mainMenu();
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
				System.out.println("Found");
				AdminOperations.searchServiceByEmail(searchedEmail);

			} else {
				System.out.println("Not found a user");
				Menu.mainMenu();
			}

			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		return searchedEmail;
	}
}
