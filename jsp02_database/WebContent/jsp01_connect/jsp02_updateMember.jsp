<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	// update 로직
	// update member set password= ?, name= ?, email= ? where id= ?;
	// 실습. 업데이트로직 완성하기
	
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:mariadb://localhost:3306/jspstudy";
	String usr = "root";
	String pwd = "12345";
	String sql = "update member set password= ?, name= ?, email= ? where id= ?";
	
	int updateCount = 0;
	boolean isConn = true;
	
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, pw);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.setString(4, id);
		
		updateCount = pstmt.executeUpdate();
		out.println("<h3 class='bg-danger text-white'>회원정보가 수정 완료되었습니다.</h3><br>");
		
	}catch(Exception e) {
			isConn = false;
			out.println("<h3 class='bg-danger text-white'>수정실패.</h3><br>"
					+ e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception e) {
				// dummy
			}
		}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">	
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h1>회원정보수정</h1>
		
		<%= id %><br>
		<%= pw %><br>
		<%= name %><br>
		<%= email %><br>
		<hr />
		
		<%
			if(updateCount > 0) {
		%>
				<h3 class="bg-info text-white"><%= id %>회원의 정보가 수정되었습니다.</h3>
		<%
			} else {
		%>
				<h3 class="bg-danger text-white">회원의 정보 수정실패. <%= id %>를 찾지 못했습니다.</h3>
		<%
			}
		%>
	</div>
</body>
</html>

