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
.wishList {
/* 1200px크기로 가운데에 오도록 */
	margin: 0 auto;
	width: 1200px;
}

.pageTitle {
/* 상단 '장바구니' 텍스트 */
	font-size: 28px;
	text-align: center;
	margin-bottom: 45px;
}

.listCheck {
/* 전체 선택 부분 */
	font-size: 20px;
	padding-bottom: 15px;
}

.cartList {
/* 장바구니 아이템 리스트랑 결제 금액 나타내는 부분 */
	display: flex;
	justify-content: space-between;
	width: 100%;
}

.left {
/* 장바구니 아이템 리스트 부분  */
	width: 800px;
	margin-left: 25px;
	margin-right: 25px;
}

table.cartElement {
/* 장바구니 아이템 리스트 element */
	width: 100%;
	border: solid 1px;
	border-collapse: collapse;
	margin: 0 0 10px;
}

.selectItemBox {
/* 장바구니 아이템 element 하나 선택 */
	padding-top: 20px;
}

.deleteItemBox {
/* 장바구니 아이템 element 하나 삭제 */
	float: right;
	padding-right: 10px;
}
.imgBox {
	display: inline-block;
	width: 150px;
	padding: 20px 20px 10px 0;
	vertical-align: top;
}
.contents {
/* 장바구니 아이템 element 안에 들어가는 이름, 가격, 수량, 총 가격 설정 */
	display: inline-block;
	width: 570px;
	word-break: break-all;
	padding: 20px 0 0 0 ;
	font-size: 16px;
}
.quantityPrice {
/* 장바구니 아이템 element 수량 변경 부분(select, 총 가격) */
	margin-top: 10px;
}
ul {
/* 점, 들여쓰기 없앰 */
	list-style: none;
	padding-left: 0px;
}
li select {
	width: 50px;
	height: 26px;
	font-size: 12px;
	padding: 0 2px;
	text-align: center;
}
.priceSum {
/* 장바구니 아이템 element (수량 * 하나) 가격 값 */
	display: inline;
	float: right;
	font-size: 20px;
}
.right {
/* 전체 주문 금액 부분*/
	flex: 1;
	box-sizing: border-box;
}
table.priceTable {
	width: 100%;
	border: solid 1px;
	border-collapse: collapse;
	margin-bottom: 10px;
}
table.priceTable tr th {
	padding: 5px;
	font-size: 18px;
	border: solid 1px;
	height: 40px;
}
table.priceTable tr td {
	padding: 10px 30px;
}
.txtRight {
	text-align: right;
}
.finalPrice {
	border-top: solid 1px;
	padding: 15px 5px 40px 20px;
	font-size: 20px;
}
.finalPrice span {
	font-size: 27px;
}
</style>
	<script type="text/javascript">
		function getCheckCnt() {
			const query = 'input[name="selectItem"]:checked';
			const selectedEls = document.querySelectorAll(query);

			let result = '';
			let price = document.getElementById('priceSumPrint').innerHTML;
			selectedEls.forEach((el) => {
				result += 1;
				alert(result);
			})
			
			let payAmount = document.getElementById('payAmount').innerHTML;
			alert("getCheckCnt payAmount: " + payAmount);
			
			document.getElementById('quantity').innerHTML = result;
			document.getElementById('payAmount').innerHTML = payAmount + (price * result);
		}
		
		function changeQuantity() {
			var select = document.getElementById("quantitySelect");
			var selectValue = select.options[select.selectedIndex].value;
			var price = document.getElementById('itemPrice').innerHTML;

			document.getElementById('priceSumPrint').innerHTML = selectValue * price;
			document.getElementById('individual_priceSum').value = selectValue * price;
			getCheckCnt();
		}
</script>
</head>
<body>
	<div class="wishList">
		<div class="pageTitle">장바구니</div>
		<div class="listCheck">
			<span> <input type="checkbox" id="selectAll"><label
				for="selectAll"></label>
			</span> <span>전체 선택 / 총 상품 </span> <span> <%-- 				<c:out value="${cart.numberOfItems}" /> --%>
				0개
			</span>
		</div>
		<div class="cartList">
			<div class="left">
				<table class="cartElement">
					<tbody>
						<%-- <c:if test="${cart.numberOfItems == 0}">
							<tr bgcolor="#FFFF88">
								<td colspan="8"><b>장바구니가 비어있습니다.</b></td>
							</tr>
						</c:if> --%>
						<%-- <c:forEach var="cartItem" items="${cart.cartItemList}"> --%>
							<tr>
								<%-- <c:set var="item" value="s${cartItem.item}" /> --%>
								<td><span class="selectItemBox">
										<label for="selectItem"></label>
										<input type="checkbox" class="selectItem" name="selectItem" value="1" onClick="getCheckCnt()">
									</span> 
									<span class="deleteItemBox">
										<input type="button" value='X' />
										<label for="deleteItem"></label>
									</span>
									<div class="cartItemBox">
										<div class="imgBox">
											<!-- <a href=""><img src=""></a> -->
											이미지
										</div>
										<div class="contents">
											<%-- <c:out value="${item.produt.name}" /> --%>
											제품 이름
											<br>
												가격: 
												<span id="itemPrice">16000</span>원<%-- <c:out value="${item.totalPrice}" /> --%>
											<div class="quantityPrice">
												<ul>
													<li>
														수량변경: 
														<select name="quantitySelect" id="quantitySelect" onChange="changeQuantity()">
															<option value="1" selected>1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
															<option value="6">6</option>
															<option value="7">7</option>
															<option value="8">8</option>
															<option value="9">9</option>
															<option value="10">10</option>
														</select>
													</li>
												</ul>
												<div class="priceSum">
													<span id="priceSumPrint"><%-- <c:out value="${item.totalPrice}" /> --%>16000</span> 원
													<input type="hidden" id="individual_priceSum" value="16000">
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
			<!-- left 끝남 -->
			<div class="right">
				<table class="priceTable">
					<tbody>
						<tr>
							<th colspan="2">전체주문금액</th>
						</tr>
						<tr>
							<td> 선택 상품 수 </td>
							<td class="txtRight">
								<span class="quantity" id="quantity">0</span> 개
							</td>
						</tr>
						<tr>
							<td> 배송비 </td>
							<td class="txtRight">
								<span class="deliveryAmount" id="deliveryAmount">3000</span> 원
							</td>
						</tr>
						<tr>
							<td class="finalPrice"> 결제 예정 금액 </td>
							<td class="txtRight finalPrice">
								<span class="payAmount" id="payAmount">0</span> 원
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<a href="" class="button">주문하기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>