package mobileOperator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Checks {
	public void checkForAdmin(String searchedEmail, String searchedPassword) throws PasswordException, EmailException {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (searchedEmail.matches(regex) == false) {
			throw new EmailException();
		}
		if (searchedPassword.length() < 8) {
			throw new PasswordException();
		}

		String query = "SELECT * FROM admins";
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
		boolean isFound = false;
		try {
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				if (email.equals(searchedEmail) && password.equals(searchedPassword)) {
					isFound = true;
				}

			}
		} catch (SQLException e) {
			System.out.println("Cannot get the data from database");
		}
		if (isFound == true) {
			Menu.menuForAdmin();
		} else
			System.out.println("Not found an admin!");
		Menu.mainMenu();
		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Cannot stop the connection");
		}
	}

	public String checkForUser(String searchedEmail, String searchedPassword) throws PasswordException, EmailException {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (searchedEmail.matches(regex) == false) {
			throw new EmailException();
		}
		if (searchedPassword.length() < 8)
			throw new PasswordException();

		String query = "SELECT * FROM users";
		Statement st = null;
		try {
			st = ConnectionWithDatabase.connectWithDatabase().createStatement();
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database");
		}

		boolean isFound = false;
		try {
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				if (email.equals(searchedEmail) && password.equals(searchedPassword)) {
					isFound = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("The query cannot be fulfilled");
		}

		if (isFound == true) {
			AdminOperations operation = new AdminOperations();
			operation.searchServiceByEmail(searchedEmail);

		} else {
			System.out.println("Not found a user");
			Menu.mainMenu();
		}

		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Cannot stop the connection");
		}

		return searchedEmail;
	}
}
