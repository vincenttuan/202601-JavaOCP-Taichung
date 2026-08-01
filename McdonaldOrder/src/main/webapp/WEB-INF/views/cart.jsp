<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>購物車</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" >
	</head>
	<body class="cart-page">
		<%@ include file="titlebar.jsp" %>
		<main>
			<h1>購物車 (${fn:length(sessionScope.CART)}) 件 </h1>
			
			
		</main>
		
	</body>
</html>