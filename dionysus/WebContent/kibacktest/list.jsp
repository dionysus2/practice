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

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
					<h3>레스토랑 정보</h3>
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
	$(document).ready(function() {
						var list = result.list;
						var pagination = result.pagination;
						var target = $("#content-main table tbody");
						$.each(list,function(index, res) {
							var str = "<div class='col-md-3'> <div class='thumbnail'> <a href='search/wineInfo.jsp'> <img src='../images/wine.jpg' alt='Lights' "
									+ "style='width: 100%'> <div class='caption'>";
							str = str+ "<p><a href='view?resInfoId="+res.ResInfoId+"'>"+ res.ResInfoName+ "</a></p>";
							str = str +"<p>"+ "<img src='/dionysus/img/"+res.ResInfoPicture1+"'>"+ "</p>";
							str = str +"<p>"+ "<img src='/dionysus/img/"+res.ResInfoPicture2+"'>"+ "</p>";
							str = str +"<p>"+ "<img src='/dionysus/img/"+res.ResInfoPicture3+"'>"+ "</p>";
							str = str + "<p>죄석수: "+ res.resInfoAvailableSeat+ "석</a></p>";
							str = str + "<p>개점시간: "+ res.ResInfoOpeningHours+ "시</a></p>";
							str = str + "<p>웹사이트: "+ res.ResInfoWebsite+ "사이트</a></p>";
							str = str+ "<p>레스토랑 번호"+res.ResId+"번>"+ "</p> </div> </a> </div></div>";
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