<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 로그인</h1>
	<form action="/dionysus/manager/login" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="basicInfoUsername"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="basicInfoPwd"></td>
			</tr>
			<label for="sel1">Select list:</label>
			<select class="form-control" id="sel1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>

		</table>
		<div>
			<input type="submit" value="관리자 로그인">
		</div>
	</form>
</body>
</html>