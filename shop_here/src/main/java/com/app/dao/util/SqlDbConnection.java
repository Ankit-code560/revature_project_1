package com.app.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDbConnection {

	private static Connection connection;

	private SqlDbConnection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shop_here";
		String username = "root";
		String password = "Dmietr@123";
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}
}

