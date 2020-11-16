<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% // 이안에 Java 코드를 사용할 수 있습니다. %>
<% int num = 0; %>
<%  // 지시어 호출은 이런식으로 @page를 씁니다. %>


<%  // 자바코드 작성
	// hour, min, sec 
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	String time = sdf.format(now);
	String hour = time.substring(8,10);
	String min = time.substring(10,12);
	String sec = time.substring(12,14);
	int H = now.getHours();
	int M = now.getMinutes();
	int S = now.getSeconds();

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	num : <%= num %><br>
	현재시간 : <%= hour %>시 <%= min %>분 <%= sec %>초<br>
	현재시간 : <%= H %>시 <%= M %>분 <%= S %>초
</body>
</html>