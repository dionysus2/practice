<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

		<div class="jumbotron">
			<form class="form-inline">
				<input type="text" class="form-control" placeholder="Search">
				<div class="input-group">
					<select class="form-control" id="sel1">
						<option>서울</option>
						<option>부산</option>
						<option>대구</option>
						<option>인천</option>
					</select>
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>

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

				<div class="row">
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
		</div>
	</div>
</body>

<script>
	$(document)
			.ready(
					function() {
						var list = result.list;
						var pagination = result.pagination;
						var target = $("#content-main table tbody");
						$
								.each(
										list,
										function(index, wine) {
											var str = "<div class='col-md-3'> <div class='thumbnail'> <a href='search/wineInfo.jsp'> <img src='../images/wine.jpg' alt='Lights' "
													+ "style='width: 100%'> <div class='caption'> <p>"
													+ wine.wineInfoId + "</p>";
											str = str
													+ "<p><a href='view?pageNo="
													+ pagination.pageNo
													+ "&wineInfoId="
													+ wine.wineInfoId + "'>"
													+ wine.wineInfoName
													+ "</a></p>";
											str = str + "<p>"
													+ wine.wineInfoOrigin
													+ "</a></p>";
											str = str
													+ "<p>"
													+ wine.wineInfoProfilePicture
													+ "</a></p>";
											str = str + "<p>"
													+ wine.wineSellerId
													+ "</a></p>";
											str = str
													+ "<p>"
													+ wine.wineInfoProfilePicture
													+ "</p> </div> </a> </div></div>";
											target.append(str);
										})
						$("#pagination").append(
								"<ul class='pagination pagination-lg'></ul>");
						var p = $("#pagination ul");
						if (pagination.prev > -1)
							p.append("<li><a href='list?pageNo="
									+ pagination.prev + "'>이전으로</a></li>");
						for (var i = pagination.startPaging; i <= pagination.lastPaging; i++)
							p.append("<li><a href='list?pageNo=" + i + "'>" + i
									+ "</a></li>");
						if (pagination.next > -1)
							p.append("<li><a href='list?pageNo="
									+ pagination.next + "'>다음으로</a></li>");
					})
</script>
</html>