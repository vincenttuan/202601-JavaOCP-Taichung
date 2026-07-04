<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String result = (String)request.getAttribute("result");
	if(result == null) result = "";
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員登入(Login)</title>
	</head>
	
	<jsp:include page="header.jsp" />
	
	<body class="container">
		
		<h2>會員登入</h2>
		
		<form class="pure-form" method="post" action="/EduCenter/login">
			帳號: <input type="text" name="username" placeholder="請輸入帳號" required /><p /> 
			密碼: <input type="password" name="password" placeholder="請輸入密碼" required /><p />
			
			<input type="number" name="code" placeholder="請輸入認證碼" /> 
			<img src="/EduCenter/code" valign="middle" alt="沒有認證碼" title="我是認證碼"> <p />
			
			<button type="submit" class="pure-button pure-button-primary">登入</button>
		</form>
		
		<%=result %>
		
	</body>
	
	<jsp:include page="footer.jsp" />
	
</html>