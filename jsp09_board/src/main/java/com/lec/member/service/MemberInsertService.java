package com.lec.member.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.Member;

public class MemberInsertService {

	public boolean registerMember(Member member) {
		
		boolean isInsertSuccess = false;
		
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		int insertCount = memberDAO.insertMember(member);
		
		if(insertCount > 0) {
			JDBCUtility.commit(conn);
			JDBCUtility.close(conn, null, null);
			isInsertSuccess = true;
		} else {
			JDBCUtility.rollback(conn);
		}
		return isInsertSuccess;
	}
}
