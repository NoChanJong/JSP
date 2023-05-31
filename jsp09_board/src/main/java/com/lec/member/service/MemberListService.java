package com.lec.member.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.lec.db.JDBCUtility;
import com.lec.member.dao.MemberDAO;
import com.lec.member.vo.Member;

public class MemberListService {

	public int getListCount() {
		
		int listCount = 0;
		
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		listCount = memberDAO.selectListCount();
		
		return listCount;
	}
	
	public List<Member> getMemberList() {
		
		List<Member> memberList = new ArrayList<>();
		Connection conn = JDBCUtility.getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		memberList = memberDAO.selectMemberList();
		return memberList;
		
	}
	
	
}
