<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>
</body>

<script>
  
  (()=>{
    // 로그인
	 if(${requestV}===1){
		alert("${issucess}");
		location.href="Login.jsp"; 
	// 디테일	
	 }else if(${requestV}===2){
		alert("${issucess}");
		location.href="BoardDetailController?index=${index}&hits=${hits}&page=${page}"; 
	// 리스트
	 }else if(${requestV}===3){
			alert("${issucess}");
			location.href="BoardController?page=${page}"; 
	 }
        
  })();
  
  </script>
</html>