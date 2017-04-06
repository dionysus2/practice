<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="import"
	href="http://localhost:8087/dionysus/heads/bootstrap.html">
</head>
<style>
body {
	padding-top: 70px
}
</style>

<script src="https://www.w3schools.com/lib/w3data.js"></script>
<body>
	<div
		w3-include-html="http://localhost:8087/dionysus/modals/forms/join.html"></div>
	<div
		w3-include-html="http://localhost:8087/dionysus/modals/forms/signIn.html"></div>
	<script>
		w3IncludeHTML();
	</script>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/dionysus/main/home"><img
					class="img-responsive"
					src="http://localhost:8087/dionysus/images/grapelogo.png"
					alt="logo" width="25" height="25"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/dionysus/wineinfo/list">와인</a></li>
					<li><a href="/dionysus/res/list">레스토랑</a></li>
					<li><a href="/diondysus/notice/list">공지사항</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="modal" data-target="#join"><span
							id="joinTool" class="glyphicon glyphicon-user"></span> 회원가입</a></li>
					<li><a href="#" data-toggle="modal" data-target="#signIn"><span
							id="loginTool" class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown"> <%=session.getAttribute("basicInfoUsername")%>
					</a>
						<ul class="dropdown-menu">
							<li><a
								href="http://localhost:8087/dionysus/users/manage.html">프로필
									수정</a></li>
							<li><a href="#">계정 관리</a></li>
							<li><a href="#">히스토리</a></li>
							<li><a href="/dionysus/wineinfo/wineorder/list">주문정보 조회</a>
							<li><a
								href="/dionysus/jaehyuntest/logout.jsp" id="signout">로그아웃</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<script>
		var result =<%=session.getAttribute("basicInfoUsername")%>
		$(document).ready(function() {
			if (result!= null) 
				$('.dropdown').show();
			else if(result==null)
				$('.dropdown').hide();
		$("#signout").click(function() {
				$('.dropdown').hide();
			})
		})
	</script>
</body>
</html>