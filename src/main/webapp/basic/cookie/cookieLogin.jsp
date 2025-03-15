<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookieArr = request.getCookies();
		String id = "";
		String ch = "";
		if(cookieArr != null){
			for(Cookie cookie : cookieArr) {
				if("id".equals(cookie.getName())){
					id = cookie.getValue();	
				}
			}
		}
	%>
	<form action="<%=request.getContextPath() %>/cookieLoginServlet.do" method="post">
		<table style="margin:0 auto; border: 1px solid; padding: 15px;">
		<tr>
			<td><label for="id">ID : </label></td>
			<td><input type="text" name="id" placeholder="ID" value=<%=id %>></td>
		</tr>
		<tr>
			<td><label for="pass">PW : </label></td>
			<td><input type="password" name="pw" placeholder="password"><br></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" name="idCh" value="true" checked=<%=ch %>>ID기억하기
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>