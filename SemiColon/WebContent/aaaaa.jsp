<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 세션처리 -->
  <c:if test="${info.userId ne null}">


	
	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">${info.userName} 어서오고</h2>
		</div>
		<div class="card-body">
        <h5 class="form-signin-heading"></h5>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" onclick="location.href='BoardController'">게시판</button><BR><BR>
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
</c:if>

<c:if test="${info.userId eq null}">
	<script>
		((){
			alert("로그인 부터 해주세요!");
			location.href="Login.jsp"; 
		})();
	</script>
</c:if>