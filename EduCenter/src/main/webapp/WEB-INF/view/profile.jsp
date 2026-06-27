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
		<form class="pure-form" method="post" action="/EduCenter/profile">
			<fieldset>修改基本資料</fieldset>
			全名: <input type="text" name="username" placeholder="請輸入全名" value="<%=member.getFullname() %>" required /><p />
			密碼: <input type="password" name="password" placeholder="請輸入密碼" value="<%=member.getPassword() %>" required /><p />
			郵件: <input type="email" name="email" placeholder="請輸入email" value="<%=member.getEmail() %>" /><p />
			角色: <select name="role">
					<option value="USER" <%=member.getRole().equals("USER")?"selected":"" %>>USER</option>
					<option value="ADMIN" <%=member.getRole().equals("ADMIN")?"selected":"" %>>ADMIN</option>
				</select><p />
			<button type="submit" class="pure-button pure-button-primary">修改</button>
		</form>
	</body>
	
	<jsp:include page="footer.jsp" />
	
</html>