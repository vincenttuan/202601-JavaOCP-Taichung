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
					<!-- 訂單主檔資料 -->
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
					
					<!-- 訂單明細資料 -->
					<table>
						<thead>
							<tr>
								<th>商品</th><th>單價</th><th>數量</th><th>小計</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${order.items}">
								<tr>
									<td>${item.productName}</td>
									<td>${item.unitPrice}</td>
									<td>${item.quantity}</td>
									<td>${item.subtotal}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
				</article>
				
			</c:forEach>
			
		</main>
		
	</body>
</html>