<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">	
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous">  
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
	<title>회원등록</title>
  	<style>
  		.login-btn {
  			clear: black;
  			background-color: #FFC312; 
  			width: 100px;
  		}
  		.login-btn:hover {
  			clear: white;
  			background-color: black;  		
  		}
  		.input-group-prepend span {
  			color: black;
  			border-left-color: #FFC312;
  			width: 40px;
  			border: 0 !important;
  		}
  	</style>	
</head>
<body>
	<div class="container" align="center">
		<div class="jumbotron">
			<h3>회원등록하기</h3>
			<p>회원등록 페이지 입니다. 회원정보를 작성해 주세요</p>
		</div>
		
		<form action="memberInsert.co" method="post" class="form-group" name="memberform" 
				enctype="multipart/form-data">
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
				<input type="text" class="form-control" name="id" id="id" value="" required placeholder="member ...">
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
				<input type="password" class="form-control" name="pw" id="pw" value="1" required placeholder="password ...">
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clipboard"></i></span></div>
				<input type="text" class="form-control" name="name" id="name" value="홍길동" required placeholder="name ...">
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-comment-dots"></i></span></div>
				<input type="text" class="form-control" name="age" id="age" required placeholder="age ...">
			</div>
			<div class="form-group input-group">
				<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-comment-dots"></i></span></div>
				<input type="text" class="form-control" name="gender" id="gender" value="남자" required placeholder="age ...">
			</div>

			<div class="form-group input-group">
				<div class="form-group input-group">
					<div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-comment-dots"></i></span></div>
					<input type="text" class="form-control" name="email" id="email" required placeholder="email ...">
				</div>
				<div class="form-group mt-md-5">
					<input type="reset" class="btn btn-success float-right login-btn ml-sm-2" value="새로고침"/>
					<input type="submit" class="btn btn-success float-right login-btn" value="회원등록"/>
				</div>
			</div>		
		</form>
	</div>
</body>
</html>















