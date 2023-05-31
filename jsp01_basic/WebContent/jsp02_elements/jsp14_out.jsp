<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// System.out와 동일 기능을 하는 객체
		out.println("오늘의 날짜 및 시간" + "<br>");
		out.println(java.util.Calendar.getInstance().getTime());
	%>
	<form action="jsp14_out_result.jsp" method="post">
		아 이 디 : <input type="text" name="userid" /><br />
		비밀번호 : <input type="text" name="userpw" /><br />
		<input type="submit" value="전송" />
	</form>

</body>
</html>