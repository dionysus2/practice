<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="import"
	href="http://localhost:8087/dionysus/heads/bootstrap.html">
</head>
<script src="https://www.w3schools.com/lib/w3data.js"></script>

<body>
	<div
		w3-include-html="http://localhost:8087/dionysus/modals/forms/join.html"></div>
	<div
		w3-include-html="http://localhost:8087/dionysus/modals/forms/signIn.html"></div>
	
		<script>
		w3IncludeHTML();
	</script>
	
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="http://localhost:8087/dionysus/index.html"><img class="img-responsive" src="http://localhost:8087/dionysus/images/grapelogo.png" alt="logo" width="25" height="25"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="http://localhost:8087/dionysus/wineinfo/list">와인검색</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="modal" data-target="#join"><span
							class="glyphicon glyphicon-user"></span> 회원가입</a></li>
					<li><a href="#" data-toggle="modal" data-target="#signIn"><span
							class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
							<li><a href="#" data-toggle="modal" data-target="#signIn"><span
							class="glyphicon glyphicon-log-in"></span> <%=session.getAttribute("basicInfoUsername") %></a></li>
							
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>