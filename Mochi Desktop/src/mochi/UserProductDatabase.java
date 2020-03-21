package mochi;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProductDatabase {
	Connection connection;

	public UserProductDatabase(Connection connection) {
		this.connection = connection;
	}

	public boolean readFile(String username) throws SQLException, IOException {
		PreparedStatement statement;
		ResultSet resultSet;

		statement = connection.prepareStatement("SELECT product FROM User WHERE username = ?");
		statement.setString(1, username);
		resultSet = statement.executeQuery();

		ArrayList<String> product = new ArrayList<String>();

		System.out.println(resultSet);

		if (resultSet.next() && (resultSet.getObject(1) != null)) {
			File file = new File("db_product.txt");
			FileOutputStream output = new FileOutputStream(file);

			Reader input = resultSet.getCharacterStream("product");

			int character;
			boolean firstLine = true;
			StringBuilder stringBuilder = new StringBuilder();
			while ((character = input.read()) > 0) {
				output.write(character);

				if (firstLine) {
					firstLine = false;
					continue;
				}

				if (!(character == 42 || character == 10)) {
					stringBuilder.append((char)character);
				}
				else {
					product.add(stringBuilder.toString());
					stringBuilder = new StringBuilder();
				}
			}
			return (true && User.setWishlist(product));
		}
		return false;
	}

	public boolean writeFile(String username) throws SQLException, FileNotFoundException {
		PreparedStatement statement;

		statement = connection.prepareStatement("UPDATE User SET product = ? WHERE username = ?");
		statement.setString(2, username);

		File file = new File("product.txt");
		FileReader input = new FileReader(file);

		if (input != null) {
			statement.setCharacterStream(1, input);
			statement.executeUpdate();
			return true;
		}
		return false;
	}
}
