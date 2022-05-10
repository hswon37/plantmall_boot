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
body {
	text-align: center;
}
.body {
	display: inline-block;
	width: 1000px;
	margin-top: 200px;
}
.profileImage {
	width: 150px;
	height: 150px;
	border: 1px solid;
	border-radius: 50%;
	background-image: url("/image/..");
}
.followList {
	color: black;
}
.profile {
	padding: 20px 50px;
	text-align: left;
	display: grid;
	grid-template-columns: auto auto;
}
.thumbnail {
	width: 200px;
	height: 200px;
	position: relative;
}
.uploadbtn {
	margin-top: 20px;
}
.name {
	margin-right: 15px;
	font-size: 28px;
	font-weight: 100;
}
.rower * {
	margin-right: 20px;
	display: inline-block;
	
}
.rower {
	margin-top: 20px;
	font-weight: 600;
}
.photo * {
	display: inline-block;
	width: 1fr;
	height: 300px;
	margin: 0 0 15px 0;
}
.photo * * {
	width: 300px;
	margin: 0 15px 0 0;
}
.photobox {
	position: relative;
}
.photobox:hover .photoimage {
	opacity: 0.4;
}
.modal{
	text-align: center;
	
}
.modlatext{
	line-height: 1.5;
}
.modalbtn{
	cursor:pointer;
	background-color:#DDDDDD;
	text-align: center;
	padding-bottom: 10px;
	padding-top: 10px;
	}
</style>
</head>
<body>
	<div class="body">
		<div class="profile">
			<a href="userPage/profile" class="profileImage"></a>
			<div class="text">
				<div class="rower">
					<div class="name">유저</div><%-- ${user.username} --%>
					<c:if test="${id != user.id}">
						<div>
							<!-- Follow 유무 체크필요 -->
							<a href="" class="btn btn-success">팔로우</a>
						</div>
					</c:if>
				</div>
				<div class="rower">
					<div>
						게시물
						<p>${feedCount}10</p>
					</div>
					<div>
						<a href="userPage/follower" class="followList">
							팔로워
							<p>${followerCount }10</p>
						</a>
					</div>
					<div>
						<a href="userPage/following" class="followList">
							팔로우
							<p>${followCount }10</p>
						</a>
					</div>
				</div>
				<div class="rower2">
					<div class="rower3">${user.intro }안녕하세요</div>
				</div>
				<c:if test="${id == user.id}">
					<div>
						<button class="btn btn-success uploadbtn"	
								onclick="location.href=''">제품관리</button>
						<button class="btn btn-success uploadbtn"
							onclick="location.href = 'userPage/upload'">피드추가</button><!-- $('#feedUploadModal').show(); -->
					</div>
				</c:if>
	
			</div>
		</div>

		<hr />

		<div class="photo">

			<!-- photo item -->
			<div class="photo1">
				<c:forEach var="item" items="${feedList}">
					<div class="feedRow">
						<a href="userPage/feed"><img class="feedImage" src="${item.feed}">1</a>
						
					</div>
					<div class="feedRow">
						<a href="userPage/feed"><img class="feedImage" src="${item.feed}">2</a>
					</div>
					<div class="feedRow">
						<a href="userPage/feed"><img class="feedImage" src="${item.feed}">3</a>
					</div>
				</c:forEach>
			</div>

		</div>

	</div>
	
	
	<div id="feedUploadModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
            <p class="modaltext"><br />업로드 할 피드를 선택하세요</p>
            <div class="modalbtn" onClick="location.href = '/sns'">
                <span class="pop_bt" style="font-size: 13pt;" >
                     일상피드
                </span>
            </div>
            <div class="modalbtn" onClick="location.href = '/business'">
                <span class="pop_bt" style="font-size: 13pt;" >
                     판매피드
                </span>
            </div>
      </div>
 
    </div>
    
    <script type="text/javascript">
      
        jQuery(document).ready(function() {
                $('#feedUploadModal').show();
        });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#feedUploadModal').hide();
        };
        
      </script>
</body>
</html>