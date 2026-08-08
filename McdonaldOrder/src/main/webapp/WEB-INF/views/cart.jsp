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
			<h1>購物車 (${sessionScope.cartCount}) 件 </h1>
			
			<div class="cart">
				<table>
					<thead>
						<tr>
							<th>商品</th>
							<th>單價</th>
							<th>數量</th>
							<th>小計</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<!-- 1.初始化總金額 = 0 -->
						<c:set var="totalPrice" value="0" />
						
						<c:forEach var="item" items="${sessionScope.CART}">
							<tr>
								<td>
									<img valign="bottom" width="50" src="data:${item.key.imageType};base64,${item.key.imageBase64}" alt="${item.key.name}">
									${item.key.name}
								</td>
								<td>$${item.key.price}</td>
								<td>
								
									<input class="quantity" type="number" min="0" max="${item.key.stock}" value="${item.value}" />
									
								</td>
								<td>
									<!-- 2.初始化小計 -->
									<c:set var="subPrice" value="${item.key.price * item.value}" />
									${subPrice}
								</td>
								<td>
									<form method="post" action="${pageContext.request.contextPath}/order">
										<input type="hidden" name="action" value="remove">
										<input type="hidden" name="productId" value="${item.key.id}">
										<button class="remove" type="submit">移除</button>
									</form>
								</td>
							</tr>
							<!-- 3.將小計累加到總金額 -->
							<c:set var="totalPrice" value="${totalPrice + subPrice}" />
						</c:forEach>
					</tbody>
				</table>
				
				<div class="summary">
					<span>合計</span>
					<span>$${totalPrice}</span>
				</div>
				
			</div>
			
		</main>
		
	</body>
</html>