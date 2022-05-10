<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content Page</title>
<style>
	form {
		margin-top: 200px;
		margin-left: 300px;
    	margin-right: 300px;
	    text-align: center;
    }
    .btn-secondary {
    	float: right;
    }
    #feedImg {
    	width: 300px;
    	height: 300px;}
</style>
</head>
<body>
	<form action="." method="post"
	enctype="multipart/form-data">
		<button type="button" class="btn btn-secondary" onclick="">X</button>
		
		<img id="feedImg" />
		<input type="file" id="selectImg" />	
		<script>
		$("#selectImg").on("change", function(event){
				var reader = new FileReader();
				reader.onload = function(event){
					$("feedImg").attr("src", event.target.result);
				}
				reader.readAsDataURL(event.target.files[0]);
			});
		</script>
		<button type="button" class="btn btn-success" onclick="">판매제품선택</button>
		<em>판매제품이름</em>
		<table class="table table-bordered">
			<tr>
				<!-- <td><input type="text" name="feedtext" placeholder="피드 글 입력"  style="width: -webkit-fill-available"></td> -->
				<td><textarea name="feedtext" rows="5" cols="100" placeholder="피드 글 입력"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="완료" style="width: -webkit-fill-available">
	</form>
</body>
</html>