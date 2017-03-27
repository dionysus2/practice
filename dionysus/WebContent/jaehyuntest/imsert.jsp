<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dionysus/wineinfo/insert" method="POST" enctype="multipart/form-data">
		<h1>와인상품 추가페이지</h1>
		<table>
			<tbody>
				<tr><td>와인명:</td><td><input type="text" name="wineInfoName" size="20"></td></tr>
				<tr><td>와인이미지:</td><td><input type="file" name="wineInfoProfilePicture" size="20"></td></tr>
				<tr><td>와인가격:</td><td><input type="text" name="wineInfoPrice" size="20"></td></tr>
				<tr><td>와인용량:</td><td><input type="text" name="wineInfoCapacity" size="20"></td></tr>
				<tr><td>와인생산국가:</td><td><input type="text" name="wineInfoCountry" size="20"></td></tr>
				<tr><td>와인생산지:</td><td><input type="text" name="wineInfoRegion" size="20"></td></tr>
				<tr><td>와인제조사:</td><td><input type="text" name="wineInfoWinery" size="20"></td></tr>
				<tr><td>와인수입사:</td><td><input type="text" name="wineInfoImporter" size="20"></td></tr>
				<tr><td>와인빈티지:</td><td><input type="text" name="wineInfoVintage" size="20"></td></tr>
				<tr><td>와인품종:</td><td><input type="text" name="wineInfoGrapes" size="20"></td></tr>
				<tr><td>와인알코올도수:</td><td><input type="text" name="wineInfoABV" size="20"></td></tr>
				<tr><td>와인종류:</td><td><input type="text" name="wineInfoType" size="20"></td></tr>
				<tr><td>와인등급:</td><td><input type="text" name="wineInfoClassification" size="20"></td></tr>
				<tr><td>와인향:</td><td><input type="text" name="wineInfoFlavors" size="20"></td></tr>
				<tr><td>와인당도:</td><td><input type="text" name="wineInfoSweetness" size="20"></td></tr>
				<tr><td>와인산도:</td><td><input type="text" name="wineInfoAcidity" size="20"></td></tr>
				<tr><td>와인바디:</td><td><input type="text" name="wineInfoBody" size="20"></td></tr>
				<tr><td>상품 업로드 회원:</td><td><%=session.getAttribute("basicInfoUsername") %></td></tr>
			</tbody>
		</table>
		<div><input type="submit" value="업로드"><a href="main/jsp"><button>취소하기</button></a></div>
	</form>
</body>
</html>