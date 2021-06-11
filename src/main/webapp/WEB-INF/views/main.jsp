<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<div id="membersection">
	<h2>홈페이지입니다.</h2>
	
	<c:if test="${!empty member}">
	
		<p>${member.name}, 세션 유지중입니다.</p>
		<button id="logout">로그아웃</button>
	</c:if>
	<c:if test="${empty member}">
		<form action="login" method="post">
			<input type="text" name="email" id="email" placeholder="이메일 입력"><br>
			<input type="password" name="password" id="password" placeholder="비밀번호 입력"><br>
			<input type="button" id="login" value="로그인">
		</form>
		<a href="signin">가입</a>
	</c:if>
	
	</div>
	
	<div id="chatting">
		<p>채팅 칸입니다.</p>
	
	</div>
	
	<script>
	
	$().ready(function(){
		
		
		$("#logout").click(function(){
			$.ajax({
				type : "GET",
				url : "logout",
				datatype : "text",
				success : function() {
					
					$("#membersection").load(location.href+" #membersection")
				},
				error : function(error,request,status) {
					alert('로그아웃 실패')
					console.log(error)
				}
			})
		})
			
		$("#login").click(function(){
			var dataform = {
					email : $("#email").val(),
					password : $("#password").val()
			}
			$.ajax({
				type : "POST",
				url : "login",
				data : dataform,
				dataType : "text",
				success : function(data) {
					console.log($("#membersection").html())
					$("#membersection").load(location.href+"#membersection")
				},
				error : function(error,request,status) {
					alert('오류가 발생했습니다')
					console.log(error)
				}
			})
			
		})
		
		
		
	})
	</script>
</body>
</html>