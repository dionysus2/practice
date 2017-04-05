<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import"
	href="http://localhost:8087/dionysus/heads/bootstrap.html">
</head>
<script src="https://www.w3schools.com/lib/w3data.js"></script>
<body>
	<div w3-include-html="http://localhost:8087/dionysus/navs/nav.jsp"></div>
	<script>
		w3IncludeHTML();
	</script>

	<div class="container-fluid" align="center">

		<div class="row">
			<div class="col-sm-2">
				<ul class="nav  nav-stacked">
					<h3>가격별</h3>
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Menu 1</a></li>
					<li><a href="#">Menu 2</a></li>
					<li><a href="#">Menu 3</a></li>
					<h3>국가별</h3>
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Menu 1</a></li>
					<li><a href="#">Menu 2</a></li>
					<li><a href="#">Menu 3</a></li>
					<h3>종류별</h3>
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Menu 1</a></li>
					<li><a href="#">Menu 2</a></li>
					<li><a href="#">Menu 3</a></li>
					<li><a href="/dionysus/wineinfo/insert">와인추가</a>
				</ul>
			</div>
			<div class="col-sm-10">
				<table>
					<tbody>
					</tbody>
				</table>
				<div>
					<a href="#"><button>주문하기</button></a>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	var result =
<%=request.getAttribute("result")%>
	$(document).ready(
			function() {
				var str = "<tr><td>와인이름:</td><td>" + result.wineInfoName
						+ "</td></tr>";
				str = str + "<tr><td>와인가격:<td><td>" + result.wineInfoPrice
						+ "원</td><tr>";
				str = str + "<tr><td>용량:<td><td>" + result.wineInfoCapacity
						+ "</td><tr>";
				str = str + "<tr><td>생산국가:<td><td>" + result.wineInfoCountry
						+ "</td><tr>";
				str = str + "<tr><td>생산지:<td><td>" + result.wineInfoRegion
						+ "</td><tr>";
				str = str + "<tr><td>제조사:<td><td>" + result.wineInfoWinery
						+ "</td><tr>";
				str = str + "<tr><td>수입사:<td><td>" + result.wineInfoImporter
						+ "</td><tr>";
				str = str + "<tr><td>빈티지:<td><td>" + result.wineInfoVintage
						+ "</td><tr>";
				str = str + "<tr><td>품종:<td><td>" + result.wineInfoGrapes
						+ "</td><tr>";
				str = str + "<tr><td>알고올도수:<td><td>" + result.wineInfoABV
						+ "</td><tr>";
				str = str + "<tr><td>와인종류:<td><td>" + result.wineInfoType
						+ "</td><tr>";
				str = str + "<tr><td>와인등급:<td><td>"
						+ result.wineInfoClassification + "</td><tr>";
				str = str + "<tr><td>향:<td><td>" + result.wineInfoFlavors
						+ "</td><tr>";
				str = str + "<tr><td>당도:<td><td>" + result.wineInfoSweetness
						+ "</td><tr>";
				str = str + "<tr><td>산도:<td><td>" + result.wineInfoAcidity
						+ "</td><tr>";
				str = str + "<tr><td>바디:<td><td>" + result.wineInfoBody
						+ "</td><tr>";
				$("tbody").append(str);
			})
</script>
</html>