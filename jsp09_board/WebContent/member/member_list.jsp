<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">   
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
      crossorigin="anonymous">   
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-sm-5" align="center">
	
		<div class="jumbotron">
			<h3>회원목록보기</h3>
			<c:if test="${ memberList.isEmpty() }">
				<h4><p class="bg-danger text-white">등록된 회원이 존재하지 않습니다</p></h4>
			</c:if>
		</div>

		<form action="" class="form-line">
			<div class="input-group">
				<select name="f" id="" class="form-control col-sm-2 mr-sm-2">
					<option value="name">이름</option>
					<option value="email">이메일</option>
				</select>
				<input type="text" name="q" class="form-control col-sm-8 mr-sm-2" placeholder="검색어를 입력하세요."/>
				<button tyep="submit" class="btn btn-primary col-sm-1 mr-sm-2">검색</button>
				<a href="memberInsertForm.bo" class="btn btn-success col-sm-1">회원등록</a>
			</div>
		</form>
		<br class="mt-sm-5" />	
		
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr align="center">
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>이메일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${ memberList }">
					<tr>
						<td>${ member.getId() }</td>
						<td>${ member.getPw() }</td>
						<td><a href="memberDetail.co?id=${ member.getId() }">${ member.getName() }</a></td>
						<td>${ member.getAge() }</td>
						<td>${ member.getGender() }</td>
						<td>${ member.getEmail() }</td>
						<td align="center">
							<a href="memberDeleteForm.co?id=${ member.getId() }">
								<i class="fas fa-trash-alt"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	
	<div class="container" align="center">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a href="#" class="page-link"><i class="fas fa-fast-backward"></i></a></li>		
			<li class="page-item"><a href="#" class="page-link"><i class="fas fa-backward"></i></a></li>
					
			<c:forEach var="page_num" begin="1" end="10">
				<li class="page-item"><a href="#" class="page-link">${ page_num }</a></li>
			</c:forEach>
					
			<li class="page-item"><a href="#" class="page-link"><i class="fas fa-forward"></i></a></li>
			<li class="page-item"><a href="#" class="page-link"><i class="fas fa-fast-forward"></i></a></li>		
		</ul>
	</div>
	
</body>
</html>
