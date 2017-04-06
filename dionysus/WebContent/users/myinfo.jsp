<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
var result= <%=request.getAttribute("result")%>
</script>
<script>
	var list= result.list;
	$(document).ready(function(){
			var str= "<tr><td>아이디</td><td>"+<%=session.getAttribute("basicInfoUsername")%>+"</td></tr>"
			str= str+"<tr><td>이름</td><td>"+list.customerName+"</td></tr>"
			str= str+"<tr><td>주민번호</td><td>"+list.customerRrn+"</td></tr>"
			str= str+"<tr><td>주소</td><td>"+list.customerAddress+"</td></tr>"
			str= str+"<tr><td>성별</td><td>"+list.customerGender+"</td></tr>"
			str= str+"<tr><td>계좌번호</td><td>"+list.customerAccountNo+"</td></tr>"
			str= str+"<tr><td>직업</td><td>"+list.customerJob+"</td></tr>"
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