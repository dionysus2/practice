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
	var result = <%=request.getAttribute("result")%>;
	var pageNo = <%= request.getParameter("pageNo") %>;
</script>
<script>
		$(document).ready(function() {
			$("#pagination").on("click","#update", function() {
				location.href='update?noticeId=' + result.noticeId;
			});	
			
			$("#pagination").on("click","#list", function() {
				location.href='list?pageNo=' + pageNo;
			});		
				var str = "<tr><td>글번호</td><td>" + result.noticeId + "</td></tr>"; 
				str = str + "<tr><td>글제목</td><td>" + result.noticeTitle + "</td></tr>";
				str = str +  "<tr><td>작성자</td><td>" + result.noticeWriter + "</td></tr>";
				str = str +  "<tr><td>작성일자</td><td>" + result.noticeWritedate + "</td></tr>";
				str = str +  "<tr><td>글내용</td><td>" + result.noticeContent + "</td></tr>";
				str = str +  "<tr><td>조회수</td><td>" + result.noticeViews + "</td></tr>";
				$("#content-main tbody").append(str);
				
				var pagination = $("#pagination");
				pagination.append("<button id='update'>내용 수정</button>");
				pagination.append("<button id='list'>리스트로</button>");
		});
</script>
</head>
<body>
	<section id="content-main">
		<table border="1">
			<tbody>
			</tbody>
		</table>
		<div id="pagination"></div>
	</section>
</body>
</html>
