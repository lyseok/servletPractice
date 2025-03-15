<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Practice</title>
<style type="text/css">
	div {
	 	border : 2px solid black;
	 	display: block;
	 	padding: 10px;
	 	width : 300px;
	}
	a{
		display: block;
		margin: 10px;
	}
</style>
</head>
<body>
	<div>
		<a href="<%=request.getContextPath() %>/cookieCountServletSEM.do">Cookie Count 증가 하기</a><br>
		<a href="<%=request.getContextPath() %>/cookieCountDelServletSEM.do">Cookie Count 초기화 하기</a>
	</div>
</body>
</html>