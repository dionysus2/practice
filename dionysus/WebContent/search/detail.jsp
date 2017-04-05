<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import"
	href="http://192.168.0.180:8087/dionysus/heads/bootstrap.html">
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
				<ul class="nav  nav-stacked" text-align="center">
					<h3>가격별</h3>
					<li><a href="#">0~50000</a></li>
					<li><a href="#">50000~100000</a></li>
					<li><a href="#">100000~200000</a></li>
					<li><a href="#">200000~300000</a></li>
					<li><a href="#">300000~400000</a></li>
					<li><a href="#">400000~500000</a></li>
					<h3>국가별</h3>
					<li><a href="#">프랑스</a></li>
					<li><a href="#">이탈리아</a></li>
					<li><a href="#">미국</a></li>
					<li><a href="#">독일</a></li>
					<li><a href="#">호주</a></li>
					<li><a href="#">뉴질랜드</a></li>
					<li><a href="#">칠레</a></li>
					<li><a href="#">남아공</a></li>
					<h3>종류별</h3>
					<li><a href="#">레드 와인</a></li>
					<li><a href="#">화이트 와인</a></li>
					<li><a href="#">로제 와인</a></li>
					<li><a href="#">스파클링 와인</a></li>

				</ul>
			</div>
			<div class="col-sm-10">
				<table>
					<tbody>
					</tbody>
				</table>
				<div>
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#order" data-dismiss="modal">주문하기</button>
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#" data-dismiss="modal">장바구니</button>
				</div>
			</div>
		</div>
	</div>

	<div id="order" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">와인 주문</h4>
				</div>
				<div class="modal-body">
					<form action="/dionysus/wineinfo/wineorder/insert" method="post">
						<table>
							<tr>
								<td>와인 주문일자</td>
								<td><input type="date" name="wineOrderDate"></td>
							</tr>
							<tr>
								<td>와인 가격</td>
								<td id="wineOrderPrice"></td>
							</tr>
							<tr>
								<td>와인 개수</td>
								<td><select name="wineOrderInfoCount" id="count">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
								</select></td>
							</tr>
						</table>
						<button type="submit" class="btn btn-default">주문하기</button>
						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#" data-dismiss="modal">취소하기</button>
					</form>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btn").on("click", function() {
			alert("감사합니다");
			location.replace("/dionysus/wineinfo/list");
		})
	})
	$(document).ready(function() {
		var price =
<%=(int) session.getAttribute("wineInfoPrice")%>
	;
		$("#count").bind("change", function() {
			var index = "";
			$("#count option:selected").each(function() {
				index += $(this).text() + "";
			})
			$("#wineOrderPrice").html(price * index + "(원)");
		})
		$("#count").change();
	})
</script>
</html>