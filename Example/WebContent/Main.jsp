<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
a{
text-decoration: none;
}
li{
font-size: 30px;
}

</style>
</head>
<body>
<h1><a href="#">Ajax Practice</a></h1>
	<nav>
		<ol id="list">
		</ol>
	</nav>
	
	<div id="here">
	</div>
	<div id="end">
	감사합니다!
	</div>
	
</body>

<script>
function getInfo(language){
	let lang = language + ".jsp";
	fetch(lang).then((response)=>{
		response.text().then((text)=>{
			document.querySelector('#here').innerHTML = text;
		})
	})
}
if(location.hash){
	getInfo(location.hash.substr(2));
}else{
	getInfo('index');
}

fetch('list.jsp').then((response)=>{
	response.text().then((text)=>{
		let tag = text.split(',');
		let listArr = "";
		for(let i of tag){
			console.log(tag[i]);
			listArr += '<a href=\"#!'+i+'\" onclick=\"getInfo(\''+i+'\')\"><li> '+i+' </li></a>';
		}
		console.log(listArr);
		document.querySelector('#list').innerHTML = listArr;
	})
})

</script>
</html>