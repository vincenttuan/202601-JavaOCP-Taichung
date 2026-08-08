<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>結帳</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" >
	</head>
	<body class="checkout-page">
		<%@ include file="titlebar.jsp" %>
		<main>
			<h1>確認結帳</h1>
			<div class="panel">
				<c:set var="totalPrice" value="0" />
				<c:forEach var="item" items="${sessionScope.CART}">
					<div class="order-line">
						<c:set var="subPrice" value="${item.key.price * item.value}" />
						
						<span>${item.key.name} x ${item.value}</span>
						<span>$${item.key.price * item.value}</span>
						
						<c:set var="totalPrice" value="${totalPrice + subPrice}" />
					</div>
				</c:forEach>
				<div class="total">
					<span>總金額</span>
					<span>$${totalPrice}</span>
				</div>
			</div>
		</main>
		
	</body>
</html>