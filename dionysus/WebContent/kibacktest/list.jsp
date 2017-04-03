<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import"
	href="http://localhost:8087/dionysus/heads/bootstrap.html">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://www.w3schools.com/lib/w3data.js"></script>
<script>
	var result=<%=request.getAttribute("result")%>
	$(function() {
		var list = result.list;
		var pagination = result.pagination;
		var target = $("tbody");
		$.each(list, function(idx, res) {
			var str = "<tr><td>"+res.resInfoId+"</td>";
			str = str + "<td><a href='view?pageNo=" + pagination.pageNo + "&res.resinfoId=" + res.resInfoId + "'>" + res.resInfoName + "</a></td>";
			str	= str + "<td>" + res.resInfoPicture1 +"</td>";
			str = str + "<td>" + res.resInfoAvailable + "</td>";
			str = str + "<td>" + res.resInfoAvailable + "</td>";
			str = str + "<td>" + res.resInfoWebsite + "</td>";
			str = str + "<td>" + res.resInfoSeat + "</td></tr>"
			target.append(str);
		});
		$("#pagination").append("<ul></ul>");
		var p = $("#pagination ul");
		if (pagination.prev > -1)
			p.append("<li><a href='list?pageNo=" + pagination.prev + "'>이전으로</a></li>");
		for (var i = pagination.startPaging; i <= pagination.lastPaging; i++)
			p.append("<li><a href='list?pageNo=" + i + "'>" + i + "</a></li>");
		if (pagination.next > -1)
			p.append("<li><a href='list?pageNo=" + pagination.next + "'>다음으로</a></li>");
	});
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
	
	<h1>공지사항 게시판</h1>
	<table border="1">
		<tbody>
		</tbody>
	</table>    
	<div id="pagination"></div>  
</body>
</html>