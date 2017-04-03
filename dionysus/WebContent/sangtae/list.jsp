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
			p.append("<li><a href='list?pageNo=" + pagination.prev + "'>��������</a></li>");
		for (var i = pagination.startPaging; i <= pagination.lastPaging; i++)
			p.append("<li><a href='list?pageNo=" + i + "'>" + i + "</a></li>");
		if (pagination.next > -1)
			p.append("<li><a href='list?pageNo=" + pagination.next + "'>��������</a></li>");
	});
</script>
</head>
<body>
	<form action="dionysus/res/list" method="post"enctype="multipart/form-data"> 
	<div class="container-fluid" align="center">
	<h1>������� ����� ����</h1>
	<table border="1">
		<thead>		
			<tr><td>����������Թ�ȣ</td>			
			<td>����ڹ�ȣ</td>
			<td>����</td>
			<td>��ȭ</td>
			<td>����</td>
			<td>����</td>
			<td>Ȱ��ȭ����</td>
			<td>���������</td>				
		</thead>
		<tbody>
		</tbody>
	</table>    
	</div>
	</form>
	<div id="pagination"></div>  	
</body>
</html>