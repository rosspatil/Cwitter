package com.rosspatil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	static Connection con=null;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	public static Connection getConnection() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cwitter","roshan","hibuddy");
		return con;
	}
}
