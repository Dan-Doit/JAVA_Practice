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
  #btn-no{
    background-color: tomato;
    border-color: red;
  }
  #btn-no:hover{
    background-color: red;
    border-color: #ff0020;
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
			<h2 class="card-title text-center" style="color:#113366;">${boinfo.getBo_Title()}</h2>
		</div>
		<div class="card-body">

        <h5 class="form-signin-heading"><strong>작성자 : <span style="color : dodgerblue">${boinfo.getBo_Writer()}</span> 님의글</strong></h5><BR>
        <h5 class="form-signin-heading"><strong>조회수 : <span style="color : dodgerblue">${boinfo.getBo_Hits()}</span></strong></h5><BR>

        <h5 class="form-signin-heading"><strong>첨부파일</strong></h5>
        <img src="fileUpload/${boinfo.getBo_FileName()}" width="200px"><br>${boinfo.getBo_FileName()}<br><br><br>
        <h5 class="form-signin-heading"><strong>내용</strong></h5><br>
        <h5 class="form-signin-heading"><span>${boinfo.getBo_Content()}</span></h5><BR>
          <h5 class="form-signin-heading"><strong>작성시간 : <span style="color : dodgerblue">${boinfo.getBo_Date()}</span></strong></h5><BR>

    <button id="btn-Yes" class="btn btn-lg btn-primary btn-block btn-yet" onclick="goBack()">목록으로가기</button>	<br><br>
    <c:if test="${info.userId eq boinfo.getBo_Userid()}">
    <button id="btn-no" class="btn btn-lg btn-primary btn-block btn-yet" onclick="goMod()">수 정 하 기</button>
    <button id="btn-no" class="btn btn-lg btn-primary btn-block btn-yet" onclick="goDel()">글 삭 제 하 기</button>
    </c:if>


      
      
      
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
    
    	function goBack() {
        event.preventDefault();
        location.href="BoardController?page=${page}";
	  }
    	
    function goMod(){
      event.preventDefault();
      location.href="BoardModifyController?num=${boinfo.getBo_Num()}&title=${boinfo.getBo_Title()}&content=${boinfo.getBo_Content()}&hits=${boinfo.getBo_Hits()}&page=${page}";
    }
    
    function goDel(){
      event.preventDefault();
      location.href="BoardDeleteController?num=${boinfo.getBo_Num()}&id=${info.userId}&page=${page}";
    }



	</script>  
  </body>
</html>