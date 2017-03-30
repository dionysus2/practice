<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dionysus/wineinfo/insert" method="post" enctype="multipart/form-data">
		<h1>와인정보 등록페이지</h1>
		<h2>Sample</h2>
		<table>
			<tbody>
				<tr><td>와인이름:</td><td><input type="text" name="wineInfoName" size="20"></td></tr>
				<tr><td>와인대표이미지:</td><td><input type="file" name="wineInfoProfilePicture" size="20"></td></tr>
				<tr><td>금액:</td><td><input type="text" name="wineInfoPrice" size="20"></td></tr>
				<tr><td>용량:</td><td><input type="text" name="wineInfoCapacity" size="20"></td></tr>
				<tr><td>생산국가:</td><td><input type="text" name="wineInfoCountry" size="20"></td></tr>
				<tr><td>생산지:</td><td><input type="text" name="wineInfoRegion" size="20"></td></tr>
				<tr><td>제조사:</td><td><input type="text" name="wineInfoWinery" size="20"></td></tr>
				<tr><td>수입사:</td><td><input type="text" name="wineInfoImporter" size="20"></td></tr>
				<tr><td>빈티지:</td><td><input type="text" name="wineInfoVintage" size="20"></td></tr>
				<tr><td>품종:</td><td><input type="text" name="wineInfoGrapes" size="20"></td></tr>
				<tr><td>알코올 도수:</td><td><input type="text" name="wineInfoABV" size="20"></td></tr>
				<tr><td>종류:</td><td><input type="text" name="wineInfoType" size="20"></td></tr>
				<tr><td>등급:</td><td><input type="text" name="wineInfoClassification" size="20"></td></tr>
				<tr><td>향:</td><td><input type="text" name="wineInfoFlavors" size="20"></td></tr>
				<tr><td>당도:</td><td><input type="text" name="wineInfoSweetness" size="20"></td></tr>
				<tr><td>산도:</td><td><input type="text" name="wineInfoAcidity" size="20"></td></tr>
				<tr><td>바디:</td><td><input type="text" name="wineInfoBody" size="20"></td></tr>
				<tr><td>현재 접속되어 있는 아이디:<%=session.getAttribute("basicInfoUsername") %></td></tr>
			</tbody>
		</table>
		<div><input type="submit" value="상품등록"></div>
		</form>
</body>
</html>