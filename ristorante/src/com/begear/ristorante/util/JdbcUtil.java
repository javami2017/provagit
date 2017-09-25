package com.begear.ristorante.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("couldn't load jdbc driver");
			System.exit(69);
		}
	}
	private static Connection conn = null;

	private static final String $TAG = new String("JDBC_UTIL: ");

	private JdbcUtil() {}

	public static Connection getConnection(String url, String user, String password) {

		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
				System.out.println($TAG + "connected @ " + url);
			} catch (SQLException e) {
				System.out.println($TAG + "couldn't connect to database " + url);
			}
		}
		return conn;
	}

	public static void disconnect() {

		if (conn != null) try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			System.out.println($TAG + "couldn't close database connection");
		}
	}
}
