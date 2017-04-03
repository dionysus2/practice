<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btn").on("click", function() {
				alert("감사합니다");
				location.replace("/dionysus/wineinfo/list");
		})
	})
</script>
</head>
<body>
	<h1>주문페이지</h1>
	<%@ include file="orderdetail.jsp"%>
	<form action="/dionysus/wineinfo/wineorder/insert" method="post">
		<table>
			<tr><td>와인 주문일자</td><td><input type="date" name="wineOrderDate"></td></tr>
			<tr><td>와인 가격</td><td><%=session.getAttribute("wineInfoPrice") %>원</td></tr>
		</table>
		<div><input type="submit" value="주문하기"></div>
	</form>
		<div><button id="btn">취소하기</button></div>
</body>
</html>