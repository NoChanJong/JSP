<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); 
	String s_bno = request.getParameter("bno");
	int bno = 0;
	if(s_bno != null && !s_bno.isEmpty()) {
		bno = Integer.parseInt(s_bno);
	}
	String subject = "";
	String writer = "";
	String content = "";
	
%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">   
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 삭제</h1>
		<%
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;	
			
			String url = "jdbc:mariadb://localhost:3306/jspstudy";
			String usr = "root";
			String pwd = "12345";
			String sql = "delete from board where bno = ?";
			
			int deleteCount = 0;
			boolean isDelete = true;	
			
			try {
				conn = DriverManager.getConnection(url, usr, pwd);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);	
				deleteCount = pstmt.executeUpdate();	
			} catch(Exception e) {	
				isDelete = false;
				out.println("<h3 class='bg-danger text-white'>DB접속실패!!</h3><br>" 
						+ e.getMessage());		
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch(Exception e) {
					// dummy
				}
			}
		%>
	
		<%
			if(deleteCount > 0) {
		%>
				<h3 class="bg-info text-white"><%= bno %>번 게시글이 성공적으로 삭제되었습니다!!</h3>
		<%
			} else {
		%>
				<h3 class="bg-danger text-white">게시글삭제실패!! <%= bno %>를 찾지 못했습니다!</h3>
		<%
			}			
		%>
		<a href="listBoard.jsp" class="btn btn-primary">게시글목록</a>
</body>
</html>