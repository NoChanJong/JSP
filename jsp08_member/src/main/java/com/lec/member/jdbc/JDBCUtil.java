package com.lec.member.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	
	// close 메서드 생성
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
		} catch (Exception e) {
			// dummy
		}
	}
	
	public static void rollback(Connection conn) {
		try { if(conn != null) conn.rollback();	} catch (Exception e) {}	
	}
	
}