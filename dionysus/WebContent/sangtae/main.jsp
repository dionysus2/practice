<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=session.getAttribute("basicInfoUsername") %>님 안녕하세요.
	<a href="basicupdate.jsp">정보변경</a>
	<a href="logout.jsp">로그아웃</a>
	<a href="/dionysus/wineinfo/list">와인상품</a>
	<a href="/dionysus/wineinfo/insert">와인상품 추가</a>
</body>
</html>