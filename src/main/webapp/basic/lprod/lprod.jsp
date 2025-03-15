<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.js"></script>

<script>
$(function(){
  $('#get').on('click', function() {
    $.ajax({
      success: function(data) {
        console.log(data);
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

      },
      url: "<%=request.getContextPath() %>/getLprod.do",
      type: 'post',
      dataType: 'json'

    })
  });
});

</script>
<body>
  <input type="button" value="Lprod자료 가져오기" id="get">
  <h3>Lprod 자료 목록</h3>
  <div id="result">  </div>
</body>
</html>