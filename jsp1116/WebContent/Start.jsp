<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% // �̾ȿ� Java �ڵ带 ����� �� �ֽ��ϴ�. %>
<% int num = 0; %>
<%  // ���þ� ȣ���� �̷������� @page�� ���ϴ�. %>


<%  // �ڹ��ڵ� �ۼ�
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
	����ð� : <%= hour %>�� <%= min %>�� <%= sec %>��<br>
	����ð� : <%= H %>�� <%= M %>�� <%= S %>��
</body>
</html>