<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<head>
	<title>식몰</title>
	<style>
	  table {
	    width: 100%;
	    border-collapse: collapse;
	  }
	  td {
	    border-bottom: 1px solid #444444;
	    padding: 10px;
	  }
	</style>
</head>
<body>
<h2>제품 등록</h2>
<div>
	<form action="/plantmall/productRegistration" method="post" id="enrollForm">
	 	<table>
			<tr>
				<td rowspan="6" style="border-bottom: none; border:1px solid;">
					<input type="file" name="image">				
				</td>
				<td>제품명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price">원</td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td>
					<select name="category">
						<option value="꽃">꽃</option>
						<option value="야생화">야생화</option>
						<option value="허브">허브</option>
						<option value="나무">나무</option>
						<option value="다육">다육</option>
						<option value="해조">해조</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="quantity">개</td>
			</tr>
			<tr>
				<td style="border-bottom: none">제품 설명</td>
				<td style="border-bottom: none">
					<textarea cols="50" rows="10" placeholder="제품의 상세 설명을 작성해주세요" name="description"></textarea>
				</td>
			
			</tr>
			<tr>
				<td style="border-bottom: none"></td>
				<td style="border-bottom: none"></td>
				<td style="border-bottom: none">
					<input type="button" value="등록" onclick="alert('해당 제품을 등록 하시겠습니까?')" id="enrollBtn">
				</td>
			</tr>
		</table>
	</form>
</div>
<script>
/* 상품 등록 버튼 */
$("#enrollBtn").on("click",function(e){
	
	e.preventDefault();
	
	enrollForm.submit();
	
});
</script>
</body>
</html>
        