<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;"><span style="background-color: #339966; color: #333333;">회원 가입을 축하합니다</span></h1>
<table style="border-collapse: collapse; width: 86.8707%; height: 204px; margin-left: auto; margin-right: auto;" border="1">
<tbody>
<tr style="height: 18px;">
<td style="width: 25%; text-align: center; height: 18px;">ID</td>
<td style="width: 75%; text-align: center; height: 18px;">${completedUser.userId}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 25%; text-align: center; height: 18px;">NAME</td>
<td style="width: 75%; text-align: center; height: 18px;">${completedUser.userName}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 25%; text-align: center; height: 18px;">EMAIL</td>
<td style="width: 75%; text-align: center; height: 18px;">${completedUser.email}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 25%; text-align: center; height: 18px;">PHONE</td>
<td style="width: 75%; text-align: center; height: 18px;">${completedUser.phone}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 25%; text-align: center; height: 18px;">ZIPCODE</td>
<td style="width: 75%; text-align: center; height: 18px;">${completedUser.zipcode}</td>
</tr>
<tr style="height: 18px;">
<td style="width: 25%; text-align: center; height: 18px;">ADDRESS</td>
<td style="width: 75%; text-align: center; height: 18px;">${completedUser.address }</td>
</tr>
</tbody>
</table>
<p style="text-align: center;"><button> 메인으로</button></p>
</body>
</html>