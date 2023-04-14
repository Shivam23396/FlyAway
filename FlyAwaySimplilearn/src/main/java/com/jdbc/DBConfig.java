package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	public static Connection getConnection() {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/simplilearn";
		String username = "root";
		String password = "root";
		Connection conn = null;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);

			if (conn != null) {
				System.out.println("connection established successfully");
			} else {
				System.out.println(" error!! connection does not establised");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return conn;

	}

}
