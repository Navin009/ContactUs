package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/root";
	private static final String USER = "root";
	private static final String PASS = "password";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
