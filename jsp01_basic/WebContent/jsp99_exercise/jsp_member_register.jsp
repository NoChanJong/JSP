<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="jsp_member_process.jsp" method="post">
		아 이 디 : <input type="text" name="id" /><br />
		비밀번호 : <input type="text" name="pw" /><br />
		연 락 처 : <input type="text" name="pn" value="010-"/><br />
		성    별 : <input type="radio" name="gender" value="남자"/>남자
			       <input type="radio" name="gender" value="여자"/>여자<br />
		취    미 : <input type="checkbox" name="hobby" value="독서" />독서
				   <input type="checkbox" name="hobby" value="축구" />축구
				   <input type="checkbox" name="hobby" value="수영" />수영<br />
		가입인사 : <textarea rows="" cols="" name="intro"></textarea><br />
		가입하기 : <input type="submit" name="sb" value="가입하기"/>
		새로고침 : <button type="reset">새로고침</button>
	</form>
</body>
</html>