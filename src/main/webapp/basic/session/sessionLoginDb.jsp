<%@page import="basic.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	// 로그인 정보가 저장된 Session데이터를 구한다
	MemberVO vo = (MemberVO)session.getAttribute("LOGINMEMBER");
%>

<body>

<%
if(vo == null){
%>

	<form action="<%=request.getContextPath() %>/sessionLoginDb.do" method="post">
		<table border="1" style="margin:0 auto;">
			<tr>
				<td><label for="id">ID : </label></td>
				<td><input type="text" name="id" placeholder="ID"></td>
			</tr>
			<tr>
				<td><label for="pass">PW : </label></td>
				<td><input type="password" name="pw" placeholder="password"><br></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	
<%
} else {
%>

<div style="text-align: center;">
	<h3><%=vo.getMem_name() %>님 반갑습니다.</h3><br><br>
	<a href="<%=request.getContextPath() %>/sessionLogoutDb.do">로그아웃</a>
</div>

<%
}
%>
	
</body>
</html>