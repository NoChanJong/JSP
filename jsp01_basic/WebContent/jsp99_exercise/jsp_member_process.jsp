<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pn = request.getParameter("pn");
	String gender = request.getParameter("gender");
	String intro = request.getParameter("intro");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>가입양식</th>
			<th>입력값</th>
		</tr>
		<tr>
			<td>
				아이디
			</td>
			<td>
				<%out.println(id); %>
			</td>	
		</tr>
		<tr>
			<td>
				비밀번호
			</td>
			<td>
				<%out.println(pw); %>
			</td>	
		</tr>
		<tr>
			<td>
				연락처
			</td>
			<td>
				<%out.println(pn); %>
			</td>	
		</tr>
		<tr>
			<td>
				성별
			</td>
			<td>
				<%out.println(gender); %>
			</td>	
		</tr>
		<tr>
			<td>
				취미
			</td>
			<td>
				<%
					String[] hobbies = request.getParameterValues("hobby");
					if(hobbies != null) {
						for(String hobby:hobbies) {
				%>
							<%= hobby %><br />
				<%
						}
					}
				%>
			</td>	
		</tr>
		<tr>
			<td>
				가입인사
			</td>
			<td>
				<%out.println(intro); %>
			</td>	
		</tr>
	</table>
</body>
</html>