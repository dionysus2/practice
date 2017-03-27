<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import"
	href="http://localhost:8087/dionysus/heads/bootstrap.html">
<script>
	var result =
<%=request.getAttribute("result")%>
	
</script>
<script src="https://www.w3schools.com/lib/w3data.js"></script>

</head>
<body>
	<div w3-include-html="http://localhost:8087/dionysus/navs/nav.html"></div>
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
				</ul>
			</div>


			<div class="col-sm-10">
				<div class="jumbotron">
					<div class="row">
						<p id="wineList"></p>
					</div>
					<div id="content">
						<section id="content-main">
						<table>
							<tbody>
							</tbody>
						</table>
						<div id="pagination"></div>
						</section>
					</div>
				</div>
			</div>
</body>
<script>
	<script>
	var text = "";
	for (var i = 0; i < 12; i++) {
		text += '<div class="col-md-3"> <div class="thumbnail"> <a href="restaurants/restaurants.html">'
				+ '<img src="images/res1.jpg" alt="Lights" style="width: 100%"> <div class="caption"> <p>Lorem ipsum...</p> </div> </a> </div> </div>';
	}
	document.getElementById("wineList").innerHTML = text;
</script>
$(document) .ready( function() { var list = result.list; var pagination
= result.pagination; var target = $("#content-main table tbody");
$.each(list, function(index, wine) { var str = "
<tr>
	<td>" + wine.wineInfoId + "</td>"; str = str + "
	<td><a
		href='view?pageNo="
									+ pagination.pageNo + "&wineInfoId="
									+ wine.wineInfoId + "'>"
			+ wine.wineInfoName + "</a></td>"; str = str + "
	<td>" + wine.wineInfoOrigin + "</a></td>"; str = str + "
	<td>" + wine.wineInfoProfilePicture + "</a></td>"; str = str + "
	<td>" + wine.wineSellerId + "</a></td>"; str = str + "
	<td>" + wine.wineInfoProfilePicture + "</td>
	<td>
</tr>
"; target.append(str); }) $("#pagination").append("
<ul></ul>
"); var p = $("#pagination ul"); if (pagination.prev > -1) p.append("
<li><a href='list?pageNo="
									+ pagination.prev + "'>이전으로</a></li>");
for (var i = pagination.startPaging; i <= pagination.lastPaging; i++)
p.append("
<li><a href='list?pageNo=" + i + "'>" + i + "</a></li>"); if
(pagination.next > -1) p.append("
<li><a href='list?pageNo="
									+ pagination.next + "'>다음으로</a></li>");
})
</script>
</html>