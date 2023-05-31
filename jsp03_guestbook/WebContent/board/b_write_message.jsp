<%@page import="com.lec.web.service.WriteMessageService2"%>
<%@page import="com.lec.web.model.Message2"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Message2 message2 = new Message2();
	message2.setGuestName(request.getParameter("guestName"));
	message2.setPassword(request.getParameter("password"));
	message2.setMessage(request.getParameter("message"));
%>
	
<%
	WriteMessageService2 writeService2 = WriteMessageService2.getInstance();
	writeService2.write(message2);
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
		<h3>방명록등록하기</h3>
		<p class="bg-success text-white">방명록에 메시지가 성공적으로 등록이 되었습니다.</p>
		<a href="list_board.jsp" class="btn btn-primary">방명록목록보기</a>
	</div>
</body>
</html>