<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="import"
	href="http://localhost:8087/dionysus/heads/bootstrap.html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid" align="left">

		<h1>공지사항</h1>
		<br>
		<div class="container">
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>글번호</td>
						<td>글제목</td>
						<td>작성일자</td>
						<td>작성자</td>
						<td>조회수</td>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div id="pagination"></div>
		</div>
	</div>

</body>
<script>
	var result =
<%=request.getAttribute("result")%>
	$(function() {
		var list = result.list;
		var pagination = result.pagination;
		var target = $("tbody");
		$.each(list, function(idx, notice) {
			var str = "<tr><td>" + notice.noticeId + "</td>";
			str = str + "<td><a href='view?pageNo=" + pagination.pageNo
					+ "&noticeId=" + notice.noticeId + "'>"
					+ notice.noticeTitle + "</a></td>";
			str = str + "<td>" + notice.noticeWritedate + "</td>";
			str = str + "<td>" + notice.noticeWriter + "</td>";
			str = str + "<td>" + notice.noticeViews + "</td></tr>"
			target.append(str);
		});
		$("#pagination").append("<ul class='pagination pagination-sm'></ul>");
		var p = $("#pagination ul");
		if (pagination.prev > -1)
			p.append("<li><a href='list?pageNo=" + pagination.prev
					+ "'>이전으로</a></li>");
		for (var i = pagination.startPaging; i <= pagination.lastPaging; i++)
			p.append("<li><a href='list?pageNo=" + i + "'>" + i + "</a></li>");
		if (pagination.next > -1)
			p.append("<li><a href='list?pageNo=" + pagination.next
					+ "'>다음으로</a></li>");
	});
</script>
</html>
