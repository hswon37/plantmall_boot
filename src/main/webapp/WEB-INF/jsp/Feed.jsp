<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content Page</title>
<style>
	.feed {
		margin-top: 200px;
		margin-left: 300px;
    	margin-right: 300px;
	    text-align: center;
	    
    }
    .btn-secondary {
    	float: right;
    }
    
    .content1 .content2{
    	display: inline-block
    }
    #feedContentImg {
    	width: 300px;
    	height: 300px;
    	margin-right: 156px;
    }
    
    .comments {
    	float: right;
    	border: 1px solid black;}
    
    .feedContentText {
    	
    	margin-right: 260px;
    	}
   
</style>
</head>
<body>
	<div class=feed>
		<button type="button" class="btn btn-secondary" onclick="">X</button>
		<button type="button" class="btn btn-secondary" onclick="/userPage/upload">설정</button>
		<div class="content1"><!-- 평행으로 묶기 -->
			<img id="feedContentImg" />
			<p class="comments"></p>
		</div>
		<hr>
		<button type="button" class="btn btn-success" onclick="">제품보러가기</button>
		
		<div class="content2"><!-- 평행으로 묶기 -->
			<span class="feedContentText">피드소개</span>
			<span onclick="">💖</span><input type="text" class="comment" placeholder="댓글입력">
		</div>
	</div>
</body>
</html>