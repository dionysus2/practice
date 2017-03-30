<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dionysus/res/insert" method="post" enctype="multipart/form-data">
		<h1>레스토랑 사업자 회원가입</h1>
		<table>
			<tbody>
				<tr><td>번호</td><td><input type="text" name="resId" size="20"></td></tr>
				<tr><td>사업자번호:</td><td><input type="text" name="resBrn" size="20"></td></tr>
				<tr><td>지역:</td><td><input type="text" name="resLocation" size="20"></td></tr>
				<tr><td>전화번호:</td><td><input type="text" name="resTel" size="20"></td></tr>
				<tr><td>계좌번호:</td><td><input type="text" name="resAccountNo" size="20"></td></tr>
				<tr><td>회사사진:</td><td><input type="file" name="resProfilePicture" size="20"></td></tr>
				<tr><td>회사명:</td><td><input type="text" name="resName" size="20"></td></tr>
				<tr><td>기본번호:</td><td><input type="text" name="basicInfoId" size="20"></td></tr>
				
			</tbody>
		</table>
		<div><input type="submit" value="사업자가입"><a href="main/jsp"><button>취소하기</button></a></div>
	</form>
</body>
</html>