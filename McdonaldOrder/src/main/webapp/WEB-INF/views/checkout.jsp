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
					<c:set var="subPrice" value="${item.key.price * item.value}" />
					<div class="order-line">
						<span>${item.key.name} x ${item.value}</span>
						<span>$${item.key.price * item.value}</span>
					</div>
					<c:set var="totalPrice" value="${totalPrice + subPrice}" />
				</c:forEach>
				<div class="total">
					<span>總金額</span>
					<span>$${totalPrice}</span>
				</div>
			</div>
			
			<form method="post" action="${pageContext.request.contextPath}/order">
				<input type="hidden" name="action" value="checkout" />
				
				<label for="customerName">取餐人姓名</label>
				<input type="text" name="customerName" required>
				
				<label for="customerPhone">取餐人電話</label>
				<input type="text" name="customerPhone" required>
				
				<div class="actions">
					<a class="button" href="${pageContext.request.contextPath}/order?action=cart">返回購物車</a>
					<button type="submit">確認結帳</button>
				</div>
				
			</form>
			
		</main>
		
	</body>
</html>