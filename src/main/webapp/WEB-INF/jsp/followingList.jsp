<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>User Page</title>
    <style>
    .list {
    	text-align: center;
    }
    
    .followingInfo {
    	display: inline-flex;
    	margin-right: 30px;
    }
    .close {
    	margin-right: 350px;
    	text-align: right;
    	
    }

	</style>
</head>
<body>
	<div class="close">
		<button type="button" class="btn btn-secondary">X</button>
	</div>
	<div class="list">
	  <c:forEach var="item" items="${followingList}">
	    <div class="followingInfo"> <img  src="" alt="프로필사진">
	      <p><a href="/userPage/유저아이디" class="followingInfo">유저이름</a></p>
	      	<c:choose class="followingInfo">
	      		<c:when test="${item}">
	      			<button class="btn btn-success followNow">팔로잉</button>	
	      		</c:when>
	      	</c:choose>
	      	
	      <span>삭제</span> </div>
	    </c:forEach>
	    
	</div>
</body>
</html>