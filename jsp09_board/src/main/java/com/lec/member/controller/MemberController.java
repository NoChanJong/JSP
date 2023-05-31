package com.lec.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.member.action.Action;
import com.lec.member.action.MemberDetailAction;
import com.lec.member.action.MemberInsertAction;
import com.lec.member.action.MemberListAction;
import com.lec.member.vo.ActionForward;

@WebServlet("*.co")
public class MemberController extends HttpServlet{
	
	Action action = null;
	ActionForward forward = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		process(req, res);
	}

	private void process(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equalsIgnoreCase("/memberInsertForm.co")) {
			forward = new ActionForward();
			forward.setPath("/member/member_insert.jsp");
		} else if(command.equalsIgnoreCase("/memberInsert.co")) {
			action = new MemberInsertAction();
			forward = action.excute(req, res);
		} else if(command.equalsIgnoreCase("/memberList.co")) {
			action = new MemberListAction();
			forward = action.excute(req, res);
		} else if(command.equalsIgnoreCase("/memberDetail.co")) {
			action = new MemberDetailAction();
			forward = action.excute(req, res);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
			}
		}
	}
}
