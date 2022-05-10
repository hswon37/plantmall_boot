<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

.orderForm {
	/* 1200px크기로 가운데에 오도록 */
	margin: 0 auto;
	width: 1200px;
}

.pageTitle {
	/* 상단 '주문' 텍스트 */
	font-size: 28px;
	text-align: center;
	margin-bottom: 45px;
}

.formTitle {
	/* 주문상품 정보 텍스트*/
	font-size: 20p;
	padding-bottom: 15px;
}

table.orderElement {
	width: 100%;
	border: solid 1px;
	border-collapse: collapse;
	border-spacing: 1px;
}
table.orderElement tr td {
	padding: 20px;
	
}
.imgBox {
	width: 120px;
	height: 120px;
	padding-right: 20px;
}

.content {
	font-size: 16px;
}
dt {
	font-size: 18px;
    font-weight: bold;
}
dd {
	display: block;
	margin-left: 0px;
}
.quantityPrice {
	display: inline; 
	float : right;
	font-size: 20px;
}
.division {
	display:flex;
	justify-content: space-between;
	width: 100%;
}
.left {
/* order form  */
	width: 800px;
	margin-left: 25px;
	margin-right: 25px;
}
.right {
/* 전체 주문 금액 부분*/
	flex: 1;
	box-sizing: border-box;
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
	font-size: 18px;
	padding-top: 17px;
	padding-bottom: 17px;
}
.formCol.body {
	width: calc(100%-170px);
	font-size: 16px;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-right: 15px;
}

.input.default {
	font-size: 16px;
	padding: 11px;
	box-sizing: border-box;
	border: solid 10x;
	vertical-align: middle;
	width: 300px;
}
table.priceTable {
	width: 100%;
	border: solid 1px;
	border-collapse: collapse;
	margin: 45px 0 10px 0;
}
table.priceTable tr th {
	padding: 5px;
	font-size: 21px;
	border: solid 1px;
	height: 40px;
}
table.priceTable tr td {
	padding: 10px 30px;
	font-size: 17px;
}
.txtRight {
	text-align: right;
}
.finalPrice {
	border-top: solid 1px;
	padding: 15px 5px 40px 20px;
	font-size: 21px;
}
.finalPrice span {
	font-size: 25px;
}
</style>
</head>
<body>
	<%-- <c:set var="targetUrl">
		<c:url value="/order/orderSubmitted" />
	</c:set> --%>
	<div class="orderForm">
		<div class="pageTitle">주문</div>
		<div class="formTitle">주문제품 정보</div>
		<table class="orderElement">
			<%-- <c:forEach var="lineItem" items="${order.lineItems}"> --%>
			<tr>
				<td class="imgBox">
					<!-- <a href=""><img src=""></a> -->
					이미지
				</td>
				<td class="content">
					<dl>
						<dt>제품 이름<!-- <c:out value="${lineItem.item.produt.name}" />--></dt>
						<dd>
							제품 가격: 16000원 <br>
							수량: 1개 <br>
							합계: 16000원
						</dd>
					</dl>
				</td>
			</tr>
			<%-- </c:forEach> --%>
		</table>
		<form:form modelAttribute="orderForm" action="${targetUrl}"
			method="post">
			<form:errors cssClass="error" />
			<div class= "division">
				<div class="left">
					<div class="formWrap">
						<div class="formTitle">주문자 정보</div>
						<div class="formRow">
							<div class="formCol head">이름</div>
							<div class="formCol body">
								<%-- <form:input path="order.username" class="input default"/> --%>
								<input type="text" name="order_name" class="input default">
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">휴대폰</div>
							<div class="formCol body">
								<%-- <form:input path="order.phoneNumber"class="input default"/> --%>
								<input type="text" name="order_phoneNumber" class="input default">
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">이메일</div>
							<div class="formCol body">
								<%-- <form:input path="order.email"class="input default"/> --%>
								<input type="text" name="order_emailId" class="input default" value="email@email">
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">주소</div>
							<div class="formCol body">
								<%-- <form:input path="order.billAddress"class="input default"/> --%>
								<input type="text" name="order_billAddress" class="input default" value="주소">
							</div>
						</div>
					</div>
					<!-- 결제 정보 -->
					<div class="formWrap">
						<div class="formTitle">결제 정보</div>
						<div class="formRow">
							<div class="formCol head">카드 타입</div>
							<div class="formCol body">
								<%-- <form:select path="order.cardType"
								items="${creditCardTypes}" /> <form:errors
								path="order.cardType" /> --%>
								<select>
									<option>MasterCard</option>
									<option>Visa</option>
								</select>
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">카드 번호</div>
							<div class="formCol body">
								<%-- <form:input path="order.creditCard" /> <font color="red"
							size="2">* Use a fake number!</font> <form:errors
								path="order.creditCard" /> --%>
								<input type="text" name="order_creditCard" class="input default" value="카드번호">
							</div>
						</div>
						<div class="formRow">
							<div class="formCol head">유호기간 (MM/YY)</div>
							<div class="formCol body">
								<%-- <form:input path="order.expiryDate" /> <form:errors
								path="order.expiryDate" /> --%>
								<input type="text" name="order_expiryDate" class="input default" value="09/22">
							</div>
						</div>
					</div>
				</div>
				<!-- left끝 주문자 정보, 결제 정보 입력 끝  -->
				<div class="right">
					<table class="priceTable">
						<tbody>
							<tr>
								<th colspan="2">전체주문금액</th>
							</tr>
							<tr>
								<td> 주문 상품 수 </td>
								<td class="txtRight">
									<span class="quantity" id="quantity">1</span> 개
								</td>
							</tr>
							<tr>
								<td> 배송비 </td>
								<td class="txtRight">
									<span class="deliveryAmount" id="deliveryAmount">3000</span> 원
								</td>
							</tr>
							<tr>
								<td> 총 상품 금액 </td>
								<td class="txtRight">
									<span>16000</span> 원
								</td>
							</tr>
							<tr>
								<td> <b>결제 예정 금액</b> </td>
								<td class="txtRight finalPrice">
									<span class="payAmount" id="payAmount">19000</span> 원
								</td>
							</tr>
						</tbody>
					</table>
					<div>
						<a href="" class="button">결제하기</a>
						<a href="" class="button">취소하기</a>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>