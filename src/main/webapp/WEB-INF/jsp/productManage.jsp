<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<head>
	<title>식몰</title>
	<style>
		table {
			text-align:center;
		}
	</style>
</head>
<body>
<h2>제품 관리 목록
	<input type="button" value="새 제품 등록" onclick="location.href='<c:url value="/plantmall/productRegistration.do">
    	<c:param name="productId" value="${product.productId}"/></c:url>'">
</h2>
<div align="center">
 	<table>
		<tr>
			<!-- 현재: 한 행당 4개씩이 아닌, 한 행에 모든 제품이 출력되는 형태. 4줄씩 나눠서 출력해야하는데 어떻게하죠? -->
			<c:forEach var="product" items="${productList.pageList}">
				<td>
					<c:out value="${product.img}" escapeXml="false" />			<!-- 이미지도 jpetstore예제 보면 아예 img태그 자체가 db에 저장되어있음.jpetstore/src/main/resources/db/hsqldb/jpetstore.script -->	
					<div><c:out value="${product.userName}" /></div> <!-- product 테이블엔 userName이 존재하지 않음. -->
					<div><c:out value="${product.price}" /></div>					
					<div>	
						<input type="button" value="수정" onclick="location.href='<c:url value="/plantmall/productModify.do">
    						<c:param name="productId" value="${product.productId}"/></c:url>'">
						<input type="button" value="삭제" onclick="location.href='<c:url value="/plantmall/productDelete.do">
    						<c:param name="productId" value="${product.productId}"/></c:url>'">
					</div>
				</td>
			</c:forEach>
		</tr>
	</table>
</div>
</body>
</html>
        