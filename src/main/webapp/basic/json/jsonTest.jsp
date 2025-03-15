<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script>
	$(function() {

		$('#strBtn').on('click', function() {
			$.ajax({
				url: "<%=request.getContextPath() %>/json/jsonDataTest.do",
				type: 'post',
				data: 'choice=string',

				success: function(data) { // data변수에는 응답 데이터가 자동으로 저장된다
					console.log(data);
				},
				error: function(xhr) {
					alert("오류: " + xhr.status);
				},
				dataType: 'json'
			});

		});

		$('#arrayBtn').on('click', function() {
			$.ajax({
				url: "<%=request.getContextPath() %>/json/jsonDataTest.do",
				type: 'post',
				data: 'choice=array',

				success: function(data) { // data변수에는 응답 데이터가 자동으로 저장된다
					console.log(data);
					let code = '<h3>배열 처리 결과</h3>';
					$.each(data, function(i, v) {
						// code += i + '번째 자료 : ' + v + '<br>';
						code += `\${i}번째 자료 : \${v}<br>`;
					});
					$('#result').html(code);
				},
				error: function(xhr) {
					alert("오류: " + xhr.status);
				},
				dataType: 'json'
			});
		});

		$('#objBtn').on('click', function() {
			$.ajax({
				url: "<%=request.getContextPath() %>/json/jsonDataTest.do",
				type: 'post',
				data: 'choice=obj',

				success: function(data) { // data변수에는 응답 데이터가 자동으로 저장된다
					let code = '<h3>객체 처리 결과</h3>';
					code += `번호 : \${data.num}<br>`;
					code += `이름 : \${data.name}<br>`;
					code += `주소 : \${data.addr}<br>`;

					$('#result').html(code);
				},
				error: function(xhr) {
					alert("오류: " + xhr.status);
				},
				dataType: 'json'
			});
		});

		$('#listBtn').on('click', function() {
			$.ajax({
				url: "<%=request.getContextPath() %>/json/jsonDataTest.do",
				type: 'post',
				data: 'choice=list',

				success: function(data) { // data변수에는 응답 데이터가 자동으로 저장된다
					console.log(data);
					let code = '<h3>리스트 처리 결과</h3>';
					$.each(data, function(i, v) {
						code += (i+1) + "번째 자료<br>";
						code += `번호 : \${v.num}<br>`;
						code += `이름 : \${v.name}<br>`;
						code += `주소 : \${v.addr}<br>`;
					});
					$('#result').html(code);
				},
				error: function(xhr) {
					alert("오류: " + xhr.status);
				},
				dataType: 'json'
			});
		})

		$('#mapBtn').on('click', function() {
			$.ajax({
				url: "<%=request.getContextPath() %>/json/jsonDataTest.do",
				type: 'post',
				data: 'choice=map',

				success: function(data) { // data변수에는 응답 데이터가 자동으로 저장된다
					console.log(data);
					let code = '<h3>Map 처리 결과</h3>';
					code += `이름 : \${data.name}<br>`;
					code += `번호 : \${data.tel}<br>`;
					code += `주소 : \${data.addr}<br>`;
					$('#result').html(code);
				},
				error: function(xhr) {
					alert("오류: " + xhr.status);
				},
				dataType: 'json'
			});
		})

	});
</script>

</head>
<body>
<form action="">
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map 객체">
</form>

<div id="result"></div>

</body>
</html>