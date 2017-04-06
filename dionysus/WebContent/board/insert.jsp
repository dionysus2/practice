<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dionysus/manager/notice/insert" method="POST">
		<table>
			<tr><td>글제목</td><td><input type="text" name="noticeTitle"></td></tr>
			<tr><td>내용</td></tr>
		</table>
		<div><textarea rows="30" cols="40" name="noticeContent"></textarea></div>
		<div><input type="submit" value="작성완료">
		<a href="/dionysus/manager/home"><input type="button" value="홈으로"></a></div>
	</form>
</body>
</html>