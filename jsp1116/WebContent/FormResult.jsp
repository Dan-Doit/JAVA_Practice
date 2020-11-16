<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>FormResult Page</h1>
	<h2>Dispatcher 방식</h2>
	이름 : <%= request.getAttribute("Name") %><br><br>
	아이디 : <%= request.getAttribute("id") %><br><br>
	임의의값 : <%= request.getAttribute("sInfo") %>

</body>
</html>