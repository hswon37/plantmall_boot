<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식몰</title>
<style>
a {
	text-decoration-line: none;
}

.orderPage {
	/* 전체 div */
	margin: 0 auto;
	width: 700px;
}

.pageTitle {
	/* 상단 '주문 목록' 텍스트 */
	font-size: 28px;
	text-align: center;
	margin-bottom: 30px;
}

table.orderElement {
	width: 100%;
	border: solid 1px;
	border-collapse: collapse;
	border-spacing: 1px;
}
tr {
	border-top: solid 1px;
	border-collapse: collapse;
}
.orderInfo {
/* 주문 내역 상단 날짜, 주문번호, 주문 상세보기 링크 */
	padding: 5px;
}
.orderDateText {
	text-align: left;
	padding-right: 20px;
	font-size: 20px;
}
.orderDetailPage {
	float: right;
	text-align: right;
	padding-right: 10px
}
.orderContents {
/* 주문 목록 element 안에 들어가는 이미지, 이름, 가격 */
	width: 700px;
	word-break: break-all;
	padding: 10px 0 0 0 ;
	font-size: 16px;
	display: flex;
}
.imgBox {
	width: 100px;
	height: 100px;
	padding-right: 15px;
}
.content {
	font-size: 18px;
}
.itemPrice {
	font-size: 16px;
}
</style>
</head>
<body>
	<hr>
	<div class="orderPage">
		<div class="pageTitle">주문 목록</div>
		<div class="orderList">
			<table class="orderElement">
				<tbody>
					<%-- <c:if test="${orderList.length == 0}">
						<tr bgcolor="#FFFF88">
							<td colspan="8"><b>주문 목록이 비어있습니다.</b></td>
						</tr>
					</c:if> --%>
					<%-- <c:forEach var="order" items="${orderList}"> --%>
						<tr>
							<td>
								<div class="orderInfo">
									<span class="orderDateText"><b>2022.04.09
									<%--<fmt:formatDate value="${order.orderDate}" pattern="yyyy.MM.dd" /></b></td> --%>
									</b></span>
									<span class="orderIdText">주문번호(orderId)<!-- <c:out value="${order.orderId}" /> --></span>
									<span class="orderDetailPage"><%--<a href='<c:url value="/order/viewOrderDetail"> <c:param name="orderId" value="${order.orderId}"/></c:url>' --%>
									<a href="">주문 상세보기</a></span>
								</div>
								<div class="orderContents">
									<div class="imgBox">
										<!-- <a href=""><img src=""></a> -->
										이미지
									</div>
									<div class="content">
									<%-- <c:set var="itemList" value="${order.lineItems}." />
 											<c:out value="${itemList[0].item.product.name}" />
 											<c:if test="${fn:length(itemList) > 1}">
					 							<c:out value=" 외 " />
				 								<c:out value="${fn:length(itemList) - 1}" />
											</c:if> --%>
										{주문한 첫번째 상품 이름} 외 {주문한 상품 리스트의 길이 - 1}개
										<br><br><br>
										<span class="itemPrice">16000원</span><%-- <c:out value="${order.totalPrice}" /> --%>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="orderInfo">
									<span class="orderDateText"><b>2022.04.09
									<%--<fmt:formatDate value="${order.orderDate}" pattern="yyyy.MM.dd" /></b></td> --%>
									</b></span>
									<span class="orderIdText">주문번호(orderId)<!-- <c:out value="${order.orderId}" /> --></span>
									<span class="orderDetailPage"><%--<a href='<c:url value="/order/viewOrderDetail"> <c:param name="orderId" value="${order.orderId}"/></c:url>' --%>
									<a href="">주문 상세보기</a></span>
								</div>
								<div class="orderContents">
									<div class="imgBox">
										<!-- <a href=""><img src=""></a> -->
										이미지
									</div>
									<div class="content">
									<%-- <c:set var="itemList" value="${order.lineItems}." />
 											<c:out value="${itemList[0].item.product.name}" />
 											<c:if test="${fn:length(itemList) > 1}">
					 							<c:out value=" 외 " />
				 								<c:out value="${fn:length(itemList) - 1}" />
											</c:if> --%>
										{주문한 첫번째 상품 이름} 외 {주문한 상품 리스트의 길이 - 1}개
										<br><br><br>
										<span class="itemPrice">16000원</span><%-- <c:out value="${order.totalPrice}" /> --%>
									</div>
								</div>
							</td>
						</tr>
					<%-- </c:forEach> --%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>