<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var result= <%=request.getAttribute("result")%>
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
			var str= "<tr><td>이름</td><td>"+result.customerName+"</td></tr>"
			str= str+"<tr><td>주민번호</td><td>"+result.customerRrn+"</td></tr>"
			str= str+"<tr><td>주소</td><td>"+result.customerAddress+"</td></tr>"
			str= str+"<tr><td>성별</td><td>"+result.customerGender+"</td></tr>"
			str= str+"<tr><td>계좌번호</td><td>"+result.customerAccountNo+"</td></tr>"
			str= str+"<tr><td>직업</td><td>"+result.customerJob+"</td></tr>"
			$("tbody").append(str);
	})
</script>
</head>
<body>
	<table>
		<thead></thead>
		<tbody></tbody>
	</table>
</body>
</html>