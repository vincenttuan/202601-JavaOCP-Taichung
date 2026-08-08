<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>結帳完成</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" >
	</head>
	<body class="checkout-page">
		<%@ include file="titlebar.jsp" %>
		<main>
			<h1>結帳完成</h1>
			<p>訂單已成功寫入資料庫 !</p>
			
			<a class="button" href="${pageContext.request.contextPath}/order">繼續點餐</a>
		</main>
		
	</body>
</html>