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
  a:hover{
    text-decoration: none;
  }
  .btn-yet{
    background-color: gray;
    border-color: darkgray;
  }

  tr,td{
    
  }

  table{
    width: 100%;
    text-align: center;
    font-size: 1.2rem;
    table-layout: fixed;
    word-break: break-all;
  }

  .card-table{
    width: 100%;
    margin: auto;
    text-align: center;
  }

    </style>
    <title>팀 세미콜론</title>

  </head>

  <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:50rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
      <h2 class="card-title text-center" style="color:#113366;">SEMI 게시판입니다.</h2><br><br><br>
      <div class="card-table">
      <table style="margin: auto;">
`
        <tr>
          <th>글번호</th><th>제목</th><th>작성자</th><th>시간</th><th>조회수</th>
        </tr>
        <c:forEach var = "i" items="${boardList}">
        <tr>
        <td>${i.getBo_Num()}</td>
        <td><a href="BoardDetailController?index=${i.getBo_Num()}&page=${pig.page}&hits=${i.getBo_Hits()}">${i.getBo_Title()}</a></td>
        <td>${i.getBo_Writer()}</td>
        <td>${i.getBo_Date()}</td>
        <td>${i.getBo_Hits()}</td>
        </tr>  
        </c:forEach>
      </table>
      <br><br><br>
      <div class="menu">
      <!-- 1보다 작을경우 이전버튼 -->
		<c:if test="${pig.page<=1}">[이전]&nbsp;</c:if>
		<!-- 1보다 클경우 이전버튼 -->
		<c:if test="${pig.page>1}"><a href="BoardController?page=${pig.page-1}">[이전]</a>&nbsp;</c:if>
		
		<c:forEach begin="${pig.startPage}" end="${pig.endPage}" var="i" step="1">
			&nbsp;
			<c:choose>
				<c:when test="${i eq pig.page}">
					<strong>${i}</strong>
				</c:when>
				<c:otherwise>
					<a href="BoardController?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- 맥스보다 클경우 다음버튼 -->
		<c:if test="${pig.page>=pig.maxPage}">&nbsp;[다음]</c:if>
		<!-- 맥스보다 작을경우 다음버튼 -->
		<c:if test="${pig.page<pig.maxPage}">&nbsp;&nbsp;<a href="BoardController?page=${pig.page+1}">[다음]</a></c:if>
		</div>
    </div>
		</div>
		<div class="card-body">
        <h5 class="form-signin-heading"></h5><br><br>

        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" onclick="location.href='SemiBoardWrite.jsp'">글쓰기</button><BR><BR>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" onclick="location.href='LogoutController'">로그아웃</button><BR><BR>

      
      
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

	</script>  
  </body>
</html>