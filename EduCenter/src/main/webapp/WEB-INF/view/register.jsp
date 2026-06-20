<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	// 取得 controller 來的訊息
	String msg = (String)request.getAttribute("msg");
	if(msg == null) msg = "";
%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>會員註冊(Register)</title>
	</head>
	
	<jsp:include page="header.jsp" />
	
	<body class="container">
		
		<h2>會員註冊</h2>
		
		<form class="pure-form" method="post" action="/EduCenter/register">
			
			帳號: <input type="text" name="username" placeholder="請輸入帳號" required /><p />
			密碼: <input type="password" name="password" placeholder="請輸入密碼" required /><p />
			全名: <input type="text" name="fullname" placeholder="請輸入全名" required /><p />
			郵件: <input type="email" name="email" placeholder="請輸入電子郵件信箱" required /><p />
			角色: <input type="radio" name="role" value="USER" checked /> User(使用者)
				 <input type="radio" name="role" value="ADMIN" /> Admin(管理者)<p />
			
			<button type="submit" class="pure-button pure-button-primary">註冊</button>
			<button type="reset" class="pure-button">重置</button>
			
		</form>
		
		<h2 style="color: red"><%=msg %></h2>
		
	</body>
	
	<jsp:include page="footer.jsp" />
	
</html>