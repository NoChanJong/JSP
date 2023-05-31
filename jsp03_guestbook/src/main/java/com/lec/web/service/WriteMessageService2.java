package com.lec.web.service;

import java.sql.Connection;

import com.lec.web.dao.MessageDAO2;
import com.lec.web.exception.ServiceException2;
import com.lec.web.jdbc.ConnectionProvider2;
import com.lec.web.jdbc.JDBCUtil;
import com.lec.web.model.Message2;

public class WriteMessageService2 {
	
	// singleton
	private WriteMessageService2() {}
	private static WriteMessageService2 instance = new WriteMessageService2();
	public static WriteMessageService2 getInstance() { return instance; }
	
	public void write(Message2 message2) {
		Connection conn = null;
		try {
			conn = ConnectionProvider2.getConnection();
			MessageDAO2 messageDAO2 = MessageDAO2.getInstance();
			messageDAO2.insert(conn, message2);
		} catch (Exception e) {
			throw new ServiceException2("메시지등록실패 " + e.getMessage(), null);
		} finally {
			JDBCUtil.close(conn, null, null);
		}
	}
	
}
