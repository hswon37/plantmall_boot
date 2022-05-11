<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식몰</title>
<style>
.enquiryForm {
	/* 전체 div */
	margin: 0 auto;
	width: 700px;
	padding-top: 100px;
}
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
.formWrap {
	margin-top: 30px;
	margin-bottom: 20px;
}
.write_area {
	border: 1px solid;
}
.formTitle {
	border-bottom: solid 1px;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 10px;
	padding-right: 15px;
}
.formCol.body {
	font-size: 16px;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 10px;
	padding-right: 15px;
}
textarea {
	border: none;
	font-size: 16px;
	width: 100%;
}
textarea:focus {
	outline: none;
}
</style>
<script>
	function MoveFocus() {
		document.rForm.rtitle.focus();
		return;
	}
</script>
</head>
<body onload="MoveFocus();">
	<div class="enquiryForm">
		<%-- <form:form modelAttribute="enquiryForm" action="${targetUrl}" method="post">
			<form:errors cssClass="error" />
			<div class="formWrap">
				<div class="write_area">
					<div class="formTitle">
						<form:textarea path="enquiryTitle" cols="55" rows="1"/>
					</div>
					<div class="formCol body">
						<form:label path="enquiryContent">리뷰 내용</form:label>
						<form:textarea path="enquiryContent" cols="55" rows="20"/>
					</div>
				</div>
				<div>
					<a href="" class="button">리뷰 작성</a>
				</div>
			</div>
		</form:form> --%>
		<form name="rForm">
			<div class="formWrap">
				<div class="write_area">
					<div class="formTitle">
						<textarea path="enquiryTitle" rows="1" placeholder="문의 제목" required></textarea>
					</div>
					<div class="formCol body">
						<textarea path="enquiryContent" rows="20" placeholder="문의 내용" required></textarea>
					</div>
				</div>
				<div>
					<a href="" class="button">문의 작성</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>