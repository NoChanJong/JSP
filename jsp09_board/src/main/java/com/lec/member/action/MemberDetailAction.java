package com.lec.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.service.MemberDetailService;
import com.lec.member.vo.ActionForward;
import com.lec.member.vo.Member;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		
		String id = req.getParameter("id");
		
		MemberDetailService memberDetailService = new MemberDetailService();
		Member member = memberDetailService.getMember(id);
		
		ActionForward forward = new ActionForward();
		req.setAttribute("member", member);
		forward.setPath("/member/member_detail.jsp");
		
		return forward;
	}

}
