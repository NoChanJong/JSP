package com.lec.member.service;

import java.sql.Connection;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.Member;

public class MemberDetailService {

	public Member getMember(String id) {
		
		Member member = null;
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		int updateCount = memberDAO.updateReadCount(id);
		if(updateCount > 0) JDBCUtility.commit(conn);
		else JDBCUtility.rollback(conn);
		member = memberDAO.selectMember(id);
		return member;
	}
}
