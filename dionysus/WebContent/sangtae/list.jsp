<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
var result=<%=request.getAttribute("result")%>
	$(function() {
		var list = result.list;
		var pagination = result.pagination;
		var target = $("tbody");
		$.each(list, function(idx, res) {
			var str = "<tr><td>"+res.resId+"</td>";
			str = str + "<td>"+res.resBrn+"</td>";
			str = str + "<td>"+res.resLocation+"</td>";
			str = str + "<td>"+res.resTel+"</td>";
			str = str + "<td>"+res.resAccountNo+"</td>";
			str = str + "<td>"+res.resProfilePicture+"</td>";
			str = str + "<td>"+res.resActivated+"</td>";
			str = str + "<td>"+res.resName+"</td></tr>";			
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
</head>
<body>
	<form action="dionysus/res/list" method="post"enctype="multipart/form-data"> 
	<div class="container-fluid" align="center">
	<h1>레스토랑 사업자 정보</h1>
	<table border="1">
		<thead>		
			<tr><td>레스토랑가입번호</td>			
			<td>사업자번호</td>
			<td>지역</td>
			<td>전화</td>
			<td>계좌</td>
			<td>사진</td>
			<td>활성화정보</td>
			<td>레스토랑명</td>				
		</thead>
		<tbody>
		</tbody>
	</table>    
	</div>
	</form>
	<div id="pagination"></div>  	
</body>
</html>