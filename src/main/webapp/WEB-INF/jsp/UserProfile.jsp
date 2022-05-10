<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Profile</title>
<style>
	form {
		margin-top: 300px;
		margin-left: 300px;
    	margin-right: 300px;
	    text-align: center;
    }
    .btn-secondary {
    	float: right;
    }
    #profileImg {
    	width: 300px;
    	height: 300px;}
</style>
</head>
<body>
	<form action="." method="post"
	enctype="multipart/form-data">
		<button type="button" class="btn btn-secondary">X</button>
		
		<img id="profileImg" />
		<input type="file" id="selectImg" />	
		<script>
		$("#selectImg").on("change", function(event){
				var reader = new FileReader();
				reader.onload = function(event){
					$("profileImg").attr("src", event.target.result);
				}
				reader.readAsDataURL(event.target.files[0]);
			});
		</script>
		
		<table class="table table-bordered">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="myId" placeholder="유저 아이디 입력" style="width: -webkit-fill-available"></td>
			</tr>
			<tr>
				<td>소개 글</td>
				<td><input type="text" name="introduce" placeholder="자신을 소개해보세요" style="width: -webkit-fill-available"></td>
			</tr>
		</table>
		<input type="submit" value="완료" style="width: -webkit-fill-available">
	</form>

</body>
</html>