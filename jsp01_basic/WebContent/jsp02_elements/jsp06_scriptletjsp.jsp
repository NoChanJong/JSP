<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int sum = 0;

	for(int i=0; i<=10; i++) {
		sum += i;
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 실습. 1~10까지의 합을 구하기 -->
	1~10까지의 합은 <%=sum %> 입니다.
</body>
</html>