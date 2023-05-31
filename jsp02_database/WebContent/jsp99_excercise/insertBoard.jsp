<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String subject = request.getParameter("subject");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;	
	
	String url = "jdbc:mariadb://localhost:3306/jspstudy";
	String usr = "root";
	String pwd = "12345";
	String sql = "insert into board (subject, writer, content) values(?, ?, ?)";
	
	int insertCount = 0;
	boolean isInsert = true;	
	
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, subject);	
		pstmt.setString(2, writer);	
		pstmt.setString(3, content);	
		insertCount = pstmt.executeUpdate();	
	} catch(Exception e) {	
		isInsert = false;
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
	<div class="container" align="center">
		<h1>게시글 쓰기</h1>
		<form action="insertBoard.jsp" method="post">
			<table class="table table-bordered table-white table-hover">
				<tr>
					<td width="20%">제목</td>
					<td><input type="text" name="subject" class="form-control" size="30" value="" /></td>
				</tr>
				<tr>
					<td width="20%">작성자</td>
					<td><input type="text" name="writer" class="form-control" size="30" value="" /></td>
				</tr>
				<tr>
					<td width="20%">내용</td>
					<td>
						<input type="text" name="content" class="form-control" size="30" value="" >
					</td>
				</tr>
			</table>
			<input type="submit" class="btn btn-primary mt-sm-2" value="업로드하기" />
			<a href="listBoard.jsp" class="btn btn-info mt-sm-2">게시글 목록</a>
		</form>	
	</div>
</body>
</html>