<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	HTML 주석 영역
 -->
 
 <%--
	JSP 주석 영역
 --%>
 
 <%
 	// 이 영역은 JSP문서에서 Java명령을 사용할 수 있는 영역
 	// 이 영역은 '스크립트릿(scriptlet)'이라고 한다
 	String name = "홍길동";
 %>
 
 <%--
	 <%=변수나 수식 %> ==> JSP문서에서 '변수나 수식'의 결과를 출력할 때 사용한다
	 			    ==> 이것을 '표현식(Expression)'이라고 한다
 
 --%>
 
 <h3><%=name %>의 Request 연습용 Form</h3>
 <form action="<%=request.getContextPath() %>/requestTest01.do" method="post">
 <table border="1">
	 <tr>
		 <td>이 름</td>
		 <td><input type="text" size="10" name="username"/></td>
	 </tr>
	 <tr>
		 <td>직 업</td>
		 <td>
		 	<select name="job">
		 		<option value="무직">무직</option>
		 		<option value="회사원">회사원</option>
		 		<option value="전문직">전문직</option>
		 		<option value="학생">학생</option>
		 	</select>
		 </td>
	 </tr>
	 <tr>
	 	<td>취 미</td>
	 	<td>
	 		<input type="checkbox" name="hobby" value="여행">여행
	 		<input type="checkbox" name="hobby" value="독서">독서
	 		<input type="checkbox" name="hobby" value="게임">게임
	 		<input type="checkbox" name="hobby" value="운동">운동
	 		<input type="checkbox" name="hobby" value="음주">음주
	 	</td>
	 </tr>
	 <tr>
	 	<td colspan="2" style="text-align:center;">
	 		<input type="submit" value="전 송">
	 		<input type="reset" value="초기화">
	 	</td>
	 </tr>
 
 </table>
 
 </form>
 
 
</body>
</html>