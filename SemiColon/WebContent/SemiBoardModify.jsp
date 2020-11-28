<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<div class="card align-middle" style="width:40rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">게시글 수정하기</h2>
		</div>
		<div class="card-body">
      <form class="form-signin" onSubmit="goBoardcall();return false" action="BoardModifyController2" method="POST" name="Modifyform" enctype="multipart/form-data">

        <h5 class="form-signin-heading"><strong>작성자 : <span style="color : dodgerblue">${info.userName}</span> 님의글</strong></h5><BR>
        <h5 class="form-signin-heading">글 제목</h5>
        <input type="text" id="Title" class="form-control" placeholder="${title}" required autofocus name="title">
        <!-- 가리는 정보 아이디, 이름, 글번호, 조회수, 페이지정보 -->
        <input type="hidden" id="uid" class="form-control" value="${info.userId}" name="id"><BR>
        <input type="hidden" id="uid" class="form-control" value="${info.userName}" name="name"><BR>
        <input type="hidden" id="uid" class="form-control" value="${num}" name="num">
        <input type="hidden" id="uid" class="form-control" value="${hits}" name="hits">
        <input type="hidden" id="uid" class="form-control" value="${page}" name="page">
        <h5 class="form-signin-heading">첨부파일</h5>
        <input type="file" id="uid" class="form-control" placeholder="file" autofocus name="file"><BR>
        <h5 class="form-signin-heading">내용</h5>
        <textarea name="content" id ="uid" rows="10" style="resize: none" class="form-control" 
        placeholder="${content}" required autofocus></textarea>
        <br><br>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block btn-yet">수 정 하 기</button>
		<button id="btn-Yes" class="btn btn-lg btn-primary btn-block btn-yet" onclick="goBack()">뒤 로 가 기</button>	
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

    let title = document.getElementById("Title"); 
    
	function goBoardcall() {
		Modifyform.submit();
  }
    	function goBack() {
        event.preventDefault();
        history.go(-1);
	}
	</script>  
  </body>
</html>