package com.revature.Connection.Bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyBankConnection {
	public static Connection getConnection() throws SQLException, IOException {
		String url = "jdbc:oracle:thin:@192.168.56.105:1521:xe";
		String username = "Bank";
		String password = "revature";
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		return DriverManager.getConnection(url, username, password);
	}
} 

