<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>img 태그의 src속성에 서블릿으로 이미지 불러오기</h3>

<img alt="" src="<%=request.getContextPath()%>/images/chopa.jpg" width="200px"><br><br>

<img alt="" src="<%= request.getContextPath() %>/imageView.do?fileno=12" width="200px"><br><br>
</body>
</html>