package com.lec.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.lec.db.JDBCUtility;
import com.lec.member.vo.Member;

public class MemberDAO {

	private MemberDAO() {}
	private static MemberDAO memberDAO;
	public static MemberDAO getInstance() {
		if(memberDAO == null) memberDAO = new MemberDAO();
		return memberDAO;
	}
	
	Connection conn = null;
	DataSource ds = null;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int insertMember(Member member) {
		
		PreparedStatement pstmt = null;
		String sql = "insert into member(id, pw, name, age, gender, email) "
					+ " values(?, ?, ?, ?, ?, ?)";
		
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원 등록 실패" + e.getMessage());
		} finally {
			JDBCUtility.close(null, pstmt, null);
		}
		
		return insertCount;
	}

	public int selectListCount() {
		int listCount = 0;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return listCount;
	}

	public List<Member> selectMemberList() {
		
		Member member = null;
		List<Member> memberList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member order by id desc limit 0, 10";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtility.close(conn, pstmt, rs);
		}
		return memberList;
	}

	public int updateReadCount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Member selectMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}































