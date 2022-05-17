<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
SIGNUPFORM
<form:form modelAttribute="UserInfo" method="post">
		    <label for="uid" class="ir_su">아이디</label>
		    <form:input type="text" path="userId"/>
		    <form:errors path="userId"/>
		  
		    <label for="pw" class="ir_su">비밀번호</label>
		    <form:password path="password"/>
		    <form:errors path="password"/>
		  
		  <label for="userName" class="ir_su">userName</label>
		    <form:input type="text" path="userName"/>
		    <form:errors path="userName"/>
		  
		  <label for="email" class="ir_su">이메일</label>
		    <form:input type="text" path="email"/>
		    <form:errors path="email"/>
		  
		  <label for="phone" class="ir_su">핸드폰</label>
		    <form:input type="text" path="phone"/>
		    <form:errors path="phone"/>
		  
		  <label for="zipcode" class="ir_su">우편번호</label>
		    <form:input type="text" path="zipcode"/>
		    <form:errors path="zipcode"/>
		  
		  <label for="address" class="ir_su">주소</label>
		    <form:input type="text" path="address"/>
		    <form:errors path="address"/>
		<input type="submit" value="로그인"/>
</form:form>

</body>
</html>