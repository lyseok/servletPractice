<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request연습 Form(숫자 입력은 정수형으로 입력하세요)</h1>
	
	<br><hr><br>
	<form action="<%=request.getContextPath() %>/requestTest02.do">
		<input type="text" name="input1" size="5">
		<select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		<input type="text" name="input2" size="5">
		<input type="submit" value="확인">
	</form>
</body>
</html>