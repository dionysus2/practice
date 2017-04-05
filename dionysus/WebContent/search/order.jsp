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
	$(document).ready(function() {
		var price= <%=(int)session.getAttribute("wineInfoPrice")%>;
		$("#count").bind("change", function() {
			var index="";
			$("#count option:selected").each(function() {
				index+=$(this).text()+"";
			})
			$("#wineOrderPrice").html(price*index+"(원)");
		})
		$("#count").change();
	})
</script>
</head>
<body>
	<h1>주문페이지</h1>
	<form action="/dionysus/wineinfo/wineorder/insert" method="post">
		<table>
			<tr><td>와인 주문일자</td><td><input type="date" name="wineOrderDate"></td></tr>
			<tr><td>와인 가격</td><td id="wineOrderPrice"></td></tr>
			<tr><td>와인 개수</td><td>
						<select name="wineOrderInfoCount" id="count">
							<option value="1" selected="selected">1</option>
							<option value="2" >2</option>
							<option value="3" >3</option>
							<option value="4" >4</option>
							<option value="5" >5</option>
							<option value="6" >6</option>
							<option value="7" >7</option>
							<option value="8" >8</option>
							<option value="9" >9</option>
							<option value="10">10</option>
						</select></td></tr>
		</table>
		<div><input type="submit" value="주문하기"></div>
	</form>
		<div><button id="btn">취소하기</button></div>
</body>
</html>