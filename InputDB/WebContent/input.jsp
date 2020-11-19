<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
        <form action="Inputdb" method="POST">
        아이디 : <input type="text" name="data1">
        비밀번호 : <input type="text" name="data2">
        <button type="submit">제출</button>
    </form>
    </div>
   	a 태그 조회 : <a href="selectData">data 조회</a>
    button 조회 : <button onclick="selectDB()">data 조회</button>
    
</body>

<script>
	function selectDB() {
		location.href="selectData";
	}
</script>
</html>