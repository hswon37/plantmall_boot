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
<form:form modelAttribute="userForm" method="post">
		     <label for="uid" class="ir_su">아이디</label>
		    <form:input type="text" path="user.userId"/>
		    <form:errors path="user.userId"/>
		  
		    <label for="pw" class="ir_su">비밀번호</label>
		    <form:password path="user.password"/>
		    <form:errors path="user.password"/>
		  
		  <label for="userName" class="ir_su">userName</label>
		    <form:input type="text" path="user.userName"/>
		    <form:errors path="user.userName"/>
		  
		  <label for="email" class="ir_su">이메일</label>
		    <form:input type="text" path="user.email"/>
		    <form:errors path="user.email"/>
		  
		  <label for="phone" class="ir_su">핸드폰</label>
		    <form:input type="text" path="user.phone"/>
		    <form:errors path="user.phone"/>
		  
		  <label for="zipcode" class="ir_su">우편번호</label>
		    <form:input type="text" path="user.zipcode"/>
		    <form:errors path="user.zipcode"/>
		  
		  <label for="address" class="ir_su">주소</label>
		    <form:input type="text" path="user.address"/>
		    <form:errors path="user.address"/>
		<input type="submit" value="로그인"/>
</form:form>

</body>
</html>