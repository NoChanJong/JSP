package com.lec.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.service.MemberListService;
import com.lec.member.vo.ActionForward;
import com.lec.member.vo.Member;

public class MemberListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		
		List<Member> memberList = new ArrayList<>();
		
		MemberListService memberListService = new MemberListService();
		int listCount = memberListService.getListCount();
		memberList = memberListService.getMemberList();
		
		req.setAttribute("memberList", memberList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/member/member_list.jsp");
		
		return forward;
	}

}
