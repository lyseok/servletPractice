<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<%
	// jsp문서에서는 Session객체가 자동으로 생성되어 'session'이라는 변수에 저장되어 있다
	session.getAttribute("userName");
%>
<body>
	<a href="<%=request.getContextPath()%>/sessionAdd.do">Session 정보 저장하기</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/sessionRead.do">Session 정보 읽어오기</a>
	<br><br>
	<a href="<%=request.getContextPath()%>/sessionDel.do">Session 정보 삭제하기</a>
	<br><br>
</body>
</html>