<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../jsp/top.jsp" %>
	<div align="center">
		<table>
			<tr>
				<td rowspan="3"><img src="temp.jpg" width="100%"><a href="<c:url value="/plantmall/viewCategory.do?categoryId=BEST"/>">BEST</a></td>
				<td><img src="temp.jpg" width="30%"><a href="<c:url value="/plantmall/viewCategory.do?categoryId=PLANT"/>">식물</a></td>
			</tr>
			<tr>
				<td><img src="temp.jpg" width="30%"><a href="<c:url value="/plantmall/viewCategory.do?categoryId=GARDENING"/>">원예용품</a></td>
			</tr>
			<tr>
				<td><img src="temp.jpg" width="30%"><a href="<c:url value="/plantmall/funding.do"/>">펀딩</a></td>
			</tr>
		</table>
	</div>
	</body>
	</html>

