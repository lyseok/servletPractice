<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.js"></script>
<script>
	$(function() {
		$('#lprodBtn').on('click', function () {
			$.ajax({
				url : "<%=request.getContextPath() %>/lprodListSem.do",
				type: "post",
				success: function(data) {
					console.log(data)
					code = '<table border="1">';
					code += '<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>';
						$.each(data, function(i, v){
							code += `<tr><td>\${v.lprod_id}</td>`;
							code += `<td>\${v.lprod_gu}</td>`;
							code += `<td>\${v.lprod_name}</td></tr>`;
						});
						code += '</table>';
						$('#result').html(code);
				},
				error: function(xhr){
					alert("오류 : " + xhr.status);
				},
				dataType: "json"
			});
		});

		$('#lprodBtn2').on('click', function () {
			location.href = "<%=request.getContextPath() %>/lprodList2.do";
		})
	});
</script>
</head>
<body>
<form action="">
	<input type="button" value="Lprod자료 가져오기(ajax)" id="lprodBtn">
	<input type="button" value="Lprod자료 가져오기(non ajax)" id="lprodBtn2">
</form>

<h3>Lprod목록</h3>
<div id="result"></div>

</body>
</html>