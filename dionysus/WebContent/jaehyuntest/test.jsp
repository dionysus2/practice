<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>
<script>

$(document).ready(function(){
	$(select, option).each(function() {
		if($(this.val()==$("#customer"))){
			$("#confirm").click(function() {
				alert("테스트")			
			})
		}
	})
});
</script>
</head>
<body>
	<select>
		<option value="customer" id="customer">고객정보
		</option>
		<option value="wineSeller" id="wineSeller">와인업주
		</option>
		<option value="res" id="res">레스토랑업주</option>
	</select>
	<button id="confirm">이동</button>
</body>
</html>