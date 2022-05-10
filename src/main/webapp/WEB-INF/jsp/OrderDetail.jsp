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
  	width: 100%;
  	line-height: 58px;
    font-size: 18px;
    text-align: center;
    vertical-align: middle;
    box-sizing: border-box;
    cursor: pointer;
    background-color: #555555;
}
a,
a:visited {
  	text-decoration: none;
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

.orderDetail {
	width: 100%;
}
table.orderElement {
	width: 100%;
	border: solid 1px;
	border-collapse: collapse;
}
table.orderElement tr {
	border: solid 1px;
	padding: 20px;
}

.orderContents {
/* 주문 목록 element 안에 들어가는 이미지, 이름, 가격 */
	width: 100%;
	word-break: break-all;
	padding: 10px 10px 0 10px ;
	font-size: 16px;
	display: flex;
}
.imgBox {
	width: 120px;
	height: 120px;
	padding-right: 20px;
}

.content {
	width: 500px;
	font-size: 16px;
}

.itemPrice {
	font-size: 20px;
	float: right;
}
.priceSum {
	padding: 5px 0 5px 0;
	font-size: 20px;
	text-align: center;
}
.formWrap {
	margin-top: 30px;
	margin-bottom: 20px;
}
.formTitle {
	font-size: 20px;
	font-weight: bold;
	paddin-bottom: 15px;
	border-bottom: solid 1px;
}
.formRow {
	box-sizing: border-box;
	border-bottom: solid 1px;
}
.formCol {
	display: inline-block;
	vertical-align: top;
	box-sizing: border-box;
}
.formCol.head {
	width: 170px;
	font-size: 16px;
	padding-top: 17px;
	padding-bottom: 17px;
	border-right: solid 1px;
}
.formCol.body {
	width: 400;
	font-size: 16px;
	padding-top: 17px;
	padding-bottom: 17px;
	padding-right: 15px;
}
</style>
</head>
<body>
<hr>
	<div class="orderPage">
		<div class="pageTitle"><%--<fmt:formatDate value="${order.orderDate}" pattern="yyyy.MM.dd" /></b></td> --%>
		2022.04.09 주문 상세 보기</div>
		<div class="orderDetail">
			<div class="orderList">
				<table class="orderElement">
					<tbody>
						<%-- <c:forEach var="lineItem" items="${order.lineItems}"> --%>
							<tr>
								<td>
									<div class="orderContents">
										<div class="imgBox">
											<!-- <a href=""><img src=""></a> -->
											이미지
										</div>
										<div class="content">
										<%-- <c:out value="${lineItem.item.produt.name}" />--%>
											제품 이름
											<br><br>
											<br><br>
											<span class="quantity">수량: 1개<!-- <c:out value="${lineItem.quantity}" /> --></span>
											<span class="itemPrice">16000원</span><%-- <c:out value="${lineItem.totalprice}" /> --%>
										</div>
									</div>
								</td>
							</tr>
							<%-- </c:forEach> --%>
							<!-- 주문한 제품 목록 출력 끝  -->
							<tr>
								<td class="priceSum"><%-- <b>총 : <c:out value="${order.totalPrice }" /></b> --%>
								총 결제 금액: 16000원</td>
							</tr>
					</tbody>
				</table>
				<div class="orderInfo">
					<div class="formWrap">
						<div class="formTitle">주문자 정보</div>
						<div class="formRow">
							<div class="formCol head">이름</div>
							<div class="formCol body">
							<!--<c:out value="order.userName" />  -->
								<span>서가람</span>
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">휴대폰</div>
							<div class="formCol body">
							<!-- <c:out value="order.phoneNumber" /> -->
								<span>01012345678</span>	
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">이메일</div>
							<div class="formCol body">
								<!-- <c:out value="order.email" /> -->
								<span>fjlskdjf@jsldkfj</span>	
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">주소</div>
							<div class="formCol body">
								<%-- <c:out value="order.billAddress" /> --%>
								<span>주소</span>	
							</div>
						</div>
					</div>
					<!-- 결제 정보 -->
					<div class="formWrap">
						<div class="formTitle">결제 정보</div>
						<div class="formRow">
							<div class="formCol head">카드 타입</div>
							<div class="formCol body">
								<!-- <c:out value="order.cardType" /> -->
								<span>Visa</span>
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">카드 번호</div>
							<div class="formCol body">
								<!-- <c:out value="order.creditCard" /> -->
								<span>999999999999999</span>
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">유호기간 (MM/YY)</div>
							<div class="formCol body">
								<!-- <c:out value="order.expiryDate" /> -->
								<span>09/22</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<a href="" class="button">확인</a>
			</div>
		</div>
	</div>
</body>
</html>