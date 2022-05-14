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
	    border: 1px solid #444444;
	    padding: 10px;
	  }
	</style>
</head>
<body>
<h2>제품 검색</h2>
<div>
 	<table>
		<tr>
			<td>카테고리 선택</td>
			<td>
				<select name="category" value="${pageMaker.cri.category}">
					<option value="꽃">꽃</option>
					<option value="야생화">야생화</option>
					<option value="허브">허브</option>
					<option value="나무">나무</option>
					<option value="다육">다육</option>
					<option value="해조">해조</option>
					<option value="선택안함">선택안함</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>검색어</td>
			<td><input type="text" name="name" value="${pageMaker.cri.name}"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td>
				<input type="text" name="lowPrice" value="${pageMaker.cri.lowPrice}">~<input type="text" name="highPrice" value="${pageMaker.cri.highPrice}">원
			</td>
		</tr>
		<tr>
		
	</table>
	<div align="center">
		<input type="button" value="검색">
	</div>
</div>
</body>
</html>
        