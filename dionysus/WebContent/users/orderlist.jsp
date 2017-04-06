<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	var result =
<%=request.getAttribute("result")%>
	
</script>

</head>
<body>
	<div class="container-fluid" align="left">

		<h1>주문내역</h1>
		<br>
		<div class="container" align="center">
			<table>
				<thead>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div id="orderInfo"></div>
		</div>
	</div>
</body>
<script>
	$(document).ready(
			function() {
				var orderList = result.orderList;
				var wineList = result.wineList;
				var target = $("tbody");
				$.each(orderList, function(index, order) {
					var str = "<tr><td>주문일자<td>" + order.wineOrderDate
							+ "</td>";
					str = str + "<td>주문금액</td><td>" + order.wineOrderAmount
							+ "</td></tr>";
					target.append(str);
					$.each(wineList, function(index, wine) {
						var str = "<tr><td>와인이름:</td><td>" + wine.wineInfoName
								+ "</td></tr>";
						str = str + "<tr><td>와인가격:<td><td>"
								+ wine.wineInfoPrice + "원</td><tr>";
						str = str + "<tr><td>용량:<td><td>"
								+ wine.wineInfoCapacity + "</td><tr>";
						str = str + "<tr><td>생산국가:<td><td>"
								+ wine.wineInfoCountry + "</td><tr>";
						str = str + "<tr><td>생산지:<td><td>"
								+ wine.wineInfoRegion + "</td><tr>";
						str = str + "<tr><td>제조사:<td><td>"
								+ wine.wineInfoWinery + "</td><tr>";
						str = str + "<tr><td>수입사:<td><td>"
								+ wine.wineInfoImporter + "</td><tr>";
						str = str + "<tr><td>빈티지:<td><td>"
								+ wine.wineInfoVintage + "</td><tr>";
						str = str + "<tr><td>품종:<td><td>" + wine.wineInfoGrapes
								+ "</td><tr>";
						str = str + "<tr><td>알고올도수:<td><td>" + wine.wineInfoABV
								+ "</td><tr>";
						str = str + "<tr><td>와인종류:<td><td>" + wine.wineInfoType
								+ "</td><tr>";
						str = str + "<tr><td>와인등급:<td><td>"
								+ wine.wineInfoClassification + "</td><tr>";
						str = str + "<tr><td>향:<td><td>" + wine.wineInfoFlavors
								+ "</td><tr>";
						str = str + "<tr><td>당도:<td><td>"
								+ wine.wineInfoSweetness + "</td><tr>";
						str = str + "<tr><td>산도:<td><td>"
								+ wine.wineInfoAcidity + "</td><tr>";
						str = str + "<tr><td>바디:<td><td>" + wine.wineInfoBody
								+ "</td><tr>";
						target.append(str);
					})
				})
			})
</script>
</html>