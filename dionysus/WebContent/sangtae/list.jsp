<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
var result = <%=request.getAttribute("result")%>;
</script>
</head>
<body>
	<form action="dionysus/res/list" method="post"enctype="multipart/form-data">
	<table>
			<thead>
				<th>���</th>
				<th>�ּ�</th>
				<th>��ȭ</th>
				<th>����</th>
				<th>����</th>
				<th>Ȱ��ȭ</th>
				<th>�̸�</th>
				<th>���̵��ȣ</th>
			</thead>
	
	</table>
	</form>

</body>
</html>