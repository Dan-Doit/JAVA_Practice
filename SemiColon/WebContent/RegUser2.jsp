<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
response.setDateHeader("Expires", 0L); // Do not cache in proxy server
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
      html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 80px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
	}

.card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
  }
  .blue{
  color : blue;
  }
  
    </style>
    <title>팀 세미콜론</title>

  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">회원가입</h2>
		</div>
		<div class="card-body">
      <form class="form-signin" onSubmit="goRegcall();return false" action="RegController" method="POST" name="Regform">
  		<h5 class="blue">멋진 아이디네요!</h5>
        <input type="hidden" id="uid" class="form-control" placeholder="ID" required autofocus name="id" value="${id}"><BR>
        
        <h5 class="form-signin-heading">비밀번호를 입력해주세요</h5>
        <label for="inputPassword" class="sr-only">Password</label>
        
        <input type="password" id="upw1" class="form-control" placeholder="Password" required name="pwd1"><br>
        <h5 class="form-signin-heading">비밀번호를 확인해주세요</h5>
        <label for="inputPassword" class="sr-only">Password</label>
        
        <input type="password" id="upw2" class="form-control" placeholder="Password" required name="pwd2"><br>
        <p id="msg" style="font-size: 0.8em;"></p>

        <h5 class="form-signin-heading">이름을 알려주세요</h5>
        <label for="inputEmail" class="sr-only">Your ID</label>
        <input type="text" id="uid" class="form-control" placeholder="Name" required autofocus name="name"><BR>
        <h5 class="form-signin-heading">주소를 입력해주세요</h5>
        <label for="inputEmail" class="sr-only">Your ID</label>
        <input type="text" id="uid" class="form-control" placeholder="Address" required autofocus name="add"><BR>
        <h5 class="form-signin-heading">핸드폰번호를 입력해주세요</h5>
        <label for="inputEmail" class="sr-only">Your ID</label>
        <input type="text" id="uid" class="form-control" placeholder="Phone" required autofocus name="phone"><BR>
        <h5 class="form-signin-heading">생년월일을 입력해주세요</h5>
        <label for="inputEmail" class="sr-only">Your ID</label> 	
        <input type="date" id="uid" class="form-control" placeholder="8 Numbers" required autofocus name="date"><BR>

        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block btn-yet">제 출 하 기</button>
      </form>
      
      
		</div>
	</div>

	<div class="modal">
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
	<script>

    let pwd1 = document.getElementById("upw1"); 
    let pwd2 = document.getElementById("upw2"); 

    pwd1.addEventListener('keyup',isSame);
    pwd2.addEventListener('keyup',isSame);

    function isSame(){
        if(pwd1.value!=""&&pwd2.value!=""){
            if (pwd1.value===pwd2.value){
                document.getElementById("msg").style.color = "dodgerblue";
                document.getElementById("msg").innerHTML = "비밀번호가 같음";
                return true;
            }else{
                document.getElementById("msg").style.color = "red";
                document.getElementById("msg").innerHTML = "비밀번호가 틀림";
                return false;
            }
        }
    }
    
	function goRegcall() {
        if(isSame()){
            Regform.submit();
        }else{
            event.preventDefault();
            alert("비밀번호가 같아야합니다.");
        }
		
	}
	</script>  
  </body>
</html>