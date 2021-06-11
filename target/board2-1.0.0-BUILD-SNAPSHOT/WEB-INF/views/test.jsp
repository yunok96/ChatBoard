<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	heelll
	<c:forEach items="${testList}" var="test">
		<p>${test.num}</p>
		<p>${test.name}</p>
	</c:forEach>
</body>
</html>