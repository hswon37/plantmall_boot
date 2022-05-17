<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>

<html>
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
	  	li {
	  		list-style:none;
	  		display:inline-block;
			position:relative;
			margin:5px 30px;
			padding:0;
			color:black;
		}
		li a {
			display:block;
			margin:0;
			text-decoration:none;
			font-weight:bold;
			color:black;
		}
	</style>
</head>
<body>
<h2>제품 상세</h2>
<div>
 	<table>
		<tr>
			<td rowspan="6" style="border-bottom: none">
				<c:out value="${product.img}" escapeXml="false" />				
			</td><!-- img, 아직 product 테이블에 존재X -->
			<td>제품명</td>
			<td>
				<b><c:out value="${product.name}" /></b>
			</td>
		</tr>
		<tr>
			<td>판매자</td>
			<td><c:out value="${product.userName}" /></td> <!-- 아직 product 테이블에 존재X -->
		</tr>
		<tr>
			<td>가격</td>
			<td><c:out value="${product.price}" /></td>
		</tr>
		<tr>
			<td>배송</td>
			<td>
			6월 20일 (화) 도착 예정<br>
			배송비 0원
			</td><!-- 구현가능할까...? -->
		</tr>
		<tr>
			<td>남은 수량</td>
			<td><span class="product_quantity"><c:out value="${product.quantity}" /></span>개</td>
		</tr>
		<tr>
			<td>주문 수량</td>
			<td class="button_quantity"><!-- html에서 실험결과, +-버튼은 작동X, 키보드로 숫자 직접 입력 시, 총 부분에서 주문수량 업데이트 -->
				<input type="text" class="quantity_input" value="1" id="input_quantity" onchange="printName()" />
				<span>
					<button class="plus_btn">+</button>
					<button class="minus_btn">-</button>
				</span>
			</td>
		</tr>
		<tr>
			<td style="border-bottom: none">총</td><!-- 구현 가능할지 의문. 상품금액x주문수량=총금액, 서버에서 +-작동 확인시 총금액 계산 구현 예정 -->
			<td style="border-bottom: none"><c:out value="${product.price}" /> x <span id="result_quantity"></span> = <b>15,084,000</b></td>
		</tr>
	</table>
	<div align="right">
		<input type="button" value="장바구니">
		<input type="button" value="주문하기">
	</div>
	<div>
		<div align="center">
			<ul>
				<li><a href="productDetail.jsp">제품 설명</a></li>			
				<li>|</li>
				<li><a href="IncludeReview.jsp">리뷰</a></li>
				<li>|</li>
				<li><a href="IncludeEnquiry.jsp">문의</a></li>
			</ul>
		</div>
		<hr>
		<div align="center">
		
			<c:out value="${product.description}" /> <!-- 제품 설명 -->
		</div>
	</div>
</div>
<script>
	//수량 버튼 조작
	let quantity = $(".quantity_input").val();
	$(".plus_btn").on("click", function(){
		if(quantity <= $(".product_quantity")) //남은 수량 만큼 +가능
		$(".quantity_input").val(++quantity);
	});
	$(".minus_btn").on("click", function(){
		if(quantity > 1){
			$(".quantity_input").val(--quantity);	
		}
	});
	
	//총 금액 출력 용
	function printName()  {
	  const name = document.getElementById('input_quantity').value;
	  document.getElementById("result_quantity").innerText = name;
	}
</script>
</body>
</html>
        