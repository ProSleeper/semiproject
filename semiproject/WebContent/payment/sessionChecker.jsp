<%@ page contentType="text/html; charset=euc-kr" %> 
<jsp:useBean id="sc" class="com.cart.SessionChecker" scope="application" /> 
<% 
    session.setMaxInactiveInterval(60); // �� ����� ���� ����;��.. 60�� 
    sc.setSession(session); 
	out.println("���� ������ �� : " + sc.getNowUser()); 
%> 