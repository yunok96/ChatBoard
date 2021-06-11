<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>가입</h3>
	<form action="signinresult" onsubmit="return check()" method="post">
		<input type="text" name="email" id="email" placeholder="이메일 입력"><br>
		<input type="password" name="password" id="password" placeholder="비밀번호 입력"><br>
		<input type="text" name="name" id="name" placeholder="이름 입력"><br>
		<input type="submit" value="확인">
	</form>
	
	<script>
	//유효성 체크
	function check() {
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var name = document.getElementById("name").value;
		
		if(email == "" || password == "" || name == ""){
			alert('비어있는 항목이 있습니다');
			return false;
		} else{
			return true;
		}
	}
	</script>
</body>
</html>