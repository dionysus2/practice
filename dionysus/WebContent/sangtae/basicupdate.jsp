<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="script/jquery-3.1.1.min.js"></script>
<script>
	var result= request.getAttribute("result");
</script>
</head>
<body>
	<%=session.getAttribute("basicInfoUsername") %>님 정보변경 페이지
</body>
</html>