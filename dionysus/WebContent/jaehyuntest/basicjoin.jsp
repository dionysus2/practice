<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	
</script>
</head>
<body>
	<form action="/dionysus/basic/insert" method="post">
		<h1>회원가입</h1>
		<table border="1">
			<tr><td>아이디</td><td><input type="text" name="basicInfoUsername"></td></tr>
			<tr><td><button id="check">중복체크</button>
			<tr><td>비밀번호</td><td><input type="password" name="basicInfoPwd"></td></tr>
			<tr><td>이메일</td><td><input type="text" name="basicInfoEmail"></td></tr>
		</table>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>