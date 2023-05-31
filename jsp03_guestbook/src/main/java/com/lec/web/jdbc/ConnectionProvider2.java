package com.lec.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider2 {

	// getConnection 메서드 생성 
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:board");
	}
}
