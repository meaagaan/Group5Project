package mochi.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private Connection database;

	public DBConnection() {
		try {
			this.database = DriverManager.getConnection("jdbc:mysql://34.73.12.61:3306/mochi-desktop", "root", "NvaleHh1ovGKq1p1");
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public Connection getDatabase() {
		return this.database;
	}
}
