<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品訂購</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" >
	</head>
	<body class="order-page">
		<!-- 上方標題列 -->
		<%@ include file="titlebar.jsp" %>
		
		<!-- 訂購商品主頁內容 -->
		<main class="order-container">
		
			<div class="page-title">
				<h1>商品訂購</h1>
				<p>請選擇您要訂購的餐點</p>
			</div>
			
			<div class="order-links">
				<a class="cart-link" href="${pageContext.request.contextPath}/order?action=history">
					查看已結帳訂單
				</a>
				<a class="cart-link" href="${pageContext.request.contextPath}/order?action=cart">
					🛒 查看購物車（0）
				</a>
			</div>
			
		</main>
		
		<!-- 漢堡類 BURGER -->
		<section class="category-section">
		
			<div class="category-title">
				<h2>🍔 漢堡類</h2>
				<span>BURGER</span>
			</div>
			
			<div class="product-grid">
				<c:forEach var="product" items="${products}">
					
					<c:if test="${product.category == 'BURGER' }">
						<article class="product-card">
							
							<!-- 商品圖片 -->
							<div class="product-image-box">
								<span class="product-id">
									#${product.id}
								</span>
								
								<img class="product-image" src="data:${product.imageType};base64,${product.imageBase64}" alt="${product.name}">
								
							</div>
							
							<!-- 商品資訊 -->
							<div class="product-info">
							
								<!-- 商品名稱 -->
								<h3 class="product-name">
									${product.name}
								</h3>
								
								<!-- 商品 meta 資訊 -->
								<div class="product-meta">
									
									<div class="product-price">
										$${product.price}
										<small>元</small>
									</div>
								
									<span class="stock">
										庫存 ${product.stock}
									</span>
								</div>
								
								<!-- 商品訂購表單 -->
								<form class="order-form" method="post" action="${pageContext.request.contextPath}/order">
									<input type="hidden" name="action" value="insert" />
									<input type="hidden" name="productId" value="${product.id}" />
									<button class="order-button" type="submit">
										加入購物車
									</button>
								</form>
								
								
							</div>
							
							
						</article>
						
					</c:if>
					
				</c:forEach>
			
			</div>
			
			
		</section>
		
		<!-- 小點類 SNACK -->
		<section class="category-section">
		
			<div class="category-title">
				<h2>🍟 小點類</h2>
				<span>SNACK</span>
			</div>
		
		</section>
		
		<!-- 飲品類 DRINK -->
		<section class="category-section">
		
			<div class="category-title">
				<h2>🥤 飲品類</h2>
				<span>DRINK</span>
			</div>
		
		</section>
		
	</body>
</html>









