package mobileOperator;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Register {

	public void setUserInDatabase(String name, String email, String password) throws PasswordException, EmailException {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (email.matches(regex) == false) {
			throw new EmailException();
		}
		if (password.length() < 8)
			throw new PasswordException();
		User user = new User(name, email, password);
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		String query = " insert into users (name,email,date_created,password)" + " values (?, ?, ?,?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
			preparedStmt.setString(1, user.getName());
			preparedStmt.setString(2, user.getEmail());
			preparedStmt.setDate(3, startDate);
			preparedStmt.setString(4, user.getPassword());
			preparedStmt.execute();
			System.out.println("Record is inserted in the table successfully");
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database");
		} catch (Exception e) {
			System.err.println("Got an exception in adding user in database!");
		}
	}

	public void setAdminInDatabase(String name, String email, String password)
			throws PasswordException, EmailException {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (email.matches(regex) == false) {
			throw new EmailException();
		}
		if (password.length() < 8)
			throw new PasswordException();
		Admin admin = new Admin(name, email, password);
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		String query = " insert into admins (name,email,password,datecreated)" + " values (?, ?, ?,?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = ConnectionWithDatabase.connectWithDatabase().prepareStatement(query);
			preparedStmt.setString(1, admin.getName());
			preparedStmt.setString(2, admin.getEmail());
			preparedStmt.setString(3, admin.getPassword());
			preparedStmt.setDate(4, startDate);
			preparedStmt.execute();
			System.out.println("Record is inserted in the table successfully");
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database");
		} catch (Exception e) {
			System.err.println("Got an exception in adding admin in database!");

		}
	}

}
