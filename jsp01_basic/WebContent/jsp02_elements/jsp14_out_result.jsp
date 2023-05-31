<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 실습. out객체를 사용해서 아래와 같이 출력하기 -->
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
	%>
	
	아 이 디 : <% out.println(id); %><br />
	비밀번호 : <% out.println(pw); %>
	
</body>
</html>