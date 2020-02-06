package mochi.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private Connection database;

	public DBConnection() {
		try {
			this.database = DriverManager.getConnection("jdbc:mysql://[IP]/mochi-desktop", "[USER]", "[PASSWORD]");
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Connection getDatabase() {
		return this.database;
	}
}
