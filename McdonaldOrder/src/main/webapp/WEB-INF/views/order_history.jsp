<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>已結帳訂單</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" >
	</head>
	<body class="history-page">
		<%@ include file="titlebar.jsp" %>
		<main>
			<div class="page-header">
				<h1>已結帳訂單</h1>
				<p>訂單筆數：${orderCount} 筆</p>
			</div>
			<c:forEach var="order" items="${orders}">
				<article class="order-card">
					<div class="order-header">
						<div>
							<span class="label">訂單編號</span>
							<strong>#${order.orderId}</strong>
						</div>
						<div>
							<span class="label">取餐人</span>
							${order.customerName}
						</div>
						<div>
							<span class="label">連絡電話</span>
							${order.customerPhone}
						</div>
						<div>
							<span class="label">結帳時間</span>
							${order.createdAt}
						</div>
						<div>
							<span class="label">總金額</span>
							$${order.totalAmount}
						</div>
						
					</div>
				
				</article>
				
			</c:forEach>
			
		</main>
		
	</body>
</html>