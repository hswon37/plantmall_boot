<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식몰</title>
<style>
a.button {
	display: inline-block;
	margin-bottom: 10px;
	width: 50px;
	line-height: 30px;
	font-size: 16px;
	text-align: center;
	vertical-align: middle;
	box-sizing: border-box;
	background-color: lightgray;
}

a, a:visited {
	text-decoration: none;
}

.includeReview {
	width: 1200px;
	margin: 0 auto;
}

.reviewElements {
	width: 1000px;
	margin: 0 0 10px;
}
.review {
	width: 1000px;
	/* display: inline-block; */
	vertical-align: top;
	overflow: hidden;
	height : auto;
	border-bottom: solid 1px;
	padding: 20px 5px;
	word-break: break-all;
}
.nameDate {
	font-size: 18px;
	font-weight: bold;
}
.button {
	float: right;
}
</style>
</head>
<body>
	<div class="includeReview">
		<table class="reviewElements">
			<tbody>
				<%-- <c:if test="${reviewList.numberOfItems == 0}">
							<tr bgcolor="#FFFF88">
								<td colspan="8"><b>장바구니가 비어있습니다.</b></td>
							</tr>
						</c:if> --%>
				<%-- <c:forEach var="review" items="${review.reviewList}"> --%>
				<tr>
					<td>
						<div class="review">
							<div class="nameDate">
								서가람 <!--<c:out value="review.userName" />  -->
								<span>2022-4-15</span>
							</div>
							<p>리뷰 내용</p>
							<%-- <c:if test="${}">
								세션 검사해서 리뷰 작성한 회원이면 수정 버튼 보이게
							</c:if> --%>
							<a href="" class="button">수정</a>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="review">
							<div class="nameDate">
								서가람 <!--<c:out value="review.userName" />  -->
								<span>2022-4-15</span>
							</div>
							<p>내용ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							
							</p>
							<%-- <c:if test="${}">
								세션 검사해서 리뷰 작성한 회원이면 수정 버튼 보이게
							</c:if> --%>
						</div>
					</td>
				</tr>
				<%-- </c:forEach> --%>
			</tbody>
		</table>
	</div>
</body>
</html>