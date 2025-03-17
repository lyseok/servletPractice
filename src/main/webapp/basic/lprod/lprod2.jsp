<%@page import="basic.lprod.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
@SuppressWarnings("unchecked")
List<LprodVO> list = (List<LprodVO>)request.getAttribute("list");
%>

<title>Insert title here</title>
</head>
<body>


<table border="1">
<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>

<%
	for(LprodVO v : list) {
%>
	<tr>
		<td><%=v.getLprod_id() %></td>
		<td><%=v.getLprod_gu() %></td>
		<td><%=v.getLprod_name() %></td>
	</tr>
<%
	}
%>

</table>
        
        
</body>
</html>