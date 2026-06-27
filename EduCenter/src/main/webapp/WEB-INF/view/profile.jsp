<%@page import="model.entity.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Member member = (Member)session.getAttribute("member");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員中心</title>
	</head>
	
	<jsp:include page="header.jsp" />
	
	<body class="container">
		<h2>會員中心</h2>
		<div class="pure-form">
			<fieldset>
				<legend>基本資料</legend>
				帳號: <%=member.getUsername() %><p />
				全名: <%=member.getFullname() %><p />
				郵件: <%=member.getEmail() %><p />
				角色: <%=member.getRole() %><p />
			</fieldset>
		</div>
	</body>
	
	<jsp:include page="footer.jsp" />
	
</html>