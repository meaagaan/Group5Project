package mochi.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection database;

	public DBConnection() {
		try {
			this.database = DriverManager.getConnection("jdbc:mysql://34.73.12.61/mochi-desktop", "root", "NvaleHh1ovGKq1p1");
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static Connection getDatabase() {
		return database;
	}
}
