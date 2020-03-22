package mochi;

import mochi.db.DBConnection;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class LibraryDatabaseTest {
	User user = new User();
	DBConnection connection = new DBConnection();
	LibraryDatabase wishlistDatabase = new LibraryDatabase(DBConnection.getDatabase());;

	@Test
	// Test if the text file is read from the database.
	public void checkReadFile() throws IOException, SQLException {
		assertEquals(true, wishlistDatabase.readFile("Phongphattharasiri"));
	}

	@Test
	// Test if the text file is fail to read from the database.
	public void checkReadFileFail() throws IOException, SQLException {
		assertEquals(false, wishlistDatabase.readFile("Admin"));
	}

	@Test
	// Test if the text file is write to the database.
	public void checkWriteFile() throws IOException, SQLException {
		assertEquals(true, wishlistDatabase.writeFile("Phongphattharasiri"));
	}
}