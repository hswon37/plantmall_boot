<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
     <!-- 로그인 -->
     <div class="login-wrap">
         <form action='<c:url value="/auth/login"/>' method="POST">
             <fieldset>
                 <legend class="ir_su">로그인 및 관련 설정</legend>
                 <div class="login_header">
                     <h5 class="ir_su">로그인 보안</h5>
                     <div class="lh_check">
                         <input type="checkbox" id="infor_check" class="input_check">
                         <label for="infor_check">로그인 상태 유지</label>
                     </div>
                     <div class="lh_ip">
                         IP보안 <em>ON</em>
                     </div>
                 </div>
                 <div class="login_content">
                     <h5 class="ir_su">로그인 영역</h5>
                     <div class="lc_text">
                         <label for="uid" class="ir_su">아이디</label>
                         <input type="text" name="email" size="20">
                         <!-- <input type="text" id="uid" name="uid" class="input_text" maxlength="20"> -->
                         <label for="upw" class="ir_su">비밀번호</label>
                         <input type="password" name="password" size="20">
                         <!-- <input type="password" id="upw" name="upw" class="input_text" maxlength="20"> -->
                     </div>
                     <input type="submit" value="로그인"/>
                 </div>
                 <div class="login_footer">
                     <h5 class="ir_su">로그인 문제해결</h5>
                     <ul>
                         <li><a href=""><strong>회원가입</strong></a> / </li>
                         <li><a href="">아이디</a>&middot;<a href="">비밀번호 찾기</a></li>
                     </ul>
                 </div>
             </fieldset>
         </form>
     </div>
     <!-- //로그인 -->
</body>
</html>