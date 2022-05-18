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
<h2>제품 목록</h2>
<div align="center">
  카테고리: <a href="#">꽃</a> | <a href="#">야생화</a> | <a href="#">허브</a> | <a href="#">나무</a> | <a href="#">다육</a> | <a href="#">해조</a>
	<h2><c:out value="${category.name}" /></h2>
	<table>
		<tr>
		<!-- 현재: 한 행당 4개씩이 아닌, 한 행에 모든 제품이 출력되는 형태. 4줄씩 나눠서 출력해야하는데 어떻게하죠? -->
			<c:forEach var="product" items="${productList.pageList}">
				<td>
					<a href='<c:url value="/plantmall/productDetail.do"><c:param name="productId" value="${product.productId}"/></c:url>'>
						<c:out value="${product.img}" escapeXml="false" />			<!-- 이미지도 jpetstore예제 보면 아예 img태그 자체가 db에 저장되어있음.jpetstore/src/main/resources/db/hsqldb/jpetstore.script -->	
						<div><c:out value="${product.userName}" /></div> <!-- product 테이블엔 userName이 존재하지 않음. -->
						<div><c:out value="${product.name}" /></div>
						<div><c:out value="${product.price}" /></div>
					</a>
				</td>
			</c:forEach>
		</tr>
	</table>
</div>
</body>
</html>
        