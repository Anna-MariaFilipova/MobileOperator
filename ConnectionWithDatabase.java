package mobileOperator;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionWithDatabase {
	public static Connection connectWithDatabase() {

		String myDriver = null;
		Connection conn = null;
		String myUrl = null;

		try {
			myDriver = "com.mysql.cj.jdbc.Driver";
			myUrl = "jdbc:mysql://localhost:3307/mobileOperator?serverTimezone=UTC";
			try {
				Class.forName(myDriver);
			} catch (Exception e) {
				System.out.println(e);
			}
			conn = (Connection) DriverManager.getConnection(myUrl, "root", "ankabace123");
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return conn;
	}
}
