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
	width: 100px;
	line-height: normal;
	font-size: 16px;
	text-align: center;
	vertical-align: middle;
	box-sizing: border-box;
	background-color: lightgray;
	padding: 7px 15px;
}

a, a:visited {
	text-decoration: none;
}

.includeEnquiry {
	width: 1200px;
	margin: 0 auto;
}
.createEnq {
	position: relative;
	border-top: solid 1px lightgray;
	border-bottom: solid 1px lightgray;
	padding: 25px 8px;
	margin: 0;
}
.navSideBtn{
	position: absolute;
	right: 3px;
	top: 7px;
}
div.miniTab>span {
	padding-right: 15px;
	font-size: 14px;
	height: 18px;
}
div.miniTab>span:first-child {
	font-weight: bold;
}
.question {
	font-size: 16px;
	font-weight: bold;
	overflow: hidden;
	height : auto;
	border-bottom: solid 1px lightgray;
	padding: 0 5px 10px 5px;
	word-break: break-all;
}
.replyCell {
	padding: 10px 30px;
	line-height: 22px;
	border-top: 1px solid lightgray;
}
.info {
	line-height: 22px;
}
.replyText{
	margin: 10px;
	overflow: hidden;
	height : auto;
	word-break: break-all;
}
td {
	border-bottom: 1px solid;
}
</style>
</head>
<body>
	<div class="includeEnquiry">
		<div class="createEnq">
			<div class="navSideBtn">
				<a href="" class="button">문의하기</a>
			</div>
		</div>
		<table class="enquiryElements">
			<tbody>
				<%-- <c:if test="${enquiry.numberOfItems == 0}">
							<tr bgcolor="#FFFF88">
								<td colspan="8"><b>장바구니가 비어있습니다.</b></td>
							</tr>
						</c:if> --%>
				<%-- <c:forEach var="enquiry" items="${enquiry.enquiryList}"> --%>
				<tr>
					<td>
						<div class="enquiry">
							<div class="miniTab">
								<span>서가람 <!--<c:out value="enquiry.userName" />  --></span>
								<span>2022-04-15</span>
								<%-- <c:if test="${}">
								세션 검사해서 문의 작성한 회원 + 답변 안 달렸으면 수정 버튼 보이게
								</c:if> --%>
								<a href="" class="button">수정하기</a>
								<%-- <c:if test="${}">
								세션 검사해서 판매 회원이면 + 답변 없으면 답변 버튼 보이게
								</c:if> --%>
								<a href="" class="button">답변하기</a>
							</div>
							<div class="question">
								Q
								문의내역
								<!--<c:out value="enquiry.enquiry" /> -->
							</div>
							<div class="answer">
								<div class="replyCell">
									<div class="info">
										판매 회원 이름 <!--<c:out value="product.userName" /> -->
									</div>
									<div class="replyText">
										답변답변
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="enquiry">
							<div class="miniTab">
								<span>sdfsd <!--<c:out value="enquiry.userName" />  --></span>
								<span>2022-04-15</span>
							</div>
							<div class="question">
								Q
								내용ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							
								<!--<c:out value="enquiry.enquiry" /> -->
							</div>
							<div class="answer">
								<div class="replyCell">
									<div class="info">
										판매 회원 이름 <!--<c:out value="product.userName" /> -->
									</div>
									<div class="replyText">
										내용ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
							
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
				<%-- </c:forEach> --%>
			</tbody>
		</table>
	</div>
</body>
</html>