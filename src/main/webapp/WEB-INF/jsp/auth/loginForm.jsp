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
     <!-- �α��� -->
     <div class="login-wrap">
         <form:form modelAttribute="UserInfo">
             <fieldset>
                 <legend class="ir_su">�α��� �� ���� ����</legend>
                 <div class="login_header">
                     <h5 class="ir_su">�α��� ����</h5>
                     <div class="lh_check">
                         <input type="checkbox" id="infor_check" class="input_check">
                         <label for="infor_check">�α��� ���� ����</label>
                     </div>
                     <div class="lh_ip">
                         IP���� <em>ON</em>
                     </div>
                 </div>
                 <div class="login_content">
                     <h5 class="ir_su">�α��� ����</h5>
                     <div class="lc_text">
                         <label for="uid" class="ir_su">���̵�</label>
                         <form:input type="text" path="userId"/>
                         <form:errors path="userId"/>
                         <!-- <input type="text" id="uid" name="uid" class="input_text" maxlength="20"> -->
                         <label for="upw" class="ir_su">��й�ȣ</label>
                         <form:password path="password"/>
                         <form:errors path="password"/>
                         <!-- <input type="password" id="upw" name="upw" class="input_text" maxlength="20"> -->
                     </div>
                     <input type="submit" value="�α���"/>
                 </div>
                 <div class="login_footer">
                     <h5 class="ir_su">�α��� �����ذ�</h5>
                     <ul>
                         <li><a href=""><strong>ȸ������</strong></a> / </li>
                         <li><a href="">���̵�</a>&middot;<a href="">��й�ȣ ã��</a></li>
                     </ul>
                 </div>
             </fieldset>
         </form:form>
     </div>
     <!-- //�α��� -->
</body>
</html>