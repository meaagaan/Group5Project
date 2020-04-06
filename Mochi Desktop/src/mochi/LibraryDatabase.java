package mochi;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryDatabase {
	Connection connection;

	public LibraryDatabase(Connection connection) {
		this.connection = connection;
	}

	public boolean readFile(String username) throws SQLException, IOException {
		PreparedStatement statement;
		ResultSet resultSet;

		statement = connection.prepareStatement("SELECT product FROM User WHERE username = ?");
		statement.setString(1, username);
		resultSet = statement.executeQuery();

		ArrayList<Product> productList = new ArrayList<Product>();

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

				if (!(character == 42 || character == 10 || character == 11 || character == 12 || character == 13)) {
					stringBuilder.append((char)character);
				}
				else {
					findProduct(stringBuilder.toString(), productList);
					stringBuilder = new StringBuilder();
				}
			}
			return (true && User.setLibraryList(productList));
		}
		return false;
	}

	private boolean findProduct(String productNumber, ArrayList<Product> productList) {
		PreparedStatement statement;
		ResultSet resultSet;
		Product product;

		try {
			statement = connection.prepareStatement("SELECT productN, genreName, descriptionOfProduct, priceOfProduct, userName FROM Product WHERE productID = ?");
			statement.setString(1, productNumber);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				product = new Product();

				product.setPid(productNumber);
				product.setPname(resultSet.getString("productN"));
				product.setPgenre(resultSet.getString("genreName"));
				product.setPdescription(resultSet.getString("descriptionOfProduct"));
				product.setPprice(resultSet.getString("priceOfProduct"));
				product.setPusername(resultSet.getString("userName"));

				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
