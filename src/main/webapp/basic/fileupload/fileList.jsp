<%@page import="basic.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	
	// controller에서 보내온 자료를 받는다 => request객체의 getAttribute()메서드 이용
	@SuppressWarnings("unchecked")
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("fileList");
	
%>

<body>

<h3>전체 파일 목록</h3><br><br><br>

<a href="<%=request.getContextPath() %>/fileUpload.do">파일 업로드</a>

<table border="1">
	<thead>
	<tr>
		<th>파일번호</th><th>작성자</th><th>원래 파일명</th><th>저장 파일명</th>
		<th>파일 크기</th><th>날짜</th><th>다운로드</th><th>삭제</th>
	</tr>
	</thead>
	<tbody>
<%
	if(fileList == null || fileList.size() == 0){
%>
	<tr>
		<td colspan="7">파일 목록이 비어있습니다.</td>
	</tr>
<%
	} else {
		for(FileInfoVO vo : fileList){
%>

	<tr>
		<td><%=vo.getFile_no() %></td>
		<td><%=vo.getFile_writer() %></td>
		<td><%=vo.getOrigin_file_name() %></td>
		<td><%=vo.getSave_file_name() %></td>		
		<td><%=vo.getFile_size() %></td>
		<td><%=vo.getFile_date() %></td>
		<td><a href="<%=request.getContextPath() %>/fileDownload.do?fileno=<%=vo.getFile_no() %>">Download</a></td>
		<td><a href="<%=request.getContextPath() %>/fileDelete.do?fileno=<%=vo.getFile_no() %>">Remove</a></td>
	</tr>

<%
		}
	}
%>
	
	</tbody>
</table>
	
</body>
</html>