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
	var result=<%=request.getAttribute("result")%>
</script>
<script>
		$(document).ready(function() {
			var list= result.list;
			var pagination= result.pagination;
			var target= $("#content-main table tbody");
			$.each(list, function(index, wine){
				var str= "<tr><td>"+ wine.wineInfoId+"</td>";
				str = str + "<td><a href='view?pageNo=" + pagination.pageNo + "&wineInfoId=" + wine.wineInfoId + "'>" + wine.wineInfoName+ "</a></td>";
				str = str + "<td>"+ wine.wineInfoOrigin+ "</a></td>";
				str = str + "<td>"+ wine.wineInfoProfilePicture+ "</a></td>";
				str = str + "<td>"+ wine.wineSellerId+ "</a></td>";
				str = str + "<td>" + wine.wineInfoProfilePicture + "</td><td></tr>";
				target.append(str);
			})
			$("#pagination").append("<ul></ul>");
			var p = $("#pagination ul");
			if (pagination.prev > -1)
				p.append("<li><a href='list?pageNo=" + pagination.prev + "'>이전으로</a></li>");
			for (var i = pagination.startPaging; i <= pagination.lastPaging; i++)
				p.append("<li><a href='list?pageNo=" + i + "'>" + i + "</a></li>");
			if (pagination.next > -1)
				p.append("<li><a href='list?pageNo=" + pagination.next + "'>다음으로</a></li>");
		})
	</script>
</head>
<body>
	<div id="content">
		<section id="content-main">
			<table>
				<tbody>
				</tbody>
			</table>
	<div id="pagination"></div>
	</section>
</body>
</html>